package com.custombots.wherebot.commands;

import com.custombots.wherebot.model.DayOfWeek;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class WhereNextCommandTest {

    @Test
    public void returnCheck() {
       WhereCommand whereCommand = new WhereCommand();
        System.out.println(whereCommand.getAnswer("/where"));
        System.out.println(new WhereNextCommand().getAnswer("/whereNext"));
    }

    @Test
    public void getSortedDaysListTest(){
        List<DayOfWeek> list = CommandsExecutor.getWeek().getList();
        list.add(new DayOfWeek("Tuesday", Collections.emptyList()));
        list.sort( (o1, o2) -> o1.castToStandardDayOfWeek().compareTo(o2.castToStandardDayOfWeek()));
        for (DayOfWeek d : list){
            System.out.println(d);
        }
    }


}