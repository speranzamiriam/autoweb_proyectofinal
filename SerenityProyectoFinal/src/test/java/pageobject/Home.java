package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class Home extends PageObject {
    public static Double priceProductList;
    public static Double subTotalCart;

    @FindBy(id = "btn-make-appointment")
    public WebElementFacade btnIngresar;


    public void ingresarALogin(){
        btnIngresar.click();
    }


}
