package saraya.tech.DaaraMouhamedKhalilHussayri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
