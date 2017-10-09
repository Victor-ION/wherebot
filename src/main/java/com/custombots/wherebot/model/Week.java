package com.custombots.wherebot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class Week {
    public Week(){}
    @JsonDeserialize(as = ArrayList.class, contentAs = DayOfWeek.class)
    private List<DayOfWeek> list;

    public List<DayOfWeek> getList() {
        return list;
    }

    public void setList(List<DayOfWeek> list) {
        this.list = list;
    }

    public Week(List<DayOfWeek> list) {

        this.list = list;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (DayOfWeek dayOfWeek : getSortedDaysList()){
            sb.append(dayOfWeek);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    @JsonIgnore
    public List<DayOfWeek> getSortedDaysList(){
        list.sort( (o1, o2) -> o1.castToStandardDayOfWeek().compareTo(o2.castToStandardDayOfWeek()));
        return list;
    }
}
