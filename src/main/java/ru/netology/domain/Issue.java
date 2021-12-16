package ru.netology.domain;

import java.util.Set;

public class Issue {
    private int id;
    private String name;
    private String author;
    private Set<String> labels;
    private String assignee;
    private boolean isOpen;

    public Issue() {
    }

    public Issue(int id, String name, String author, Set<String> labels, String assignee, boolean isOpen) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.labels = labels;
        this.assignee = assignee;
        this.isOpen = isOpen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
