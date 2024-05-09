package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ITeacher {
    Teacher createTeacher(Integer registrationNumber, Long number, String religious_experience_training, LocalDateTime teachingStartDateDaara, LocalDateTime subjectsTaughtLevels, LocalDateTime course_schedule_timetable, List<Student> studentList, Set<Course> courses);
    Teacher getTeacherById(Long teacherId);
    List<Teacher> getAllTeachers();
    void updateTeacherInfo(Long teacherId, Integer registrationNumber, Long number, String religious_experience_training, LocalDateTime teachingStartDateDaara, LocalDateTime subjectsTaughtLevels, LocalDateTime course_schedule_timetable, List<Student> studentList, Set<Course> courses);
    void deleteTeacherById(Long teacherId);
    void addStudentToTeacher(Long teacherId, Long studentId);
    void addCourseToTeacher(Long teacherId, Long courseId);
    void removeStudentFromTeacher(Long teacherId, Long studentId);
    void removeCourseFromTeacher(Long teacherId, Long courseId);
}

