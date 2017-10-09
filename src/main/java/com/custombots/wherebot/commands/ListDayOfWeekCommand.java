package com.custombots.wherebot.commands;

import com.custombots.wherebot.model.DayOfWeek;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class ListDayOfWeekCommand implements Command {
    @Override
    public String getAnswer(String command) {
        // command = "/list...",  e.g. "/listMon"
        return getDayOfWeekSchedule(command.substring(5));
    }


    private String getDayOfWeekSchedule(String dayOfWeekStr) {
        //for /listDay and /listNextDay  convert to current or next day designation
        if (dayOfWeekStr.equals("Day")){
            dayOfWeekStr = LocalDateTime.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        }
        else if (dayOfWeekStr.equals("NextDay")){
            dayOfWeekStr = LocalDateTime.now().plusDays(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        }

        for (DayOfWeek day : CommandsExecutor.getWeek().getList()) {
            if (day.getName().substring(0, 3).equals(dayOfWeekStr)) return day.toString(); // substring for Mon, Tue, etc
        }
        return "no such day in schedule";
    }
}
