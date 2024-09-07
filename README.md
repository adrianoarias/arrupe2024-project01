# arrupe2024-project01

# Instalar dependencias

    mvn clean install

# Iniciar aplicación

    mvn spring-boot:run
    

## Crear reserva

POST http://localhost:8080/reservations

    {
	    "guestName": "Wolverine",
	    "checkInDate": "2024-09-10",
	    "checkOutDate": "2024-09-15"
    }

## Leer reserva

GET http://localhost:8080/reservations/{reservationId}
