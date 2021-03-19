package com.example.final_check;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {

    Context mContext;
    List<patient_data> mData;


    public RecyclerViewAdapter(Context mContext, List<patient_data> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    interface Listener{
        void onClick(int position);
    }




    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_cardview, parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final patient_data data = mData.get(position);

        holder.tv_name.setText(data.getName());
        //holder.tv_id.setText(data.getId());
        holder.tv_mental_health.setText(data.getMental_health());
        //holder.tv_sex.setText(data.getSex());
        //holder.tv_age.setText(data.getAge());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView tv_name;
        private TextView tv_mental_health;
       // private TextView tv_id;
        //private TextView tv_sex;
        //private TextView tv_age;

        private CardView cardView;

        public MyViewHolder(View v){
            super(v);

            cardView = (CardView) v.findViewById(R.id.patient_card_view);
            tv_name = (TextView) v.findViewById(R.id.patient_name);
            //tv_age = (TextView) v.findViewById(R.id.patient_age);
            //tv_id = (TextView) v.findViewById(R.id.patient_id);
            //tv_sex = (TextView) v.findViewById(R.id.patient_sex);
            tv_mental_health = (TextView) v.findViewById(R.id.patient_mental_health);


        }
    }
}
