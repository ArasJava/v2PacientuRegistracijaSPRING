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

public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long patientId;
    private long doctorID;
    private String date;
    private String time;
    private String purpose;
    private String message;
    private String registrationCode;

    public Registration(long patientId, long doctorID, String date, String time, String purpose, String message, String registrationCode) {
        this.patientId = patientId;
        this.doctorID = doctorID;
        this.date = date;
        this.time = time;
        this.purpose = purpose;
        this.message = message;
        this.registrationCode = registrationCode;
    }
}
