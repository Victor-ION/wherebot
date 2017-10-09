package com.custombots.wherebot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@JsonAutoDetect
public class DayOfWeek {
    public DayOfWeek(){}
    private String name;

    @JsonDeserialize(as = ArrayList.class, contentAs = Lesson.class)
    private List<Lesson> lessons;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|| "+ name +" ||" + System.lineSeparator());
        for (Lesson l : getSortedLessonsList()){
            sb.append(l);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public DayOfWeek(String name, List<Lesson> lessons) {
        this.name = name;
        this.lessons = lessons;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getName() {

        return name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }


    public java.time.DayOfWeek castToStandardDayOfWeek(){

        return java.time.DayOfWeek.valueOf(this.getName().toUpperCase());
    }
    @JsonIgnore
    public List<Lesson> getSortedLessonsList(){
        //        lessons.sort(new Comparator<Lesson>() {
//            @Override
//            public int compare(Lesson o1, Lesson o2) {
//                return o1.getTimeStr().compareTo(o2.getTimeStr());
//            }
//        });

//        lessons.sort( (o1,o2) -> o1.getTimeStr().compareTo(o2.getTimeStr()));

        lessons.sort(Comparator.comparing(Lesson::getTimeStr));
        return lessons;
    }
}
