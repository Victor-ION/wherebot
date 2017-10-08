package com.custombots.wherebot.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public final class TokenDownloader {
    public static String getToken() {
        String token = "";

        try {
            Properties properties = new Properties();

            FileReader reader = new FileReader("src/main/java/com/custombots/wherebot/utils/token.properties");
            properties.load(reader);
//            FileReader reader = new FileReader(new File(TokenDownloader.class.getResource("/resource/Token.properties").toURI()));
            token = properties.getProperty("token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token;
    }
}
