package com.tryCloud.step_definitions;

import com.tryCloud.pages.CommonAreaPage;
import com.tryCloud.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CommonAreaStepDef {
    @And("verify the user see the following modules")
    public void verifyTheUserSeeTheFollowingModules(List<String> expectedModules) {

        CommonAreaPage commonAreaPage = new CommonAreaPage();

        BrowserUtil.waitFor(7);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
//        wait.until(ExpectedConditions.visibilityOfAllElements(commonAreaPage.allModules));

        List<WebElement> allModules = commonAreaPage.allModules;

        List<String> actualModules = new ArrayList<>();

        for (WebElement module : allModules) {
            actualModules.add(module.getText());
        }
        System.out.println("actualModules = " + actualModules);
        System.out.println("expectedModules = " + expectedModules);
        Assert.assertEquals(expectedModules,actualModules);
    }
}
