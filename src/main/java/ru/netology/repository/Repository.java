package ru.netology.repository;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Repository {

    private final List<Issue> items = new ArrayList<>();

    public void add(Issue item) {

        items.add(item);
    }

    public List<Issue> opened() {
        items.removeIf(element -> !element.isOpened());
        return items;
    }

    public List<Issue> closed() {
        items.removeIf(Issue::isOpened);
        return items;
    }

    public void filterByAut(String author) {
        items.removeIf(issue -> !(issue.getAuthor().contains(author)));

    }

    public void filterByL(Set<Label> labels) {
        items.removeIf(issue -> !(issue.getLabels().containsAll(labels)));
    }


    public void filterByAssi(String assignee) {
        items.removeIf(issue -> !(issue.getAssignee().contains(assignee)));
    }

    public List<Issue> findAll() {
        return items;
    }

    public void delete(Issue item) {
        items.remove(item);
    }
}