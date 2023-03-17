package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.CarritoCompras;
import pageobject.Checkout;
import pageobject.Home;

public class OpenCartStepsDefinitions {

    @Steps
    Home home;

    @Steps
    Checkout checkout;

    @Steps
    CarritoCompras cart;

    @Given("que como usuario ingresa a la web")
    public void queComoUsuarioIngresaALaWeb() {
        home.open();
    }

    @When("^busco el producto (.*) y agrego al carrito$")
    public void buscoElProductoProductYAgregoAlCarrito(String product) {
        home.searchProduct(product);
        home.addToCartProduct();
    }

    @And("^me dirijo a realizar la compra como (.*)$")
    public void meDirijoARealizarLaCompraComoOptionCustomer(String optionCustomers) {
        cart.goToCheckout(optionCustomers);
    }

    @And("^ingreso mis datos (.*), (.*), (.*), (.*) y envio de productos (.*), (.*), (.*), (.*)")
    public void ingresoMisDatosNameLastNameEmailPhoneYEnvioDeProductosAddressCityCountryState(String name, String lastName, String email, String phone, String address, String city, String country, String state) {
        checkout.billingDetails(name, lastName, email, phone, address, city, country, state);
    }

    @And("^ingreso un metodo de delivery (.*)$")
    public void ingresoUnMetodoDeDeliveryDescription(String description) {
        checkout.deliveryMethod(description);
    }

    @And("^selecciono el metodo de pago (.*)$")
    public void seleccionoElMetodoDePagoMethodPay(String methodPay) {
        checkout.paymentMethod(methodPay);
    }

    @Then("^verifico y confirmo la orden de compra$")
    public void verificoYConfirmoLaOrdenDeCompra() {
        checkout.validateOrder();
    }
}
