package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.Device;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AC extends Device {

    private ACState state;
    private String name;
    private Boolean enable;

    public AC(String name) {
        this.name = name;
        this.enable = false;
        setState(ACState.OFF);
    }

    public String off() {
        setState(ACState.OFF);
        return "AC is turned off";
    }

    public String low() {
        setState(ACState.LOW);
        return "AC temperature is set to low";
    }

    public String medium() {
        setState(ACState.MEDIUM);
        return "AC temperature is set to medium";
    }

    public String high() {
        setState(ACState.HIGH);
        return "AC temperature is set to high";
    }
}
