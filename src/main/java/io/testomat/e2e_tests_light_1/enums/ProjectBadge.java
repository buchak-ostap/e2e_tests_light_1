package io.testomat.e2e_tests_light_1.enums;

import java.util.List;

public enum ProjectBadge {
    CLASSICAL("Classical");

    private final String label;

    ProjectBadge(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static List<String> asLabels(List<ProjectBadge> badges) {
        return badges.stream()
                .map(ProjectBadge::getLabel)
                .toList();
    }
}