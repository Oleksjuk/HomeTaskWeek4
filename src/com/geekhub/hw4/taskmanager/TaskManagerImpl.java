package com.geekhub.hw4.taskmanager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TaskManagerImpl implements TaskManager {

    private Map<Date,Task> tasks = new TreeMap<>();

    @Override
    public void addTask(Date date, Task task) {
        tasks.put(date,task);
    }

    @Override
    public void removeTask(Date date) {
        tasks.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        return getTasksByCategories().keySet();
    }

    //methods ordered by date
    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String,List<Task>> tasksByCategories = new HashMap<>();

        for (Task task : tasks.values()){
            String category = task.getCategory();

            if (tasksByCategories.get(category) == null) {
                tasksByCategories.put(category, new ArrayList<>());
            }

            tasksByCategories.get(category).add(task);
        }

        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return getTasksByCategories().get(category);
    }

    @Override
    public List<Task> getTasksForToday() {

        return tasks.keySet().stream()
                .filter(taskDate -> isToday(taskDate))
                .map(tasks::get)
                .collect(Collectors.toList());
    }

    private boolean isToday(Date date) {
        Calendar today = Calendar.getInstance();

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        if (today.get(Calendar.YEAR)  == calendarDate.get(Calendar.YEAR)&&
            today.get(Calendar.MONTH) == calendarDate.get(Calendar.MONTH)&&
            today.get(Calendar.DATE)  == calendarDate.get(Calendar.DATE)) {

            return true;
        }

        return false;
    }

}
