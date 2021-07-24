package net.dermatologas.pacienturegistracija.Repository;

import net.dermatologas.pacienturegistracija.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}