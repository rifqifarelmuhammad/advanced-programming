package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac.AC;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.lamp.Lamp;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Devices {
    private AC ac;
    private Lamp lamp;
    private Screen screen;

    public Devices(AC ac, Lamp lamp, Screen screen) {
        this.ac = ac;
        this.lamp = lamp;
        this.screen = screen;
    }
}
