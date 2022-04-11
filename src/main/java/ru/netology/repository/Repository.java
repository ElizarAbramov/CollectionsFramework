package ru.netology.repository;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Repository {

    private List<Issue> items = new ArrayList<>();

    public boolean add(Issue item) {

        return items.add(item);
    }

    public List<Issue> opened() {
        items.removeIf(element -> !element.isOpened());
        return items;
    }

    public List<Issue> closed() {
        items.removeIf(Issue::isOpened);
        return items;
    }

    public List<Issue> filterByA(String author) {
        items.stream().filter(issue -> issue.getAuthor().equals(author));
        return items;
    }

    public List<Issue> filterByL(Set<Label> labels) {
        items.stream().filter(element -> Objects.equals(element.getLabels(), labels));
        return items;
    }

    public List<Issue> findAll() {
        return items;
    }

    public boolean remove(Issue item) {
        return items.remove(item);
    }
}