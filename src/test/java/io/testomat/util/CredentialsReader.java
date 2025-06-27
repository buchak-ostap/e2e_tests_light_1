package io.testomat.util;

import io.testomat.e2e_tests_light_1.selenide.util.TestUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsReader {

    private static final Properties credentials = new Properties();

    static {
        try (InputStream input = CredentialsReader.class
                .getClassLoader()
                .getResourceAsStream("test-users.properties")) {

            if (input == null) {
                throw new RuntimeException("Could not find test-users.properties in classpath");
            }

            credentials.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load test-users.properties", e);
        }
    }

    public static TestUser getUser(String role) {
        String usernameKey = role + ".user";
        String passwordKey = role + ".pass";

        String username = credentials.getProperty(usernameKey);
        String password = credentials.getProperty(passwordKey);

        if (username == null || password == null) {
            throw new IllegalArgumentException("Credentials not found for role: " + role);
        }

        return new TestUser(username, password);
    }
}