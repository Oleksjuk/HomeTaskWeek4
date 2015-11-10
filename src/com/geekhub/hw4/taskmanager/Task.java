package com.geekhub.hw4.taskmanager;

public class Task {
    private String category;
    private String description;

    public Task(String category, String description) {
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("task{%s, %s}", category,description);
    }

}
