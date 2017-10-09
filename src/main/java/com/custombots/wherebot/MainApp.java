package com.custombots.wherebot;


import com.custombots.wherebot.commands.CommandsExecutor;
import com.custombots.wherebot.utils.LogsToFile;
import com.custombots.wherebot.utils.TokenDownloader;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import java.util.Date;
import java.util.List;

public class MainApp {
    private final static String TOKEN = TokenDownloader.getToken();
    public final static String PATH_TO_SRC_SCHEDULE = "src/main/jsonSrc/phys_chem.txt";
    private static TelegramBot bot;

    public static LogsToFile logs = LogsToFile.getLogsToFile();

    public static void main(String[] args) {
        bot = TelegramBotAdapter.build(TOKEN);
        bot.setUpdatesListener(new UpdatesListener() {
            public int process(List<Update> list) {
                for (Update update : list) {
                    System.out.println(update.message().date());
                    System.out.println(update.message().forwardDate());
                    Date date = new Date(update.message().date());
                    System.out.println(date);
//                    System.out.println(update.message().text());
                    logs.log(update);
                    String answer = CommandsExecutor.execute(update.message().text());
//                    System.out.println("a:  " + answer);
                    if (!answer.equals(CommandsExecutor.NO_MATCHES)) {
                        sendAnswer(update, answer);
                        logs.log(answer);
                    }
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });

        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("ss");
            while (!"exit".equals(reader.readLine())){
                System.out.println("rrrr");
                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bot.removeGetUpdatesListener();
        }*/


    }

    public static void sendAnswer(Update update, String answer) {
        SendMessage request = new SendMessage(update.message().chat().id(), answer)
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(false)
                .replyToMessageId(update.message().messageId());
        //.replyMarkup(new ForceReply());
        BaseResponse response = bot.execute(request);
//        System.out.println("resp" + response.isOk());
    }
}
