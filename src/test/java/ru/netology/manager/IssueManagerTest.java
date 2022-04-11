package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.Repository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {
    private Repository repository = new Repository();
    private IssueManager issueManager = new IssueManager(repository);
    private Label firstt = new Label("component: Jupiter");
    private Label secondd = new Label("type: enchancement");
    private Label thirdd = new Label("status: team discussion");
    private Issue first = new Issue(1, true, "kukich", new HashSet<>(Arrays.asList(firstt, secondd, thirdd)), "Kirito");
    private Issue second = new Issue(2, true, "pickich", new HashSet<>(Arrays.asList(secondd, thirdd)), "Roma");


    @Test
    public void shouldTested() {
        issueManager.plus(first);
        issueManager.plus(second);
        List<Issue> actual = repository.opened();
        List<Issue> expected = Arrays.asList(first, second);
        assertEquals(actual, expected);
    }


    @Test
    public void shouldTestedClosed() {
        repository.add(first);
        repository.add(second);

        List<Issue> actual = repository.closed();
        List<Issue> expected = Arrays.asList();
        assertEquals(actual, expected);
    }


    @Test
    public void shouldFilterIssuesByAuthor() {
        issueManager.plus(first);
        issueManager.plus(second);


        List<Issue> actual = issueManager.filterByAuthor("kukich");
        List<Issue> expected = Arrays.asList(first);
        assertEquals(actual, expected);
    }


    @Test
    public void shouldFiltrerIssuesByLabels() {
        issueManager.plus(first);
        issueManager.plus(second);

        List<Issue> actual = issueManager.filterByLabel((Set<Label>) firstt);
        List<Issue> expected = Arrays.asList(first);
    }
}