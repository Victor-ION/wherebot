package com.custombots.wherebot.commands;

public class WhereCommand implements Command{
    @Override
    public String getAnswer(String command) {
        return "where";
    }
}
