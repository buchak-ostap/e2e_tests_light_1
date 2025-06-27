package io.testomat.e2e_tests_light_1.annotations;

import io.testomat.e2e_tests_light_1.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithUserRole {
    Role value();
}
