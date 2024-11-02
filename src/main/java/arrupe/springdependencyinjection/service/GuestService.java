package arrupe.springdependencyinjection.service;

import arrupe.springdependencyinjection.model.Guest;
import arrupe.springdependencyinjection.model.Responsible;
import arrupe.springdependencyinjection.repository.GuestRepository;
import arrupe.springdependencyinjection.repository.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final ResponsibleRepository responsibleRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository, ResponsibleRepository responsibleRepository) {
        this.guestRepository = guestRepository;
        this.responsibleRepository = responsibleRepository;
    }

    public int calculateAge(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public Guest saveGuest(Guest guest) {
        int age = calculateAge(guest.getBirthdate());

        if (age < 18) {
            guest.setDUI(null);
            if (guest.getResponsible() == null) {
                throw new IllegalArgumentException("El campo 'responsable' es obligatorio para menores de edad.");
            }
            Responsible responsible = guest.getResponsible();
            responsibleRepository.save(responsible);
        } else {
            guest.setResponsible(null);
            if (guest.getDUI() == null || guest.getDUI().isEmpty()) {
                throw new IllegalArgumentException("El campo 'DUI' es obligatorio para mayores de edad.");
            }
        }

        return guestRepository.save(guest);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
}
