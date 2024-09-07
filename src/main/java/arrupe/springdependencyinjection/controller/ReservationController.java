package arrupe.springdependencyinjection.controller;

import arrupe.springdependencyinjection.model.Reservation;
import arrupe.springdependencyinjection.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<List<Reservation>> getReservations(@PathVariable int reservationId) {
        return ResponseEntity.ok(reservationService.getReservationsById(reservationId));
    }
}
