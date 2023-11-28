package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.lamp;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.Device;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lamp extends Device {
    private String name;
    private LampState state;
    private Boolean enable;

    public Lamp(String name) {
        this.name = name;
        this.enable = false;
        setState(LampState.OFF);
    }

    public String off() {
        setState(LampState.OFF);
        return "The lights are turned off";
    }

    public String on() {
        setState(LampState.ON);
        return "The lights are turned on";
    }
}
