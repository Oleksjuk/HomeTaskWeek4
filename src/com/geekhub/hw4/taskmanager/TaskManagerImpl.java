package com.geekhub.hw4.taskmanager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TaskManagerImpl implements TaskManager {

    private Map<Date,Task> tasks = new HashMap<>();

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
        Task task = null;
        List<Task> tasksByCategory = null;
        for (Date date : getOrderedDateOfTasks()){
            task = tasks.get(date);
            tasksByCategory = tasksByCategories.get(task.getCategory());
            if (tasksByCategory == null) {
                tasksByCategory = new ArrayList<>();
            }
            if (!tasksByCategory.contains(task)){
                tasksByCategory.add(task);
                tasksByCategories.put(task.getCategory(),tasksByCategory);
            }
        }

        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return getTasksByCategories().get(category);
    }

    @Override
    public List<Task> getTasksForToday() {

        List<Task> tasksForToday = getOrderedDateOfTasks().stream().filter(taskDate -> isToday(taskDate)).map(tasks::get).collect(Collectors.toList());

        return tasksForToday;
    }

    private boolean isToday(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        if (today.get(Calendar.YEAR)  == calendarDate.get(Calendar.YEAR)&&
            today.get(Calendar.MONTH) == calendarDate.get(Calendar.MONTH)&&
            today.get(Calendar.DATE)  == calendarDate.get(Calendar.DATE)) {

            return true;
        }

        return false;
    }

    private Set<Date> getOrderedDateOfTasks() {
        return new TreeSet<>(tasks.keySet());
    }
}
