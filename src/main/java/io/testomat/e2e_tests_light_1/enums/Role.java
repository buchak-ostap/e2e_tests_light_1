package io.testomat.e2e_tests_light_1.enums;

public enum Role {
    REGULAR("regular");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
