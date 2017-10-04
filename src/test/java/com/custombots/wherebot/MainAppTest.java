package com.custombots.wherebot;

import com.custombots.wherebot.commands.Command;
import com.custombots.wherebot.commands.CommandsExecutor;
import com.pengrad.telegrambot.model.Update;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CommandsExecutor.class)
public class MainAppTest extends Assert {

    @Test
    public void testAnsweringMsg() throws Exception{
       /* PowerMockito.mockStatic(CommandsExecutor.class);
        PowerMockito.when(CommandsExecutor.execute(anyString())).thenReturn("it's test");
        MainApp.main(null);*/

        /*PowerMockito.spy(CommandsExecutor.class);
        PowerMockito.when(CommandsExecutor.class, "execute", "/help").thenReturn("it's test");
        MainApp.main(null);*/   // AssertionError


        //PowerMockito.when(MainApp.class, "sendAnswer", (Update) any(), (String) any());
        /*List mock = mock(List.class);
        assertEquals(mock.size(), 0);
        verify(mock, atLeast(1)).size();
        when(mock.size()).thenReturn(2);
        assertNotEquals(mock.size(), 1);
        doReturn("aa").when(mock).get(eq(0));
        assertEquals(mock.get(0), "aa");*/
    }
}
