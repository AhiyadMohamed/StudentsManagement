package org.sid.studentspring;

import org.sid.studentspring.entities.Payment;
import org.sid.studentspring.entities.PaymentStatus;
import org.sid.studentspring.entities.PaymentType;
import org.sid.studentspring.entities.Student;
import org.sid.studentspring.repositories.PaymentRepository;
import org.sid.studentspring.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class StudentSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString()).firstName("John").code("112233").programId("SDIA")
                    .build());

            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString()).firstName("Alex").code("442233").programId("BDCC")
                    .build());

            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString()).firstName("Felix").code("552211").programId("SDIA")
                    .build());

            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString()).firstName("Kevin").code("667744").programId("GLSID")
                    .build());

            studentRepository.findAll().forEach(st -> {
                for (int i = 0; i < 40; i++) {
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()+20000))
                            .type(Math.random() > 0.5 ? PaymentType.TRANSFER : PaymentType.CASH)
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };
    }
}
