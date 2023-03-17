package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Home extends PageObject {
    public static Double priceProductList;
    public static Double subTotalCart;

    @FindBy(xpath = "//input[@type='text']")
    public WebElementFacade txtSearch;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElementFacade btnSearch;
    @FindBy(xpath = "//span[@class='price-tax']")
    public WebElementFacade price;
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    public WebElementFacade buttonAddCart;
    @FindBy(xpath = "//div[@id='cart']/button/span")
    public WebElementFacade cartShop;
    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
    public WebElementFacade subTotal;

    public void searchProduct(String product) {
        txtSearch.type(product);
        // enter(product).into(txtSearch);
        // txtSearch.sendKeys(product);
        // element(txtSearch).type(product);
        btnSearch.click();
        // clickOn(btnSearch);
        // element(btnSearch).click();
    }

    public void addToCartProduct() {
        priceProductList = Double.parseDouble(price.getText().replace("Ex Tax: $", ""));
        buttonAddCart.click();
        // cartShop.withTimeoutOf(Duration.ofSeconds(30)).isClickable();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", cartShop.waitUntilEnabled());
        subTotalCart = Double.parseDouble(subTotal.getText().replace("$", ""));
        Assert.assertTrue("Validamos el subTotal dle producto", priceProductList.equals(subTotalCart));


    }


}
