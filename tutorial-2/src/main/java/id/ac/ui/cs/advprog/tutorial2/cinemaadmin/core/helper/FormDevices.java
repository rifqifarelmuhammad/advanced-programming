package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormDevices {
    private Boolean ac;
    private Boolean lamp;
    private Boolean screen;

    public FormDevices(Boolean ac, Boolean lamp, Boolean screen) {
        this.ac = ac;
        this.lamp = lamp;
        this.screen = screen;
    }
}
