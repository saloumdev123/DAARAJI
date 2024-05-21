package saraya.tech.DaaraMouhamedKhalilHussayri.service.imple;

import saraya.tech.DaaraMouhamedKhalilHussayri.model.School;

import java.util.List;

public interface ISchool {

    School createSchool(School school);
    School getSchoolById(Long schoolId);
    List<School> getAllSchools();
    void deleteSchoolById(Long schoolId);
    void addTeacherToSchool(Long schoolId, Long teacherId);
    void removeTeacherFromSchool(Long schoolId, Long teacherId);
    void addStudentToSchool(Long schoolId, Long studentId);
    void removeStudentFromSchool(Long schoolId, Long studentId);
    void addCourseToSchool(Long schoolId, Long courseId);
    void removeCourseFromSchool(Long schoolId, Long courseId);

    void updateSchoolInfo(Long schoolId, String name, String address, String phoneNumber);
}
