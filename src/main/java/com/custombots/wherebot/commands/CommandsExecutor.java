package com.custombots.wherebot.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsExecutor {
    public static final String NO_MATCHES = "no matches";
    private static Map<String, Command> commandMap = new HashMap<>();
    static {
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
    public static String execute(String command){
        if (commandMap.containsKey(command)) return commandMap.get(command).getAnswer(command);
        else return NO_MATCHES;
    }
}
