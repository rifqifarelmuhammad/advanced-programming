package id.ac.ui.cs.advprog.tutorial2.template.repository;

import id.ac.ui.cs.advprog.tutorial2.template.core.DeluxeCinema;
import id.ac.ui.cs.advprog.tutorial2.template.core.PremiereCinema;
import id.ac.ui.cs.advprog.tutorial2.template.core.RegularCinema;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaRepo {

    private RegularCinema regularCinema = new RegularCinema();
    private DeluxeCinema deluxeCinema = new DeluxeCinema();
    private PremiereCinema premiereCinema = new PremiereCinema();


    public List<String> beginShowRegularCinema() { return regularCinema.letTheShowBegin(); }
    public List<String> beginShowDeluxeCinema() { return deluxeCinema.letTheShowBegin(); }
    public List<String> beginShowPremiereCinema() { return premiereCinema.letTheShowBegin(); }
}
