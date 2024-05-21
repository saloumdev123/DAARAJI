package saraya.tech.DaaraMouhamedKhalilHussayri.endPoinds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saraya.tech.DaaraMouhamedKhalilHussayri.dto.PaymentRequest;
import saraya.tech.DaaraMouhamedKhalilHussayri.dto.PaymentStatusRequest;
import saraya.tech.DaaraMouhamedKhalilHussayri.dto.StudentRequest;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.IStudent;


import java.util.List;



@RestController
@RequestMapping("/students")
public class StudentController {
        private final IStudent studentService;

        @Autowired
        public StudentController(IStudent studentService) {
            this.studentService = studentService;
        }

        @PostMapping
        public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest) {
            Student student = studentService.createStudent(
                    studentRequest.getDateOfBirth(),
                    studentRequest.getStudentNumber(),
                    studentRequest.getParentsAddress(),
                    studentRequest.getParentsContactsInfo(),
                    studentRequest.getEntryDateDaara(),
                    studentRequest.getKoranicStudyLevel(),
                    studentRequest.getCourseList(),
                    studentRequest.getTeachers()
            );
            return ResponseEntity.ok(student);
        }

        @GetMapping("/{studentId}")
        public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
            Student student = studentService.getStudentById(studentId);
            return ResponseEntity.ok(student);
        }

        @GetMapping
        public ResponseEntity<List<Student>> getAllStudents() {
            List<Student> students = studentService.getAllStudents();
            return ResponseEntity.ok(students);
        }

        @PutMapping("/{studentId}")
        public ResponseEntity<Void> updateStudentInfo(@PathVariable Long studentId, @RequestBody StudentRequest studentRequest) {
            studentService.updateStudentInfo(
                    studentId,
                    studentRequest.getDateOfBirth(),
                    studentRequest.getStudentNumber(),
                    studentRequest.getParentsAddress(),
                    studentRequest.getParentsContactsInfo(),
                    studentRequest.getEntryDateDaara(),
                    studentRequest.getKoranicStudyLevel(),
                    studentRequest.getCourseList(),
                    studentRequest.getTeachers()
            );
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/{studentId}")
        public ResponseEntity<Void> deleteStudentById(@PathVariable Long studentId) {
            studentService.deleteStudentById(studentId);
            return ResponseEntity.noContent().build();
        }

        @PostMapping("/{studentId}/payments")
        public ResponseEntity<Payment> makePayment(
                @PathVariable Long studentId,
                @RequestBody PaymentRequest paymentRequest) {
            Payment payment = studentService.makePayment(
                    studentId,
                    paymentRequest.getPaymentDate(),
                    paymentRequest.getPaymentAmount(),
                    paymentRequest.getPaymentMethod(),
                    paymentRequest.getPaymentStatus(),
                    paymentRequest.getTransactionReference()
            );
            return ResponseEntity.ok(payment);
        }

        @GetMapping("/{studentId}/payments")
        public ResponseEntity<List<Payment>> getPaymentHistoryByStudent(@PathVariable Long studentId) {
            List<Payment> payments = studentService.getPaymentHistoryByStudent(studentId);
            return ResponseEntity.ok(payments);
        }

        @GetMapping("/{studentId}/outstanding-balance")
        public ResponseEntity<Double> getOutstandingBalance(@PathVariable Long studentId) {
            Double balance = studentService.getOutstandingBalance(studentId);
            return ResponseEntity.ok(balance);
        }

        @PutMapping("/payments/{paymentId}/status")
        public ResponseEntity<Void> updatePaymentStatus(@PathVariable Long paymentId, @RequestBody PaymentStatusRequest paymentStatusRequest) {
            studentService.updatePaymentStatus(paymentId, paymentStatusRequest.getNewPaymentStatus());
            return ResponseEntity.noContent().build();
        }
}


