package arrupe.springdependencyinjection.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDto {
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
