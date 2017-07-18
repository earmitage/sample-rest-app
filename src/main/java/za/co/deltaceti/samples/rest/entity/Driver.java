package za.co.deltaceti.samples.rest.entity;

import javax.persistence.Entity;

@Entity
public class Driver extends User {

    public Driver() {
        // jpa
    }

    public Driver(final String username, final String password, final String firstname, final String lastname, final String email, final Boolean enabled) {
        super(username, password, firstname, lastname, email, enabled, AuthorityName.ROLE_DRIVER);
    }

    public String getStudentId() {
        return getUsername();
    }

}
