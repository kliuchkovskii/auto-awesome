package com.example.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
  protected WebDriver webDriver;
  protected Actions actions;
  public BasePage(WebDriver webDriver){
    this.webDriver = webDriver;
    actions = new Actions(webDriver);
  }

  protected void scrollToElement(WebElement element){
    actions.moveToElement(element).perform();
  }
}
