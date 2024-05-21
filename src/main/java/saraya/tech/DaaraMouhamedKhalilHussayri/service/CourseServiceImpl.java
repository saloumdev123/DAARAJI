package saraya.tech.DaaraMouhamedKhalilHussayri.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.CourseRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.exception.ResourceNotFoundException;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.imple.ICourse;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourse {
        @Autowired
        private CourseRepository courseRepository;

        @Override
        public Course saveCourse(Course course) {
            return courseRepository.save(course);
        }



    @Override
        public Optional<Course> getCourseById(Long courseId) {
            return courseRepository.findById(courseId);
        }

        @Override
        public List<Course> getAllCourses() {
            return courseRepository.findAll();
        }

        @Override
        public Course updateCourse(Long courseId, Course course) {
            return courseRepository.findById(courseId).map(existingCourse -> {
                existingCourse.setCourseType(course.getCourseType());
                existingCourse.setCourseName(course.getCourseName());
                existingCourse.setCourseDescription(course.getCourseDescription());
                existingCourse.setCourseSubject(course.getCourseSubject());
                existingCourse.setCourseStartDate(course.getCourseStartDate());
                existingCourse.setCourseEndDate(course.getCourseEndDate());
                existingCourse.setTeacherList(course.getTeacherList());
                existingCourse.setStudentList(course.getStudentList());
                existingCourse.setNumberOfStudents(course.getNumberOfStudents());
                existingCourse.setCourseSchedule(course.getCourseSchedule());
                existingCourse.setCourseDuration(course.getCourseDuration());
                return courseRepository.save(existingCourse);
            }).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        }

        @Override
        public void deleteCourse(Long courseId) {
            courseRepository.deleteById(courseId);
        }

}
