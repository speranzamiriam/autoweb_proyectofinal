Feature: Funcionalidad CURA Healthcare Service
  Rule: Yo como usuario invitado quiero realizar un registro de los datos el centro de atención
  dentro de la aplicación de manera exitosa y con todos mis datos correctamente.

    Background: Ingresar a la web
      Given que como usuario ingresa a la web
      And ingreso a la web como invitado con el usuario John Doe y password ThisIsNotAPassword

    Scenario Outline:Validar que el registro de datos del centro de atención fue exitoso
      When registro los datos de Facility <Facility>,<Apply for hospital readmission>,<HealthcareProgram>,<VisitDate> y <Comment>
      Then verifico que se muestre la informacion <Facility>,<Apply for hospital readmission>,<HealthcareProgram>,<VisitDate> y <Comment>
      Examples:
        | Facility                       |Apply for hospital readmission|HealthcareProgram|VisitDate  |Comment     |
        | Hongkong CURA Healthcare Center|Yes                           |Medicaid         |12/05/2023 |El dia lunes|
