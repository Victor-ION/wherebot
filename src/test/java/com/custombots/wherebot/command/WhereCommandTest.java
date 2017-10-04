package com.custombots.wherebot.command;

import com.custombots.wherebot.commands.CommandsExecutor;
import org.junit.Assert;
import org.junit.Test;

public class WhereCommandTest extends Assert{
    @Test
    public void testExecute(){
        String expected = CommandsExecutor.execute("/where");
        assertEquals(expected, "where");
    }
}
