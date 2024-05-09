package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;

import java.time.LocalDate;
import java.util.List;

public interface IPayment {

    Payment createPayment(Long studentId, LocalDate paymentDate, Double paymentAmount, String paymentMethod, String paymentStatus, String transactionReference);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPaymentsByStudentId(Long studentId);
    void updatePaymentStatus(Long paymentId, String newPaymentStatus);
    void deletePaymentById(Long paymentId);
}
