package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.Repository;

import java.util.Set;

public class IssueManager {
    private final Repository repository;

    public IssueManager(Repository repository) {
        this.repository = repository;
    }

    public void plus(Issue item) {
        repository.add(item);
    }

    public void filterByAuthor(String author) {
        repository.filterByAut(author);

    }

    public void filterByLabel(Set<Label> labels) {
        repository.filterByL(labels);
    }

    public void filterByAssignee(String assignee) {
        repository.filterByAssi(assignee);
    }

    public void removeIssue(Issue item) {
        repository.delete(item);
    }

}

