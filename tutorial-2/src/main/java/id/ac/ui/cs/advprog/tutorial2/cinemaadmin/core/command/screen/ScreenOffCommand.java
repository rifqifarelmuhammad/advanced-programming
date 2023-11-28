package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.screen;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenOffCommand implements Command {
    private Screen screen;

    public ScreenOffCommand(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String execute() {
        return this.screen.off();
    }

    @Override
    public String getCommandName() {
        return String.format("%sOFF", screen.getName());
    }
}
