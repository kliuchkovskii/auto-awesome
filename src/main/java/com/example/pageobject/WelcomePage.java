package com.example.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WelcomePage extends BasePage {

  @FindBy(css = "div[data-testid='products-group']")
  private WebElement productsGroup;

  @FindBy(css = "[data-testid='product-teaser-name']")
  private List<WebElement> productsNames;

  @FindBy(css = "div[data-testid='retailPrice']")
  private List<WebElement> productPrices;

  @FindBy(xpath = "//div[@data-testid='hero-banner-cta']/a[@data-testid='button-content']")
  private WebElement shopNowButton;

  public WelcomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void scrollToProductsGroup(){
    scrollToElement(productsGroup);
  }

  public List<String> gatAllProductNames(){
    return productsNames.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public List<String> gatAllProductPrices(){
    return productPrices.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public void clickShopNowButton(){
    shopNowButton.click();
  }

}
