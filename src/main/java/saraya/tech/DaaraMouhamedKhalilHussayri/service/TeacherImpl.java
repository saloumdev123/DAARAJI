package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.CourseRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.StudentRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.TeacherRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.exception.ResourceNotFoundException;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherImpl implements ITeacher{

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    @Override
    public Teacher createTeacher(Integer registrationNumber, Long number, String religiousExperienceTraining, LocalDateTime teachingStartDateDaara, List<String> subjectsTaughtLevels, LocalDateTime courseScheduleTimetable, List<Student> studentList, Set<Course> courses) {
        Teacher teacher = new Teacher();
        teacher.setRegistrationNumber(registrationNumber);
        teacher.setNumber(number);
        teacher.setReligious_experience_training (religiousExperienceTraining);
        teacher.setTeachingStartDateDaara(teachingStartDateDaara);
        teacher.setSubjectsTaughtLevels(subjectsTaughtLevels);
        teacher.setCourse_schedule_timetable(courseScheduleTimetable);
        teacher.setStudentList(studentList);
        teacher.setCourses(courses);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + teacherId));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteTeacherById(Long teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        teacherRepository.delete(teacher);
    }

    @Override
    public void addStudentToTeacher(Long teacherId, Long studentId) {
        Teacher teacher = getTeacherById(teacherId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        teacher.getStudentList().add(student);
        teacherRepository.save(teacher);
    }

    @Override
    public void addCourseToTeacher(Long teacherId, Long courseId) {
        Teacher teacher = getTeacherById(teacherId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        teacher.getCourses().add(course);
        teacherRepository.save(teacher);
    }

    @Override
    public void removeStudentFromTeacher(Long teacherId, Long studentId) {
        Teacher teacher = getTeacherById(teacherId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        teacher.getStudentList().remove(student);
        teacherRepository.save(teacher);
    }

    @Override
    public void removeCourseFromTeacher(Long teacherId, Long courseId) {
        Teacher teacher = getTeacherById(teacherId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        teacher.getCourses().remove(course);
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacherInfo(Long teacherId, Integer registrationNumber, Long number, String religiousExperienceTraining, LocalDateTime teachingStartDateDaara, List<String> subjectsTaughtLevels, LocalDateTime courseScheduleTimetable, List<Student> studentList, Set<Course> courses) {
        Teacher teacher = getTeacherById(teacherId);
        teacher.setRegistrationNumber(registrationNumber);
        teacher.setNumber(number);
        teacher.setReligious_experience_training(religiousExperienceTraining);
        teacher.setTeachingStartDateDaara(teachingStartDateDaara);
        teacher.setSubjectsTaughtLevels(subjectsTaughtLevels);
        teacher.setCourse_schedule_timetable(courseScheduleTimetable);
        teacher.setStudentList(studentList);
        teacher.setCourses(courses);
        teacherRepository.save(teacher);
    }
}

