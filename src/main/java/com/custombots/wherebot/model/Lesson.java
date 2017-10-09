package com.custombots.wherebot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


        // Date will be in String with format "HH-mm"
@JsonAutoDetect
public class Lesson {
    public Lesson(){}
    private String name;
    private String timeStr;
    private int durationInMinutes = 120;
    private String classroom;


            public Lesson(String name, String timeStr, int durationInMinutes, String classroom) {
                this.name = name;
                this.timeStr = timeStr;
                this.durationInMinutes = durationInMinutes;
                this.classroom = classroom;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTimeStr() {
                return timeStr;
            }

                    /// careful! jackson can auto add some new fields for getMethods
            @JsonIgnore
            public LocalTime getTime(){
                return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH-mm"));
            }

            public void setTimeStr(String timeStr) {
                this.timeStr = timeStr;
            }

            public int getDurationInMinutes() {
                return durationInMinutes;
            }

            public void setDurationInMinutes(int durationInMinutes) {
                this.durationInMinutes = durationInMinutes;
            }

            public String getClassroom() {
                return classroom;
            }

            public void setClassroom(String classroom) {
                this.classroom = classroom;
            }

            @Override
    public String toString() {
        return String.format("%s : (%s) : %s", timeStr, classroom, name);
    }

        }
