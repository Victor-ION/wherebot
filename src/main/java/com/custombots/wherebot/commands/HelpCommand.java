package com.custombots.wherebot.commands;

public class HelpCommand implements Command{
    @Override
    public String getAnswer(String command) {
        return  "what' up, pipl? type:\n" +
                "/where - ur current/soonest lesson's location\n" +
                "/whereNext - next after current lesson\n" +
                "/listDay - today's all lessons\n" +
                "/listNextDay - tomorrow's all lessons\n" +
                "/listMon - Mon all lessons\n" +
                "/listTue - Tue all lessons\n" +
                "/listWed - Wed all lessons\n" +
                "/listThu - Thu all lessons\n" +
                "/listFri - Fri all lessons\n";
    }
}
