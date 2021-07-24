package net.dermatologas.pacienturegistracija.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String doctorFirstName;
    private String doctorLastName;

    public Doctor(String doctorFirstName, String doctorLastName) {
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
    }
}
