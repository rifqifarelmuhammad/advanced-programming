package id.ac.ui.cs.advprog.tutorial2.template.service;

import id.ac.ui.cs.advprog.tutorial2.template.repository.CinemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepo cinemaRepo;

    @Override
    public Iterable<String> startRegularShow() {
        return cinemaRepo.beginShowRegularCinema();
    }

    @Override
    public Iterable<String> startDeluxeShow() {
        return cinemaRepo.beginShowDeluxeCinema();
    }

    @Override
    public Iterable<String> startPremiereShow() {
        return cinemaRepo.beginShowPremiereCinema();
    }
}
