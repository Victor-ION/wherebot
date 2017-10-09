package com.custombots.wherebot.utils;

import com.custombots.wherebot.model.DayOfWeek;
import com.custombots.wherebot.model.Lesson;
import com.custombots.wherebot.model.Week;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class should run if creating source Json files is needed
 */
public class JSONSourceCreator {
    private final static String PATH_TO_OUTPUT = "src/main/jsonSrc/phys_chem.txt";

    public static void main(String[] args) {


        try (FileWriter writer = new FileWriter(PATH_TO_OUTPUT)) {
            List<DayOfWeek> list = new ArrayList<>();
            list.add(getMonday());
            list.add(getTuesday());
            list.add(getWednesday());
            list.add(getThursday());
            list.add(getFriday());

            Week week = new Week(list);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, week);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DayOfWeek getMonday() {
        List<Lesson> monLessons = new ArrayList<>();
        monLessons.add(new Lesson("Фіз.мет.(Л)", "08-20", 120, "518"));
        monLessons.add(new Lesson("Гетер. каталіз", "09-50", 120, "501"));
        monLessons.add(new Lesson("Гетер. каталіз", "11-30", 120, "317a"));

        return new DayOfWeek("Monday",monLessons);
    }
    private static DayOfWeek getTuesday() {
        List<Lesson> monLessons = new ArrayList<>();
        monLessons.add(new Lesson("Екоправозн./Правозн.", "08-20", 120, "316/228"));
        monLessons.add(new Lesson("Фіз.мет.", "09-50", 120, "406"));
        monLessons.add(new Lesson("---", "11-30", 120, "---"));
        monLessons.add(new Lesson("Мет.виклад.", "12-50", 120, "228а"));

        return new DayOfWeek("Tuesday",monLessons);
    }
    private static DayOfWeek getWednesday() {
        List<Lesson> monLessons = new ArrayList<>();
        monLessons.add(new Lesson("Кол.хім./ Метод.викл.(Л)", "08-20", 120, "316"));
        monLessons.add(new Lesson("Кінетика", "09-50", 120, "407"));
        monLessons.add(new Lesson("Кінетика", "11-30", 120, "407"));

        return new DayOfWeek("Wednesday",monLessons);
    }
    private static DayOfWeek getThursday() {
        List<Lesson> monLessons = new ArrayList<>();
        monLessons.add(new Lesson("Екотехн. (Л)", "08-20", 120, "316"));
        monLessons.add(new Lesson("Екотехн.", "09-50", 120, "316"));
        monLessons.add(new Lesson("Матеріалозн.", "11-30", 120, "501"));
        monLessons.add(new Lesson("Матеріалозн.", "12-50", 120, "501"));

        return new DayOfWeek("Thursday",monLessons);
    }
    private static DayOfWeek getFriday() {
        List<Lesson> monLessons = new ArrayList<>();
        monLessons.add(new Lesson("Ізотопи", "08-20", 120, "316"));
        monLessons.add(new Lesson("Колоїдна хім.", "09-50", 120, "308"));
        monLessons.add(new Lesson("Колоїдна хім.", "11-30", 120, "308"));

        return new DayOfWeek("Friday",monLessons);
    }

}
