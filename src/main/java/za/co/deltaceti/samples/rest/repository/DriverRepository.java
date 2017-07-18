package za.co.deltaceti.samples.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import za.co.deltaceti.samples.rest.entity.Driver;

@RepositoryRestResource(path = "drivers", collectionResourceRel = "drivers")
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByUsername(@Param("username") final String username);

}
