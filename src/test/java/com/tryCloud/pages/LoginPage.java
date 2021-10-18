package com.tryCloud.pages;

import com.tryCloud.utilities.ConfigReader;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="user")
    public WebElement usernameBox;

    @FindBy(id="password")
    public WebElement passwordBox;

    @FindBy(id="submit-form")
    public WebElement loginBtn;

    @FindBy(xpath="//fieldset/p[3]")
    public WebElement errorMsg;

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

}
