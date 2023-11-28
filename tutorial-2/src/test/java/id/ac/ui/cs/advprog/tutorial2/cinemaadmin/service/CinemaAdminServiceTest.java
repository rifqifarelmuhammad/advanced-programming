package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.service;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACHighCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACLowCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACMediumCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACOffCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.lamp.LampOffCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac.AC;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.lamp.Lamp;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.Devices;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.repository.CinemaPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CinemaAdminServiceTest {

    @Mock
    CinemaPanel cinemaPanel;

    Devices devices;

    @InjectMocks
    CinemaAdminServiceImpl cinemaAdminService;

    @BeforeEach
    void setUp() {
        devices = new Devices(new AC("AC"), new Lamp("Lamp"), new Screen("Screen"));
    }

    @Test
    void whenExecuteisCalledItShouldCallExecuteMethod() {
        String commandName = "AC Off";
        cinemaAdminService.executeCommand(commandName);
        verify(cinemaPanel, times(1)).execute(commandName);
    }


}
