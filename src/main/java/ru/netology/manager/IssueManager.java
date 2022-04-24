package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.Repository;

import java.util.*;

public class IssueManager {
    private final Repository repository;

    public IssueManager(Repository repository) {
        this.repository = repository;
    }

    public void plus(Issue item) {
        repository.add(item);
    }

    public List<Issue> findByAuthor(String author) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (matchesForAuthor(issue, author)) {
                result.add(issue);

            }
        }
        return result;
    }

    public boolean matchesForAuthor(Issue issue, String author) {

        return issue.getAuthor().contains(author);
    }


    public List<Issue> findByLabel(Set<Label> labels) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (matchesForLabel(issue, labels)) {
                result.add(issue);

            }
        }
        return result;
    }

    public boolean matchesForLabel(Issue issue, Set<Label> labels) {

        return issue.getLabels().containsAll(labels);
    }


    public List<Issue> findByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (matchesForAssignee(issue, assignee)) {
                result.add(issue);

            }
        }
        return result;
    }

    public boolean matchesForAssignee(Issue issue, String assignee) {

        return issue.getAssignee().contains(assignee);
    }

    public void removeIssue(Issue item) {
        repository.delete(item);
    }

    public List<Issue> findByOpened(boolean isOpened) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (matchesForIsOpened(issue, isOpened)) {
                result.add(issue);

            }
        }
        return result;
    }

    public List<Issue> findByClosed(boolean isOpened) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {

            if (matchesForIsOpened(issue, isOpened)) {
                result.add(issue);

            }
        }
        return result;
    }


    public boolean matchesForIsOpened(Issue issue, boolean isOpened) {

        return issue.isOpened() == isOpened;
    }

}