package com.example.final_check;

public class patient_data {

    private String name;
    private String mental_health;
    private String sex;

    private String age;
    private String id;


    public patient_data() {
    }

    public patient_data(String name, String mental_health, String sex, String age, String id) {
        this.name = name;
        this.mental_health = mental_health;
        this.sex = sex;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMental_health() {
        return mental_health;
    }

    public void setMental_health(String mental_health) {
        this.mental_health = mental_health;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
