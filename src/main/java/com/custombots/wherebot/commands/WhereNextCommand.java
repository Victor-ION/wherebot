package com.custombots.wherebot.commands;

import com.custombots.wherebot.model.DayOfWeek;
import com.custombots.wherebot.model.Lesson;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WhereNextCommand implements Command {
    @Override
    public String getAnswer(String command) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String currentDayStr = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        for (Iterator<DayOfWeek> itr = CommandsExecutor.getWeek().getSortedDaysList().listIterator(); itr.hasNext();){
            DayOfWeek day = itr.next();
            if (day.getName().equals(currentDayStr)){
                LocalTime currentTime = currentDateTime.toLocalTime();
                for (Lesson l : day.getSortedLessonsList()){
                    // if current time is before the start of the lesson
                    if (l.getTime().isAfter(currentTime)) {

                        return l.toString();
                    }
                }
                // when current time is after all lessons - return the first lesson from the next day

                day = itr.next();
                return "|| " + day.getName() + " ||\n" + day.getSortedLessonsList().get(0).toString();

            }
        }
        return null;
    }




}
