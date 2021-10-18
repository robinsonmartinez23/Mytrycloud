package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonAreaPage {
    public CommonAreaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//*[@id=\"appmenu\"]/li[@data-id]")
    public List<WebElement> allModules;
}
