package com.utest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com/utest/features",
        glue = "com.utest.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        tags = "@challenge",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
