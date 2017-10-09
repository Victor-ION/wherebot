package com.custombots.wherebot.commands;

import com.custombots.wherebot.MainApp;
import com.custombots.wherebot.model.Week;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandsExecutor {
    public static final String NO_MATCHES = "no matches";
    private static Map<String, Command> commandMap = new HashMap<>();

    private static Week week = downloadWeek();

    public static Week getWeek() {
        return week;
    }

    private static Week downloadWeek() {
        try (FileReader reader = new FileReader(MainApp.PATH_TO_SRC_SCHEDULE)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, Week.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static {
        commandMap.put("/start", new HelpCommand());
        commandMap.put("/help", new HelpCommand());
        commandMap.put("/where", new WhereCommand());
        commandMap.put("/whereNext", new WhereNextCommand());
        commandMap.put("/listDay", new ListDayOfWeekCommand());
        commandMap.put("/listNextDay", new ListDayOfWeekCommand());
        commandMap.put("/listMon", new ListDayOfWeekCommand());
        commandMap.put("/listTue", new ListDayOfWeekCommand());
        commandMap.put("/listWed", new ListDayOfWeekCommand());
        commandMap.put("/listThu", new ListDayOfWeekCommand());
        commandMap.put("/listFri", new ListDayOfWeekCommand());
    }

    public static String execute(String command) {
        if (commandMap.containsKey(command)) return commandMap.get(command).getAnswer(command);
        else return NO_MATCHES;
    }
}
