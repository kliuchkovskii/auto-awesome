package com.example.demo1;

import com.example.pageobject.WelcomePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WelcomePageProductTest extends BaseTest {

  private WelcomePage welcomePage;

  @BeforeMethod
  public void setUp() {
    welcomePage = new WelcomePage(driver);
    driver.get("https://plexusworldwide.com/");
  }

  @Test
  public void checkProductNamesAndPricesNotEmpty(){
    welcomePage.scrollToProductsGroup();

    List<String> productNames = welcomePage.gatAllProductNames();
    List<String> productPrices = welcomePage.gatAllProductPrices();

    Assertions.assertThat(productNames)
            .allMatch(product -> product != null && !product.isEmpty(), "Products contains an empty names");

    Assertions.assertThat(productPrices)
            .allMatch(price -> price != null && !price.isEmpty(), "Products contains an empty prices")
            .map(price -> price.replaceAll("[^\\d.]", "")) //removing price currency symbols
            .map(Double::parseDouble) //converting string number to double number
            .allMatch(price -> price > 0, "Prices should be bigger than 0");
  }

  @Test
  public void checkProductsPageRedirection() {
    welcomePage.scrollToProductsGroup();
    welcomePage.clickShopNowButton();

    wait.until(ExpectedConditions.urlContains("https://plexusworldwide.com/products"));
  }
}
