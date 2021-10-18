package com.tryCloud.step_definitions;

import com.tryCloud.utilities.ConfigReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before("@ui")                               // Must be Cucumber-Java
    public void setupDriver(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }
    @After("@ui")                                // Must be Cucumber-Java
    public void tearDown(Scenario scenario){
        // check if scenario failed or not
        if(scenario.isFailed()){                 // Must be Cucumber-Java
            // this is how we screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte [] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png", scenario.getName());
        }
        System.out.println("THIS IS FROM @After INSIDE HOOKS CLASS");
        Driver.closeBrowser();
    }
}
