package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.screen;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.screen.Screen;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenFilmCommand implements Command {
    private Screen screen;

    public ScreenFilmCommand(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String execute() {
        return this.screen.film();
    }

    @Override
    public String getCommandName() {
        return String.format("%sFILM", screen.getName());
    }
}
