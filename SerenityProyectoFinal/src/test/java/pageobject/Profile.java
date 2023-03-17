package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Profile extends PageObject {


    @FindBy(id = "txt-username")
    public WebElementFacade userText;

    @FindBy(id = "txt-password")
    public WebElementFacade passText;

    @FindBy(id = "btn-login")
    public WebElementFacade btnLogin;


    public void ingresarLoginDeInvitado(String user, String pass)
    {
        element(userText).waitUntilVisible();
        userText.type(user);
        passText.type(pass);
        btnLogin.click();
    }


}
