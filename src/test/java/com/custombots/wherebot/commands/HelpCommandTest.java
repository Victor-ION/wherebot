package com.custombots.wherebot.commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelpCommandTest {
    @Test
    public void getAnswer() throws Exception {
        // to generate help string for botFather
        System.out.println(new HelpCommand().getAnswer("/help"));
    }

}