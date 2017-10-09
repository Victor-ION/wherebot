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

public class WhereCommand implements Command{
    @Override
    public String getAnswer(String command) {
        Lesson resLesson = null;
        LocalDateTime currentDateTime = LocalDateTime.now();
        String currentDayStr = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        for (Iterator<DayOfWeek> itr = CommandsExecutor.getWeek().getList().listIterator(); itr.hasNext();){
            DayOfWeek day = itr.next();
            if (day.getName().equals(currentDayStr)){
                LocalTime currentTime = currentDateTime.toLocalTime();
                for (Lesson l : day.getSortedLessonsList()){
                    // if current time is before the end of the lesson
                    if (l.getTime().plus(l.getDurationInMinutes(), ChronoUnit.MINUTES).isAfter(currentTime)) {
                        resLesson = l;
                        break;
                    }
                }
                // when current time is after all lessons - return "no current lessons for today"
                if (resLesson == null){
                    return "no current lessons for today";
                }
                break;
            }
        }
        return resLesson.toString();
    }


    }
