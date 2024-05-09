package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.CourseRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.TeacherRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.exception.ResourceNotFoundException;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherImpl implements ITeacher{

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    @Override
    public Teacher createTeacher(Integer registrationNumber, Long number, String religious_experience_training, LocalDateTime teachingStartDateDaara, LocalDateTime subjectsTaughtLevels, LocalDateTime course_schedule_timetable, List<Student> studentList, Set<Course> courses) {
        return null;
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public void updateTeacherInfo(Long teacherId, Integer registrationNumber, Long number, String religious_experience_training, LocalDateTime teachingStartDateDaara, LocalDateTime subjectsTaughtLevels, LocalDateTime course_schedule_timetable, List<Student> studentList, Set<Course> courses) {

    }

    @Override
    public void deleteTeacherById(Long teacherId) {

    }

    @Override
    public void addStudentToTeacher(Long teacherId, Long studentId) {

    }

    @Override
    public void addCourseToTeacher(Long teacherId, Long courseId) {

    }

    @Override
    public void removeStudentFromTeacher(Long teacherId, Long studentId) {

    }

    @Override
    public void removeCourseFromTeacher(Long teacherId, Long courseId) {
        Teacher teacher = getTeacherById(teacherId);
        Course course = courseRepository.findById(courseId).
                orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
        teacher.getCourses().remove(course);
        teacherRepository.save(teacher);
    }
}
