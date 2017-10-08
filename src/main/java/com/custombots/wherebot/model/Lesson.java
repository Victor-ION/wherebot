package com.custombots.wherebot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


        // Date will be in String with format "HH-mm"
@JsonAutoDetect
public class Lesson {
    String name;
    String timeStr;
    Long durationInMinutes = 120L;
    String classroom;

    @Override
    public String toString() {
        return String.format("%s : (%s) : %s", timeStr, classroom, name);
    }

    public static LocalTime getLocalTime(String timeStr){
        LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH-mm"));
        return time;
    }
}
