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
    private long doctor_id;
    private String date;
    private String time;
    private String purpose;
    private String message;


//    @ManyToOne
//    @JoinColumn(name = "registration_id")
//    private Registration registration;

//    @OneToOne
//    @JoinColumn(name = "doc_id")
//    private Doctor doctor;

}
