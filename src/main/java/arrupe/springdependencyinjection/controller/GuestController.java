package arrupe.springdependencyinjection.controller;

import arrupe.springdependencyinjection.model.Guest;
import arrupe.springdependencyinjection.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    private final GuestService guestService;
    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }
    @PostMapping("/create")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }
}
