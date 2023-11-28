package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber {
    private final String name;
    private final List<String> news = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void handleNotification(String from) {
        // TODO: Lengkapi method ini
        if (from.equals("GameStart")){
            news.add("Mendapatkan notifikasi tentang rilisnya game dari GameStart");
        }else if (from.equals("Koped Travel")){
            news.add("Mendapatkan notifikasi tentang tempat wisata dari Koped Travel");
        }else{
            news.add("Mendapatkan notifikasi tentang hasil pertandingan dari BI Sports");
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getNews() {
        return new ArrayList<>(news);
    }
}
