package id.ac.ui.cs.advprog.tutorial1.newsletter.core;

import java.util.ArrayList;
import java.util.List;

public class Newsletter implements Publisher {
    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public Newsletter(String name) {
        this.name = name;
    }

    public void addSubscriber(Subscriber subscriber) {
        // TODO: Lengkapi method ini
        if (!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    public void removeSubscriber(Subscriber subscriber) {
        // TODO: Lengkapi method ini
        subscribers.remove(subscriber);
    }
    public void notifySubscriber() {
        // TODO: Lengkapi method ini
        for (int i = 0; i < subscribers.size(); i++){
            subscribers.get(i).handleNotification(this.getName());
        }
    }

    public String getName() {
        return name;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
