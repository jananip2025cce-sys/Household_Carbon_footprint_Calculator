package com.example.carbontrack.controller;

import com.example.carbontrack.entity.Activity;
import com.example.carbontrack.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @PostMapping
    public Activity addActivity(@RequestBody Activity activity) {
        return service.addActivity(activity);
    }

    @GetMapping
    public List<Activity> getAllActivities() {
        return service.getAllActivities();
    }

    @GetMapping("/{id}")
    public Activity getActivity(@PathVariable Long id) {
        return service.getActivityById(id);
    }

    @PutMapping("/{id}")
    public Activity updateActivity(
            @PathVariable Long id,
            @RequestBody Activity activity) {
        return service.updateActivity(id, activity);
    }

    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable Long id) {
        service.deleteActivity(id);
        return "Activity deleted successfully";
    }
}