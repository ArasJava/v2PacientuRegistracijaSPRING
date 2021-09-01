package net.dermatologas.pacienturegistracija.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String telephoneNumber;
//    private String patientCode;
//    @OneToOne
//    @JoinColumn(name = "reg_id")
//    private Registration registration;


}
