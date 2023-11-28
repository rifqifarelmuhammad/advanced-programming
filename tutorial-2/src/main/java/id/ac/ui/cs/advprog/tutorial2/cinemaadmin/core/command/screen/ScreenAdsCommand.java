package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.screen;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenAdsCommand implements Command {
    private Screen screen;

    public ScreenAdsCommand(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String execute() {
        // TODO: implementasikan method berikut
        return this.screen.ads();
    }

    @Override
    public String getCommandName() {
        return String.format("%sADS", screen.getName());
    }
}
