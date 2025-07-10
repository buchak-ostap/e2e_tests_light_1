package io.testomat.e2e_tests_light_1.playwright.common;

import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

public class PWOptions implements OptionsFactory {

    @Override
    public Options getOptions() {
        return new Options()
                .setHeadless(false)
                .setBaseUrl("https://app.testomat.io/")
                .setTrace(Options.Trace.ON);
    }
}
