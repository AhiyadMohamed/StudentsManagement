package org.sid.studentspring.web;


import lombok.AllArgsConstructor;
import org.sid.studentspring.entities.Payment;
import org.sid.studentspring.entities.PaymentStatus;
import org.sid.studentspring.entities.PaymentType;
import org.sid.studentspring.entities.Student;
import org.sid.studentspring.repositories.PaymentRepository;
import org.sid.studentspring.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentRestController {

    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    @GetMapping(path = "/payments")
    public List<Payment> allPayment(){
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }

    @GetMapping("/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{code}")
    public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }

    @GetMapping("/students/program")
    public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }

    @GetMapping("/students/{code}/payments")
    public List<Payment> paymentsByStudent(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping("/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }

    @GetMapping("/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }
}
