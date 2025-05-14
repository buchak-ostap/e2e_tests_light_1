package io.testomat.e2e_tests_light_1.enums;

public enum ProjectName {
    MANUFACTURE_LIGHT("Manufacture light");

    private final String displayName;

    ProjectName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}