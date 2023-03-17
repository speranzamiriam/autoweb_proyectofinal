Feature: Funcionalidad Checkout Open Cart
  Rule: Yo como usuario invitado quiero realizar una compra de un producto
  dentro de la aplicación de manera exitosa y con todos mis datos correctamente.

    Background: Ingresar a la web
      Given que como usuario ingresa a la web

    Scenario Outline:Validar que la orden de un producto fue exitoso
      When busco el producto <product> y agrego al carrito
      And me dirijo a realizar la compra como <optionCustomer>
      And ingreso mis datos <name>, <lastName>, <email>, <phone> y envio de productos <address>, <city>, <country>, <state>
      And ingreso un metodo de delivery <description>
      And selecciono el metodo de pago <methodPay>
      Then verifico y confirmo la orden de compra
      Examples:
        | product | optionCustomer | name  | lastName | email            | phone     | address         | city      | country | state | description       | methodPay        |
        | iPhone  | Guest Checkout | Erick | Montes   | montes@gmail.com | 969929278 | Jiron Salaverry | Surquillo | Peru    | Lima  | envio a domicilio | Cash On Delivery |
