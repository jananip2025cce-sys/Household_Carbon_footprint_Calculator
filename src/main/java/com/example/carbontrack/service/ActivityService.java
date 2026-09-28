package com.example.carbontrack.service;

import com.example.carbontrack.entity.Activity;
import com.example.carbontrack.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    public Activity addActivity(Activity activity) {

        double carbon =
                activity.getUsageAmount() * activity.getEmissionFactor();

        activity.setCarbonEmission(carbon);

        return repository.save(activity);
    }

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    public Activity getActivityById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Activity updateActivity(Long id, Activity activity) {

        Activity existing = repository.findById(id)
                .orElseThrow();

        existing.setActivityType(activity.getActivityType());
        existing.setUsageAmount(activity.getUsageAmount());
        existing.setEmissionFactor(activity.getEmissionFactor());

        double carbon =
                activity.getUsageAmount() * activity.getEmissionFactor();

        existing.setCarbonEmission(carbon);

        return repository.save(existing);
    }

    public void deleteActivity(Long id) {
        repository.deleteById(id);
    }
}