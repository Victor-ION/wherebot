package com.custombots.wherebot.utils;

import com.pengrad.telegrambot.model.Update;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogsToFile {
    private static final String PATH_TO_LOGS_FILE = "src/main/java/com/custombots/wherebot/utils/logs.txt";
    private BufferedWriter writer;
    public LogsToFile() throws IOException{
        writer = new BufferedWriter(new FileWriter(PATH_TO_LOGS_FILE));

    }

    public void log(Update update){
        StringBuffer sb = new StringBuffer();
        sb.append("date: ");
        sb.append(update.message().date() + "\n");
        sb.append("text: ");
        sb.append(update.message().text() + "\n");
        sb.append("--------------------------\n");

        try {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void log(String answer){
        try {
            writer.write("botAnswer:\n" + answer + "\n--------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogsToFile getLogsToFile(){
        try {
            return new LogsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
