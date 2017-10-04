package com.custombots.wherebot;

import com.custombots.wherebot.utils.TokenDownloader;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Paths;

public class TokenDownloaderTest extends Assert {
//    @Ignore
    @Test
    public void testPath() {
        String result = TokenDownloader.getToken();
        assertEquals("320896835:AAHhPDVYBEr_xXd8mUhPKuCuSLxRaxvP6eQ", result);

    }
}
