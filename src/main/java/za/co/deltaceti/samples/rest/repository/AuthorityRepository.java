package za.co.deltaceti.samples.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import za.co.deltaceti.samples.rest.entity.Authority;
import za.co.deltaceti.samples.rest.entity.AuthorityName;

// can't add new authorties via rest
@RepositoryRestResource(exported = false)
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(AuthorityName name);

}
