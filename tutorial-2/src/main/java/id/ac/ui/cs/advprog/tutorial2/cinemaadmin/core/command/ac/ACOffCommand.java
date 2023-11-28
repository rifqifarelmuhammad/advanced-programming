package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac.AC;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ACOffCommand implements Command {
    private AC ac;

    public ACOffCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public String execute() {
        // TODO: implementasikan method berikut
        return this.ac.off();
    }

    @Override
    public String getCommandName() {
        return String.format("%sOFF", ac.getName());
    }
}
