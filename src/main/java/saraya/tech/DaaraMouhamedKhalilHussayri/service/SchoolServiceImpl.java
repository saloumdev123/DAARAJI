package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.CourseRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.SchoolRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.StudentRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.TeacherRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.exception.ResourceNotFoundException;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.School;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.imple.ISchool;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements ISchool {


    private final SchoolRepository schoolRepository;

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School getSchoolById(Long schoolId) {
        return schoolRepository.findById(schoolId)
                .orElseThrow(() -> new ResourceNotFoundException("School not found with id " + schoolId));
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public void deleteSchoolById(Long schoolId) {
        School school = getSchoolById(schoolId);
        schoolRepository.delete(school);
    }

    @Override
    public void addTeacherToSchool(Long schoolId, Long teacherId) {
        School school = getSchoolById(schoolId);
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + teacherId));
        school.getTeachers().add(teacher);
        schoolRepository.save(school);
    }

    @Override
    public void removeTeacherFromSchool(Long schoolId, Long teacherId) {
        School school = getSchoolById(schoolId);
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + teacherId));
        school.getTeachers().remove(teacher);
        schoolRepository.save(school);
    }

    @Override
    public void addStudentToSchool(Long schoolId, Long studentId) {
        School school = getSchoolById(schoolId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        school.getStudents().add(student);
        schoolRepository.save(school);
    }

    @Override
    public void removeStudentFromSchool(Long schoolId, Long studentId) {
        School school = getSchoolById(schoolId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        school.getStudents().remove(student);
        schoolRepository.save(school);
    }

    @Override
    public void addCourseToSchool(Long schoolId, Long courseId) {
        School school = getSchoolById(schoolId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        school.getCourses().add(course);
        schoolRepository.save(school);
    }

    @Override
    public void removeCourseFromSchool(Long schoolId, Long courseId) {
        School school = getSchoolById(schoolId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        school.getCourses().remove(course);
        schoolRepository.save(school);
    }
    @Override
    public void updateSchoolInfo(Long schoolId, String name, String address, String phoneNumber) {
        School school = getSchoolById(schoolId);
        school.setName(name);
        school.setAddress(address);
        school.setPhoneNumber(phoneNumber);
        schoolRepository.save(school);
    }

}
