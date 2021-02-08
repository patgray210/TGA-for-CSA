package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {

    List<String> list_of_cards_anxiety;
    List<String> list_of_cards_anger;
    List<String> list_of_cards_depression;
    List<String> list_of_cards_pts;
    List<String> list_of_cards_dissociation;
    List<String> list_of_cards_sexual_concerns;
    List<String> list_of_cards_wild_card;

    TextView questions;

    int choosen = 0;
    public static int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_questions);

        questions = findViewById(R.id.question);
        choosen = getIntent().getExtras().getInt("stat");
        list_of_cards_anxiety = new ArrayList<>();
        list_of_cards_anxiety.add("How do you know when you feel worried?");
        list_of_cards_anxiety.add(("Where do you feel worry in your body?"));
        list_of_cards_anxiety.add(("How do you know when you feel scared?"));
        list_of_cards_anxiety.add(("Where do you feel fear in your body?"));
        list_of_cards_anxiety.add(("What are the things that are scary to you?"));
        list_of_cards_anxiety.add(("What are the things you worry about?"));
        list_of_cards_anxiety.add(("Who helps you when you are scared?"));
        list_of_cards_anxiety.add(("What would life be like if you did not worry anymore?"));
        list_of_cards_anxiety.add(("Is the worry helpful or harmful?"));
        list_of_cards_anxiety.add(("What is the difference between worry and fear?"));
        list_of_cards_anxiety.add(("How often do you feel worry?"));
        list_of_cards_anxiety.add(("How often do you feel fearful?"));
        list_of_cards_anxiety.add(("Do you often worry that something bad will happen soon?"));


        list_of_cards_anger = new ArrayList<>();
        list_of_cards_anger.add(("How do you know that you are angry?"));
        list_of_cards_anger.add(("What actions make you angry?"));
        list_of_cards_anger.add(("What happens in your body when you get angry?"));
        list_of_cards_anger.add(("Who do you trust to talk to when you are angry?"));
        list_of_cards_anger.add(("What helps you the most when you feel very angry?"));
        list_of_cards_anger.add(("What helps the most when you are feeling somewhat angry?"));
        list_of_cards_anger.add(("Does your anger ever make you feel like hurting yourself"));
        list_of_cards_anger.add(("Does your anger ever make you feel like hurting someone else?"));
        list_of_cards_anger.add(("Who do you dislike most and why?"));
        list_of_cards_anger.add(("When was the last time you raised your voice when you were angry?"));
        list_of_cards_anger.add(("When was the last time you isolated yourself or avoided others when feeling angry?"));
        list_of_cards_anger.add(("How would others describe you when you are angry?"));
        list_of_cards_anger.add(("Does anyone in your life pick fights with you? Who?"));
        list_of_cards_anger.add(("Do you pick fights with anyone in your life? Who?"));
        list_of_cards_anger.add(("How long does it take to feel calm after getting very angry?"));
        list_of_cards_anger.add(("Do you believe you are a mean person?"));
        list_of_cards_anger.add(("Do you believe others think you are a mean person?"));

        list_of_cards_depression = new ArrayList<>();
        list_of_cards_depression.add(("What makes you cry?"));
        list_of_cards_depression.add(("When was the last time you cried?"));
        list_of_cards_depression.add(("Do you like yourself?"));
        list_of_cards_depression.add(("Do you believe others like you?"));
        list_of_cards_depression.add(("Do you believe others enjoy spending time with you?"));
        list_of_cards_depression.add(("Have you ever purposefully hurt yourself? When? How?"));
        list_of_cards_depression.add(("What helps you when you are feeling sad?"));
        list_of_cards_depression.add(("Who do you trust to talk to when you are feeling sad?"));
        list_of_cards_depression.add(("What do you like about yourself?"));
        list_of_cards_depression.add(("What makes you feel guilty?"));
        list_of_cards_depression.add(("What makes you feel shameful?"));
        list_of_cards_depression.add(("Have you ever blamed yourself for bad things that have happened to you?"));
        list_of_cards_depression.add(("When do you feel lonely?"));
        list_of_cards_depression.add(("What thoughts contribute to feelings of sadness?"));
        list_of_cards_depression.add(("What actions contribute to feelings of sadness?"));
        list_of_cards_depression.add(("When you feel sad, how long does the sadness usually last?"));
        list_of_cards_depression.add(("Do you know anyone who has purposefully harmed themselves?"));
        list_of_cards_depression.add(("Do you know anyone who has died by suicide?"));
        list_of_cards_depression.add(("What are your beliefs regarding self-harm?"));
        list_of_cards_depression.add(("What are your beliefs regarding suicide"));

        list_of_cards_pts = new ArrayList<>();
        list_of_cards_pts.add(("Are there people you avoid seeing?"));
        list_of_cards_pts.add(("Are there things you avoid doing?"));
        list_of_cards_pts.add(("What happens when you see someone who have been trying to avoid?"));
        list_of_cards_pts.add(("What happens when you are asked to do something you have been trying to avoid?"));
        list_of_cards_pts.add(("Do you ever have thoughts that are hard to get out of your head? What are they?"));
        list_of_cards_pts.add(("When was the last time you had a bad dream?"));
        list_of_cards_pts.add(("Tell me about the last bad dream you had."));
        list_of_cards_pts.add(("What do you do when you have difficult thoughts?"));
        list_of_cards_pts.add(("What do you do when you have bad dreams?"));
        list_of_cards_pts.add(("Do you ever try to avoid feeling sad? How?"));
        list_of_cards_pts.add(("Do you every try to avoid feeling angry? How?"));
        list_of_cards_pts.add(("Do you ever try to avoid feeling scared? How?"));
        list_of_cards_pts.add(("What is your worst memory? Why?"));
        list_of_cards_pts.add(("When do you notice difficult feelings or thoughts?"));
        list_of_cards_pts.add(("Are memories of the abuse foggy or clear?"));


        list_of_cards_dissociation = new ArrayList<>();
        list_of_cards_dissociation.add(("Do you daydream?"));
        list_of_cards_dissociation.add(("What happens when you daydream?"));
        list_of_cards_dissociation.add(("Do you ever feel as if you have lost periods of time?"));
        list_of_cards_dissociation.add(("Would you say you are forgetful?"));
        list_of_cards_dissociation.add(("What types of things do you forget?"));
        list_of_cards_dissociation.add(("When do you notice you are most forgetful?"));
        list_of_cards_dissociation.add(("Tell me a story you have created while daydreaming?"));
        list_of_cards_dissociation.add(("Have you ever felt like you were outside of or separate from yourself?"));
        list_of_cards_dissociation.add(("Have you ever desired or pretended to be someone else? Who?"));
        list_of_cards_dissociation.add(("Have you ever pretended to be somewhere else? Where?"));
        list_of_cards_dissociation.add(("Is it difficult to talk about emotions?"));
        list_of_cards_dissociation.add(("Is it difficult to talk about the sexual abuse that occurred?"));
        list_of_cards_dissociation.add(("Is it difficult to feel emotions?"));
        list_of_cards_dissociation.add(("Do some emotions feel safer than others to access?"));
        list_of_cards_dissociation.add(("Do you ever feel numb?"));

        list_of_cards_sexual_concerns = new ArrayList<>();
        list_of_cards_sexual_concerns.add(("Are there places or experiences that trigger memories your sexual abuse? What are they?"));
        list_of_cards_sexual_concerns.add(("Are you fearful of sexual abuse occurring again?"));
        list_of_cards_sexual_concerns.add(("Do you ever feel to blame for the sexual abuse? Why?"));
        list_of_cards_sexual_concerns.add(("Do you still have to see your abuser?"));
        list_of_cards_sexual_concerns.add(("Do you think about sex? If so, what are the thoughts?"));
        list_of_cards_sexual_concerns.add(("Do you ever experience sexual feelings in your body?"));
        list_of_cards_sexual_concerns.add(("Do you ever feel like you have sexual impulses you cannot control?"));
        list_of_cards_sexual_concerns.add(("Do you ever feel like you have thoughts regarding sex that you cannot get out of your head?"));
        list_of_cards_sexual_concerns.add(("How do you feel when you hear others talking about sex?"));
        list_of_cards_sexual_concerns.add(("Are there safe areas of your body that others may touch?"));
        list_of_cards_sexual_concerns.add(("Are there boundaries you want to implement that may help you feel safer?"));
        list_of_cards_sexual_concerns.add(("Do you have particular fears regarding men or women?"));
        list_of_cards_sexual_concerns.add(("Do you believe that others intend to hurt you?"));


        list_of_cards_wild_card = new ArrayList<>();
        list_of_cards_wild_card.add(("What brings you joy?"));
        list_of_cards_wild_card.add(("What is your favorite memory? Why?"));
        list_of_cards_wild_card.add(("Name 3 things that you like about yourself"));
        list_of_cards_wild_card.add(("Name 3 things that you believe you do well."));
        list_of_cards_wild_card.add(("What are qualities of someone who is trustworthy?"));
        list_of_cards_wild_card.add(("What are qualities of a good friend?"));
        list_of_cards_wild_card.add(("Describe a place that brings feelings of safety or comfort (can be imagined or real)? What makes that place special?"));
        list_of_cards_wild_card.add(("Breathe."));
        list_of_cards_wild_card.add(("Who or what brings you comfort?"));
        list_of_cards_wild_card.add(("What are some favorite things to do for fun?"));
        list_of_cards_wild_card.add(("Who do you like to spend time with the most?"));
        list_of_cards_wild_card.add(("When do you need to be alone?"));
        list_of_cards_wild_card.add(("When do you most want to be with others?"));
        list_of_cards_wild_card.add(("Tell me about the last thing you created."));
        list_of_cards_wild_card.add(("Tell me about your favorite song."));
        list_of_cards_wild_card.add(("What would you say to a friend that experienced sexual abuse?"));
        list_of_cards_wild_card.add(("Create a mantra or saying that may be helpful when you are experiencing difficult thoughts or feelings."));
        list_of_cards_wild_card.add(("If you could have any superpower what would it be?"));


        if(choosen == 0){
            questions.setText(String.valueOf(list_of_cards_anxiety.get(index)));
            index++;
        }
        if(choosen == 1){
            questions.setText(String.valueOf(list_of_cards_anger.get(index)));
            index++;
        }

        if(choosen == 2){
            questions.setText(String.valueOf(list_of_cards_pts.get(index)));
            index++;
        }
        if(choosen == 3){
            questions.setText(String.valueOf(list_of_cards_dissociation.get(index)));
            index++;
        }
        if(choosen == 4){
            questions.setText(String.valueOf(list_of_cards_sexual_concerns.get(index)));
            index++;
        }
        if(choosen == 5){
            questions.setText(String.valueOf(list_of_cards_wild_card.get(index)));
            index++;
        }


    }
}
