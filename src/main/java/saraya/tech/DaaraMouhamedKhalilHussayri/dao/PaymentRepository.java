package saraya.tech.DaaraMouhamedKhalilHussayri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByStudent(Student student);
}
