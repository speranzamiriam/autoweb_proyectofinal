package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.*;

public class OpenCartStepsDefinitions {

    @Steps
    Home home;
    @Steps
    Profile profile;
    @Steps
    MakeAppointment makeAppointment;



    @Given("que como usuario ingresa a la web")
    public void queComoUsuarioIngresaALaWeb() {
        home.open();
    }
    @And("^ingreso a la web como invitado con el usuario (.*) y password (.*)$")
    public void andIngresaComoInvitado(String user,String pass) {
        home.ingresarALogin();
        profile.ingresarLoginDeInvitado(user,pass);

    }

    @When("^registro los datos de Facility (.*),(.*),(.*),(.*) y (.*)$")
    public void registrarDatosCentroDeAtencion(String facility,String apply,String healthcareProgram, String visitDate ,String comment) {
        makeAppointment.registrarInformacion(facility,apply,healthcareProgram,visitDate,comment);
    }
    @Then("^verifico que se muestre la informacion (.*),(.*),(.*),(.*) y (.*)$")
    public void verificoDatosCentroDeAtencion(String facility,String apply,String healthcareProgram, String visitDate ,String comment) {
        makeAppointment.validarRegistroInformacion(facility,apply,healthcareProgram,visitDate,comment);
    }

   
}
