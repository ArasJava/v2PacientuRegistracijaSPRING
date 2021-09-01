package net.dermatologas.pacienturegistracija.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private long patientId;
    private String date;
    private String time;
    private String purpose;
    private String message;
//    private String registrationCode;

//    @ManyToOne
//    @JoinColumn(name = "registration_id")
//    private Registration registration;

//    @OneToOne
//    @JoinColumn(name = "doc_id")
//    private Doctor doctor;

}
