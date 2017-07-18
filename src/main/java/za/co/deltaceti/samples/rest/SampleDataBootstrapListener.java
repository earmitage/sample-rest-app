package za.co.deltaceti.samples.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import za.co.deltaceti.samples.rest.entity.AuthorityName;
import za.co.deltaceti.samples.rest.entity.Driver;
import za.co.deltaceti.samples.rest.entity.User;
import za.co.deltaceti.samples.rest.repository.DriverRepository;
import za.co.deltaceti.samples.rest.repository.UserRepository;

@Component
public class SampleDataBootstrapListener {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent() {
        driverRepository.save(new Driver("sebastian", "vettel", "Sebastian", "Vettel", "sebastian.vettel@ferrari.com", true));
        userRepository.save(new User("admin", "admin", "theAdmin", "Admin", "admin@admin.com", true, AuthorityName.ROLE_ADMIN));
    }

}
