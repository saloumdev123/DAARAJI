package saraya.tech.DaaraMouhamedKhalilHussayri.dto;

import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;

import java.time.LocalDateTime;
import java.util.Set;

public class StudentRequest {

    private LocalDateTime dateOfBirth;
    private int studentNumber;
    private String parentsAddress;
    private String parentsContactsInfo;
    private LocalDateTime entryDateDaara;
    private String koranicStudyLevel;
    private Set<Course> courseList;
    private Set<Teacher> teachers;


    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getParentsAddress() {
        return parentsAddress;
    }

    public void setParentsAddress(String parentsAddress) {
        this.parentsAddress = parentsAddress;
    }

    public String getParentsContactsInfo() {
        return parentsContactsInfo;
    }

    public void setParentsContactsInfo(String parentsContactsInfo) {
        this.parentsContactsInfo = parentsContactsInfo;
    }

    public LocalDateTime getEntryDateDaara() {
        return entryDateDaara;
    }

    public void setEntryDateDaara(LocalDateTime entryDateDaara) {
        this.entryDateDaara = entryDateDaara;
    }

    public String getKoranicStudyLevel() {
        return koranicStudyLevel;
    }

    public void setKoranicStudyLevel(String koranicStudyLevel) {
        this.koranicStudyLevel = koranicStudyLevel;
    }

    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
