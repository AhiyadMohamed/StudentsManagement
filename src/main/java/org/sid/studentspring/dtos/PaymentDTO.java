package org.sid.studentspring.dtos;

import lombok.*;
import org.sid.studentspring.entities.PaymentStatus;
import org.sid.studentspring.entities.PaymentType;
import org.sid.studentspring.entities.Student;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {
    private Long id ;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
    private String file;
    private Student student;
}
