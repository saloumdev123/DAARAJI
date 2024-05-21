package saraya.tech.DaaraMouhamedKhalilHussayri.service.imple;

import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourse {
    Course saveCourse(Course course);
    Optional<Course> getCourseById(Long courseId);
    List<Course> getAllCourses();
    Course updateCourse(Long courseId, Course course);
    void deleteCourse(Long courseId);
}
