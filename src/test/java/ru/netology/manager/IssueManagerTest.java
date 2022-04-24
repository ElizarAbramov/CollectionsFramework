package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {
    private final Repository repository = new Repository();
    private final IssueManager issueManager = new IssueManager(repository);
    private final Label firstt = new Label("component: Jupiter");
    private final Label secondd = new Label("type: enchancement");
    private final Label thirdd = new Label("status: team discussion");
    private final Label fourthh = new Label("type: new feature");
    private final Issue first = new Issue(1, true, "kukich", new HashSet<>(Arrays.asList(firstt, secondd, thirdd)), "Kirito");
    private final Issue second = new Issue(2, true, "kukich", new HashSet<>(Arrays.asList(secondd, thirdd)), "Roma");
    private final Issue third = new Issue(3, false, "King", new HashSet<>(List.of(firstt)), "Kirito");
    private final Issue fourth = new Issue(4, false, "Leonov", new HashSet<>(List.of(fourthh)), "Goga");


    @Test
    public void shouldShowOnlyOpenedIssues() {
        issueManager.plus(first);
        issueManager.plus(second);
        issueManager.plus(third);
        List<Issue> actual = issueManager.findByOpened(true);
        List<Issue> expected = Arrays.asList(first, second);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldShowOnlyOpenedIssuesWithEmpty() {
        issueManager.plus(third);
        List<Issue> actual = issueManager.findByOpened(true);
        List<Issue> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldShowOnlyOneOpenedIssue() {
        issueManager.plus(first);
        issueManager.plus(third);
        List<Issue> actual = issueManager.findByOpened(true);
        List<Issue> expected = List.of(first);
        assertEquals(actual, expected);
    }


    @Test
    public void shouldShowOnlyOneClosedIssue() {
        repository.add(first);
        repository.add(third);

        List<Issue> actual = issueManager.findByClosed(false);
        List<Issue> expected = List.of(third);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldShowOnlyClosedIssuesWithEmpty() {
        repository.add(first);
        repository.add(second);

        List<Issue> actual = issueManager.findByClosed(false);
        List<Issue> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldShowOnlyClosedIssues() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        List<Issue> actual = issueManager.findByClosed(false);
        List<Issue> expected = Arrays.asList(third, fourth);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByAuthorEmpty() {
        issueManager.plus(first);
        issueManager.plus(second);

        List<Issue> actual = issueManager.findByAuthor("");
        List<Issue> expected = Arrays.asList(first, second);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByAuthor() {
        issueManager.plus(first);
        issueManager.plus(second);

        List<Issue> actual = issueManager.findByAuthor("kukich");
        List<Issue> expected = Arrays.asList(first, second);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByAuthorWithOne() {
        issueManager.plus(first);
        issueManager.plus(second);
        issueManager.plus(fourth);

        List<Issue> actual = issueManager.findByAuthor("Leonov");
        List<Issue> expected = List.of(fourth);
        assertEquals(actual, expected);
    }


    @Test
    public void shouldFilterIssuesByLabels() {
        issueManager.plus(first);
        issueManager.plus(second);


        List<Issue> actual = issueManager.findByLabel(new HashSet<>(Arrays.asList(firstt, secondd, thirdd)));
        List<Issue> expected = List.of(first);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByLabelsWithEmpty() {
        issueManager.plus(first);
        issueManager.plus(second);


        List<Issue> actual = issueManager.findByLabel(new HashSet<>(List.of()));
        List<Issue> expected = Arrays.asList(first, second);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByLabelsWithOne() {
        issueManager.plus(first);
        issueManager.plus(second);
        issueManager.plus(fourth);


        List<Issue> actual = issueManager.findByLabel(new HashSet<>(List.of(fourthh)));
        List<Issue> expected = List.of(fourth);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByAssigneeEmpty() {
        issueManager.plus(first);
        issueManager.plus(second);


        List<Issue> actual = issueManager.findByAssignee("Goga");
        List<Issue> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFilterIssuesByAssigneeWithOne() {
        issueManager.plus(first);
        issueManager.plus(second);

        List<Issue> actual = issueManager.findByAssignee("Kirito");
        List<Issue> expected = List.of(first);
        assertEquals(actual, expected);
    }


    @Test
    public void shouldFilterIssuesByAssignee() {
        issueManager.plus(first);
        issueManager.plus(second);
        issueManager.plus(third);


        List<Issue> actual = issueManager.findByAssignee("Kirito");
        List<Issue> expected = Arrays.asList(first, third);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldRemoveIssue() {
        issueManager.plus(first);
        issueManager.plus(second);
        issueManager.plus(third);
        issueManager.removeIssue(first);

        List<Issue> actual = repository.findAll();
        List<Issue> expected = Arrays.asList(second, third);
        assertEquals(actual, expected);
    }
}