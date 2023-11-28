package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.ac;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.command.Command;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.device.ac.AC;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ACHighCommand implements Command {
    private AC ac;

    public ACHighCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public String execute() {
        return this.ac.high();
    }

    @Override
    public String getCommandName() {
        return String.format("%sHIGH", ac.getName());
    }
}
