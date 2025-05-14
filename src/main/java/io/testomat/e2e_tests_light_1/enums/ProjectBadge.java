package io.testomat.e2e_tests_light_1.enums;

public enum ProjectBadge {
    CLASSICAL("Classical");

    private final String label;

    ProjectBadge(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}