package ru.netology.domain;

import java.util.Set;


public class Issue {
    private int id;
    private boolean isOpened;
    private String author;
    private Set<Label> labels;
    private String assignee;

    public Issue(int id, boolean isOpened, String author, Set<Label> labels, String assignee) {
        this.id = id;
        this.isOpened = isOpened;
        this.author = author;
        this.labels = labels;
        this.assignee = assignee;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}