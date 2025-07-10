package io.testomat.e2e_tests_light_1.util;

import java.time.Duration;

public class TimeUtils {

    public static double toDoubleMillis(Duration duration) {
        return (double) duration.toMillis();
    }
}
