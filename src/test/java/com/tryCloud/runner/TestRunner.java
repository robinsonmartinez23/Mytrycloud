package com.tryCloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", // or "src/test/resources/features",
                glue = "com/tryCloud/step_definitions",
                publish = true, // It will give public link of local html report
                plugin = {"pretty", "html:target/cucumber.html" ,
                "rerun:target/rerun.txt", // store the failed scenario rerun.txt file
                "me.jvt.cucumber.report.PrettyReports:target" // Third party report plugin
                },
                dryRun =false,
                tags = "@ui")

public class TestRunner{
}

