package org.sid.studentspring.repositories;

import org.sid.studentspring.entities.Payment;
import org.sid.studentspring.entities.PaymentStatus;
import org.sid.studentspring.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);

}
