package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import org.springframework.stereotype.Service;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentImpl implements IPayment{
    @Override
    public Payment createPayment(Long studentId,
                                 LocalDate paymentDate,
                                 Double paymentAmount,
                                 String paymentMethod,
                                 String paymentStatus,
                                 String transactionReference) {
        return null;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return null;
    }

    @Override
    public List<Payment> getAllPaymentsByStudentId(Long studentId) {
        return null;
    }

    @Override
    public void updatePaymentStatus(Long paymentId, String newPaymentStatus) {

    }

    @Override
    public void deletePaymentById(Long paymentId) {

    }
}
