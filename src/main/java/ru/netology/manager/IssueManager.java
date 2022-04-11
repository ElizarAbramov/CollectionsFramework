package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.Repository;

import java.util.List;
import java.util.Set;

public class IssueManager {
    private Repository repository;

    public IssueManager(Repository repository) {
        this.repository = repository;
    }

    public void plus(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> filterByAuthor(String author) {
        repository.filterByA(author);
        return null;
    }

    public List<Issue> filterByLabel(Set<Label> labels) {
        repository.filterByL(labels);
        return null;
    }
}