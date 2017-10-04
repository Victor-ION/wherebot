package com.custombots.wherebot.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class TokenDownloader {
    public static String getToken(){
        try {
            StringBuilder sb = new StringBuilder();

            FileReader reader = new FileReader(new File(TokenDownloader.class.getResource("Token.properties").toURI()));
            while (reader.ready()){
                sb.append(reader.read());
            }
            return sb.toString();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
