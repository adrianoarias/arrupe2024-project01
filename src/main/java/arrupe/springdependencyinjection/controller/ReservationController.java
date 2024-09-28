package arrupe.springdependencyinjection.controller;

import arrupe.springdependencyinjection.dto.ReservationDto;
import arrupe.springdependencyinjection.model.Reservation;
import arrupe.springdependencyinjection.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservation controller", description = "")

public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping
    @Operation(summary = "Create reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDto reservation) {

        return ResponseEntity.ok(reservationService.createReservation(
                new Reservation(
                        0,
                        reservation.getGuestName(),
                        reservation.getCheckInDate(),
                        reservation.getCheckOutDate()
                )
        ));
    }

    @GetMapping("/{reservationId}")
    @Operation(summary = "Reservation details")
    public ResponseEntity<List<Reservation>> getReservations(@PathVariable int reservationId) {
        return ResponseEntity.ok(reservationService.getReservationsById(reservationId));
    }
}
