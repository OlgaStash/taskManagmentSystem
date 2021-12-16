package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    private static Issue first = new Issue(1, "Build fails on linux", "Ivanov", Set.of("status:new", "component:jupiter"), "Petrov", true);
    private static Issue second = new Issue(2, "Javadoc Generation for Kotlin Methods ", "Levis", Set.of("theme:documentation", "component:Kotlin"), "Petrov", false);
    private static Issue third = new Issue(3, "Javadoc Generation", "Levis", Set.of("theme:documentation", "component:jupiter"), "Ivanov", true);
    private static Issue fourth = new Issue(4, "Javadoc Generation for Kotlin Methods ", "Ivanov", Set.of("theme:documentation", "component:Kotlin"), "Petrov", false);

    private static IssueRepository repository = new IssueRepository();
    private static IssueManager manager = new IssueManager(repository);

    @BeforeAll
    public static void setUp() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
    }

    @Test
    public void shouldSearchByOpen() {
        List<Issue> actual = manager.searchByOpen();
        List<Issue> expected = List.of(first);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByClose() {
        List<Issue> actual = manager.searchByClose();
        List<Issue> expected = List.of(second, third, fourth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {
        List<Issue> actual = manager.filterByAuthor("Ivanov");
        List<Issue> expected = List.of(first, fourth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {
        List<Issue> actual = manager.filterByAssignee("Petrov");
        List<Issue> expected = List.of(first, second, fourth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {
        List<Issue> actual = manager.filterByLabel("component:Kotlin");
        List<Issue> expected = List.of(second, fourth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseById() {
        manager.closeById(3);
        boolean actual = repository.findById(3).isOpen();

        assertFalse(actual);
    }

    @Test
    public void shouldOpenById() {
        manager.openById(1);
        boolean actual = repository.findById(1).isOpen();

        assertTrue(actual);
    }
}