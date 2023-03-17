package pageobject;

import actions.SelectOptions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Checkout extends PageObject {
    public static Double subTotalConfirm;
    public static Double flatConfirm;
    public static Double totalConfirm;

    //Billing Details
    @FindBy(id = "input-payment-firstname")
    public WebElementFacade firstNameTxt;
    @FindBy(id = "input-payment-lastname")
    public WebElementFacade lastNameTxt;
    @FindBy(id = "input-payment-email")
    public WebElementFacade emailTxt;
    @FindBy(id = "input-payment-telephone")
    public WebElementFacade phoneTxt;
    @FindBy(id = "input-payment-company")
    public WebElementFacade companyTxt;
    @FindBy(id = "input-payment-address-1")
    public WebElementFacade addressTxt;
    @FindBy(id = "input-payment-city")
    public WebElementFacade cityTxt;
    @FindBy(id = "input-payment-postcode")
    public WebElementFacade postCodeTxt;
    @FindBy(id = "input-payment-country")
    public WebElementFacade countrySelect;
    @FindBy(id = "input-payment-zone")
    public WebElementFacade stateSelect;
    @FindBy(id = "button-guest")
    public WebElementFacade buttonBillingDetails;
    //Delivery Methods
    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElementFacade descriptionText;
    @FindBy(id = "button-shipping-method")
    public WebElementFacade buttonShippingMethod;
    //Payment Method
    @FindBy(xpath = "//div[@class='radio']/label")
    public List<WebElementFacade> listMethodPay;
    @FindBy(xpath = "//input[@name='agree']")
    public WebElementFacade terminosYCondiciones;
    @FindBy(id = "button-payment-method")
    public WebElementFacade buttonPaymentMethod;
    //Confirm order
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[1]/td[2]")
    public WebElementFacade subTotal;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[2]/td[2]")
    public WebElementFacade flat;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[3]/td[2]")
    public WebElementFacade total;
    @FindBy(id = "button-confirm")
    public WebElementFacade buttonConfirmOrder;
    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    public WebElementFacade textConfirmOrder;

    public void billingDetails(String name, String lastName, String email, String phone, String address, String city, String country, String state) {
        element(firstNameTxt).waitUntilVisible();
        firstNameTxt.type(name);
        lastNameTxt.type(lastName);
        emailTxt.type(email);
        phoneTxt.type(phone);
        companyTxt.type("ZUMs");
        addressTxt.type(address);
        cityTxt.type(city);
        postCodeTxt.type("15047");
        Select elementCountry = new Select(countrySelect);
        elementCountry.selectByVisibleText(country);
        Select elementState = new Select(stateSelect);
        elementState.selectByVisibleText(state);
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", buttonBillingDetails);
    }

    public void deliveryMethod(String description) {
        descriptionText.type(description);
        buttonShippingMethod.click();
    }

    public void paymentMethod(String methodPay) {
        SelectOptions.in(listMethodPay, methodPay);
        terminosYCondiciones.click();
        buttonPaymentMethod.click();
    }

    public void validateOrder() {
        subTotalConfirm = Double.parseDouble(subTotal.getText().replace("$", ""));
        flatConfirm = Double.parseDouble(flat.getText().replace("$", ""));
        totalConfirm = Double.parseDouble(total.getText().replace("$", ""));
        String sbtMasFlat = String.valueOf(subTotalConfirm + flatConfirm);
        String totalOrder = String.valueOf(totalConfirm);
        Assert.assertEquals(sbtMasFlat, totalOrder);
        buttonConfirmOrder.click();
        textConfirmOrder.withTimeoutOf(Duration.ofSeconds(20)).isEnabled();
        Assert.assertEquals(textConfirmOrder.getText(), "Your order has been placed!");
    }


}
