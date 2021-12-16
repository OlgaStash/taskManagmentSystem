package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IssueManager {

    private IssueRepository repository = new IssueRepository();

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> searchByOpen() {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if ((issue.isOpen())) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public List<Issue> searchByClose() {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if ((!issue.isOpen())) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public List<Issue> filterByAuthor(String author) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAuthor() == author) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAssignee() == assignee) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public List<Issue> filterByLabel(String searchLabel) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            Set<String> labels = issue.getLabels();
            boolean hasIssueLabel = suitableIssueLabel(labels, searchLabel);
            if (hasIssueLabel) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public boolean suitableIssueLabel(Set<String> labels, String searchLabel) {
        for (String label : labels) {
            if (label.equals(searchLabel)) {
                return true;
            }
        }
        return false;
    }


    public void closeById(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(false);
                return;
            }
        }

    }

    public void openById(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(true);
                return;
            }
        }
    }
}
