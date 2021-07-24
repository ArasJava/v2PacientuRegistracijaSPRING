package net.dermatologas.pacienturegistracija.Repository;

import net.dermatologas.pacienturegistracija.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    void deleteRegistrationById(Long id);

    Optional<Registration> findRegistrationById(Long id);
}
