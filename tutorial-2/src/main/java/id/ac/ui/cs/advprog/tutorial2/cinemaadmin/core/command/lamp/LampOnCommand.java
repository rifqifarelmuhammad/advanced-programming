package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.lamp;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.lamp.Lamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LampOnCommand implements Command {
    private Lamp lamp;

    public LampOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public String execute() {
        // TODO: implementasikan method berikut
        return this.lamp.on();
    }

    @Override
    public String getCommandName() {
        return String.format("%sON", lamp.getName());
    }
}
