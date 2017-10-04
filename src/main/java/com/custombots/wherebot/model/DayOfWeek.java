package com.custombots.wherebot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class DayOfWeek {
    String name;

    @JsonDeserialize(as = ArrayList.class, contentAs = DayOfWeek.class)
    List<Lesson> lessons;
}
