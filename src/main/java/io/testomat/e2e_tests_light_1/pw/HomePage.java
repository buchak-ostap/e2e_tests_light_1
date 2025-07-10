package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("/");
    }
}
