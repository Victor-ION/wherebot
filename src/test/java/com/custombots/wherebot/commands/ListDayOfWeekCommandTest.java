package com.custombots.wherebot.commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListDayOfWeekCommandTest {
    @Test
    public void getAnswer() throws Exception {
        ListDayOfWeekCommand command = new ListDayOfWeekCommand();
        System.out.println(command.getAnswer("/listMon"));
    }

}