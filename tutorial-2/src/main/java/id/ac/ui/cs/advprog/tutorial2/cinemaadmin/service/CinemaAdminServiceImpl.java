package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.service;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACHighCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACLowCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACMediumCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac.ACOffCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.lamp.LampOffCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.lamp.LampOnCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.screen.ScreenAdsCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.screen.ScreenFilmCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.screen.ScreenOffCommand;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac.AC;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.lamp.Lamp;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.Devices;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.FormDevices;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.repository.CinemaPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CinemaAdminServiceImpl implements CinemaAdminService {
    @Autowired
    private CinemaPanel cinemaPanel;

    private Devices devices = new Devices(new AC("AC"), new Lamp("Lamp"), new Screen("Screen"));

    @Override
    public Devices getDevices() {
        return devices;
    }

    @Override
    public void setDevices(FormDevices form) {
        devices.getAc().setEnable(form.getAc());
        devices.getLamp().setEnable(form.getLamp());
        devices.getScreen().setEnable(form.getScreen());
    }

    @Override
    public void registryCommand(Devices devices) {
        cinemaPanel.clearCommand();

        if (devices.getAc().getEnable()) {
            registryACCommand(devices.getAc());
        }
        if (devices.getLamp().getEnable()) {
            registryLampCommand(devices.getLamp());
        }

        if (devices.getScreen().getEnable()) {
            registryScreenCommand(devices.getScreen());
        }
    }

    public void registryACCommand(AC ac) {
        // TODO : implementasikan method berikut
        cinemaPanel.addCommand(new ACOffCommand(ac));
        cinemaPanel.addCommand(new ACLowCommand(ac));
        cinemaPanel.addCommand(new ACMediumCommand(ac));
        cinemaPanel.addCommand(new ACHighCommand(ac));
    }

    public void registryLampCommand(Lamp lamp) {
        // TODO : implementasikan method berikut
        cinemaPanel.addCommand(new LampOffCommand(lamp));
        cinemaPanel.addCommand(new LampOnCommand(lamp));
    }

    public void registryScreenCommand(Screen screen) {
        // TODO : implementasikan method berikut
        cinemaPanel.addCommand(new ScreenOffCommand(screen));
        cinemaPanel.addCommand(new ScreenAdsCommand(screen));
        cinemaPanel.addCommand(new ScreenFilmCommand(screen));
    }

    @Override
    public void executeCommand(String command) {
        // TODO : eksekusi command diatas
        cinemaPanel.execute(command);
    }

    @Override
    public List<String> getHistory() {
        return cinemaPanel.getCommandHistory();
    }
}
