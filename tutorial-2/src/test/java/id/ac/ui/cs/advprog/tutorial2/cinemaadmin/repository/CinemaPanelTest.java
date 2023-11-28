package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.repository;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACOffCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac.AC;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.lamp.Lamp;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.Devices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CinemaPanelTest {
    private CinemaPanel cinemaPanel;
    private Devices devices;
    private Field commandsField;

    @BeforeEach
    public void setUp() throws Exception {
        cinemaPanel = new CinemaPanel();
        devices = new Devices(new AC("AC"), new Lamp("Lamp"), new Screen("Screen"));
        commandsField = CinemaPanel.class.getDeclaredField("commands");
        commandsField.setAccessible(true);

    }

    @Test
    public void whenAddCommandMethodIsCalledShouldAddCommand() throws Exception {
        Map commands;

        commands = (Map) commandsField.get(cinemaPanel);
        assertEquals(0, commands.size());

        String commandName = "AC Off";
        Command command = Mockito.mock(Command.class);
        when(command.getCommandName()).thenReturn(commandName);

        cinemaPanel.addCommand(command);

        commands = (Map) commandsField.get(cinemaPanel);
        assertEquals(1, commands.size());
    }

    @Test
    public void whenExecuteIsCalledItShouldExecuteTheCorrectCommand() {
        String commandName = "AC Off";
        Command command = Mockito.mock(Command.class);
        when(command.getCommandName()).thenReturn(commandName);
        cinemaPanel.addCommand(command);

        cinemaPanel.execute(commandName);
        verify(command, times(1)).execute();
    }

    @Test
    public void whenClearCommandIsCalledItShouldClearAllCommands() throws Exception {
        Map commands;

        String commandName = "AC Off";
        Command command = Mockito.mock(Command.class);
        when(command.getCommandName()).thenReturn(commandName);
        cinemaPanel.addCommand(command);

        commands = (Map) commandsField.get(cinemaPanel);
        assertEquals(1, commands.size());

        cinemaPanel.clearCommand();

        commands = (Map) commandsField.get(cinemaPanel);
        assertEquals(0, commands.size());
    }
}
