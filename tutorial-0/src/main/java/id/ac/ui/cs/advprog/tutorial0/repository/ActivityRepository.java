package id.ac.ui.cs.advprog.tutorial0.repository;

import id.ac.ui.cs.advprog.tutorial0.model.Activity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ActivityRepository {

    private List<Activity> activityInMemory = new ArrayList<>();

    public Activity create(Activity activity) {
        activityInMemory.add(activity);
        return activity;
    }

    public Iterator<Activity> findAll() {
        return activityInMemory.iterator();
    }

}
