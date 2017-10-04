package com.custombots.wherebot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@JsonAutoDetect
public class Lesson {
    String name;
    String timeStr;
    Long durationInMinutes;
    String classroom;

    @Override
    public String toString() {
        return String.format("%s");
    }
/*
    public static LocalTime getLocalTime(String timeStr){
        LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH-mm"));
    }*/
}
