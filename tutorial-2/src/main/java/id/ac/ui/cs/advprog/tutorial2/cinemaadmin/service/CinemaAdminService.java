package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.service;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.Devices;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.FormDevices;

import java.util.List;

public interface CinemaAdminService {
    Devices getDevices();
    void setDevices(FormDevices form);
    void registryCommand(Devices devices);
    void executeCommand(String command);
    List<String> getHistory();
}
