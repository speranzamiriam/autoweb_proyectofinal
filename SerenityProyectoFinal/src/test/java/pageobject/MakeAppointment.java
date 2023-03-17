package pageobject;


import actions.SelectOptions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

public class MakeAppointment extends PageObject{
    @FindBy(xpath = "//section[@id='appointment']/div/div/div/h2")
    public WebElementFacade titleForm;

    @FindBy(id = "combo_facility")
    public WebElementFacade comboFacility;

    @FindBy(id = "txt_visit_date")
    public WebElementFacade visitDateTxt;

    @FindBy(id = "txt_comment")
    public WebElementFacade commentTxt;

    @FindBy(id = "btn-book-appointment")
    public WebElementFacade btnRegistrar;

    @FindBy(id = "facility")
    public WebElementFacade lblFacilityInfo;
    @FindBy(id = "hospital_readmission")
    public WebElementFacade lblHospitalInfo;
    @FindBy(id = "program")
    public WebElementFacade lblProgramInfo;
    @FindBy(id = "visit_date")
    public WebElementFacade lblVisitInfo;
    @FindBy(id = "comment")
    public WebElementFacade lblCommentInfo;



    public WebElementFacade chkApply;
    public WebElementFacade cmbhealthcareProgram;

    public void registrarInformacion(String facility,String apply,String healthcareProgram, String visitDate ,String comment){
        element(titleForm).waitUntilVisible();
        comboFacility.selectByValue(facility);
        chkApply =this.findBy("//*[@value='"+apply+"']");
        cmbhealthcareProgram =this.findBy("//*[@value='"+healthcareProgram+"']");
        chkApply.click();
        cmbhealthcareProgram.click();
        visitDateTxt.type(visitDate);
        commentTxt.type(comment);
        btnRegistrar.click();

    }
    public void validarRegistroInformacion(String facility,String apply,String healthcareProgram, String visitDate ,String comment){
        element(lblFacilityInfo).waitUntilVisible();
        Assert.assertTrue("Validamos el registro de facility", lblFacilityInfo.getText().equals(facility));
        Assert.assertTrue("Validamos el registro de apply", lblHospitalInfo.getText().equals(apply));
        Assert.assertTrue("Validamos el registro de healthcareProgram", lblProgramInfo.getText().equals(healthcareProgram));
        Assert.assertTrue("Validamos el registro de visitDate", lblVisitInfo.getText().equals(visitDate));
        Assert.assertTrue("Validamos el registro de comment", lblCommentInfo.getText().equals(comment));

    }
}
