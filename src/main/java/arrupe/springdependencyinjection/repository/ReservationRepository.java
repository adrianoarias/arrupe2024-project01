package arrupe.springdependencyinjection.repository;

import arrupe.springdependencyinjection.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findById(int reservationId);
}
