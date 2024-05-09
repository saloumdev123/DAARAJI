package saraya.tech.DaaraMouhamedKhalilHussayri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
