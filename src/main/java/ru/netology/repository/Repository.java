package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private final List<Issue> items = new ArrayList<>();


    public void add(Issue item) {

        items.add(item);
    }

    public List<Issue> findAll() {
        return items;
    }

    public void delete(Issue item) {
        items.remove(item);
    }
}