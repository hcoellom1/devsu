Feature: Clientes

Background:
 * url baseUri

Scenario: Crear cliente
    Given path 'api/clientes/crear'
    And request
    """
    {
        "codigoCliente": 25,
        "nombre": "Harold Coello",
        "genero": "masculino",
        "edad": 25,
        "direccion": "El Carrizal",
        "telefono": "2222",
        "contrasenia": "roow",
        "estado": true
    }
    """
    When method POST
    Then status 201
    And match response.codigoCliente != null

Scenario: Obtener cliente por id
    Given path 'api/clientes/obtener/1'
    When method GET
    Then status 200
    And match response.nombre == 'Harold Coello'