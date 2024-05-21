package saraya.tech.DaaraMouhamedKhalilHussayri.endPoinds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saraya.tech.DaaraMouhamedKhalilHussayri.dto.PaymentRequest;
import saraya.tech.DaaraMouhamedKhalilHussayri.dto.PaymentStatusRequest;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.IStudent;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

        private final IStudent studentService;

        @Autowired
        public PaymentController(IStudent studentService) {
            this.studentService = studentService;
        }

        @PostMapping("/{studentId}")
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

        @GetMapping("/{studentId}/history")
        public ResponseEntity<List<Payment>> getPaymentHistoryByStudent(@PathVariable Long studentId) {
            List<Payment> payments = studentService.getPaymentHistoryByStudent(studentId);
            return ResponseEntity.ok(payments);
        }

        @GetMapping("/{studentId}/outstanding-balance")
        public ResponseEntity<Double> getOutstandingBalance(@PathVariable Long studentId) {
            Double balance = studentService.getOutstandingBalance(studentId);
            return ResponseEntity.ok(balance);
        }

        @PutMapping("/{paymentId}/status")
        public ResponseEntity<Void> updatePaymentStatus(
                @PathVariable Long paymentId,
                @RequestBody PaymentStatusRequest paymentStatusRequest) {
            studentService.updatePaymentStatus(paymentId, paymentStatusRequest.getNewPaymentStatus());
            return ResponseEntity.noContent().build();
        }
}
