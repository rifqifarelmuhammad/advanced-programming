package id.ac.ui.cs.advprog.tutorial0.service;

import id.ac.ui.cs.advprog.tutorial0.model.Activity;
import id.ac.ui.cs.advprog.tutorial0.model.Day;
import id.ac.ui.cs.advprog.tutorial0.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity create(Activity activity) {
        activityRepository.create(activity);
        return activity;
    }

    @Override
    public List<Activity> findAll() {
        Iterator<Activity> activityIterator = activityRepository.findAll();
        List<Activity> allActivity = new ArrayList<>();
        activityIterator.forEachRemaining(allActivity::add);
        return allActivity;
    }

    @Override
    public List<Activity> findByDay(Day day){
        Iterator<Activity> activityIterator = activityRepository.findAll();
        List<Activity> dayActivity = new ArrayList<>();

        while (activityIterator.hasNext()){
            Activity activity = activityIterator.next();
            if (activity.getDay().equals(day)){
                dayActivity.add(activity);
            }
        }

        return  dayActivity;
    }
}
