package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private List<Issue> issues = new ArrayList<>();

    public boolean add(Issue issue) {
        return issues.add(issue);
    }

    public Collection<Issue> findAll() {
        return issues;
    }

    public Issue findById(int id){
        for (Issue issue : issues) {
            if ((issue.getId()) == id){
                return issue;
            }
        }
        return null;
    }
}
