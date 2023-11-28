package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.Device;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Screen extends Device {
    private String name;
    private ScreenState state;
    private Boolean enable;

    public Screen(String name) {
        this.name = name;
        this.enable = false;
        setState(ScreenState.OFF);
    }

    public String off() {
        setState(ScreenState.OFF);
        return "The screen is turned off";
    }

    public String ads() {
        setState(ScreenState.ADS);
        return "The screen shows some ads";
    }

    public String film() {
        setState(ScreenState.FILM);
        return "The screen shows a movie";
    }
}
