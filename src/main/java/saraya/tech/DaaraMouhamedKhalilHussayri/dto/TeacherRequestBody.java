package saraya.tech.DaaraMouhamedKhalilHussayri.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequestBody {
        private Integer registrationNumber;
        private Long number;
        private String religiousExperienceTraining;
        private LocalDateTime teachingStartDateDaara;
        private Map<String, List<String>> subjectsTaughtLevels;
        private LocalDateTime courseScheduleTimetable;
        private List<Student> studentList;
        private Set<Course> courses;


        public Integer getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(Integer registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public String getReligiousExperienceTraining() {
            return religiousExperienceTraining;
        }

        public void setReligiousExperienceTraining(String religiousExperienceTraining) {
            this.religiousExperienceTraining = religiousExperienceTraining;
        }

        public LocalDateTime getTeachingStartDateDaara() {
            return teachingStartDateDaara;
        }

        public void setTeachingStartDateDaara(LocalDateTime teachingStartDateDaara) {
            this.teachingStartDateDaara = teachingStartDateDaara;
        }

        public Map<String, List<String>> getSubjectsTaughtLevels() {
            return subjectsTaughtLevels;
        }

        public void setSubjectsTaughtLevels(Map<String, List<String>> subjectsTaughtLevels) {
            this.subjectsTaughtLevels = subjectsTaughtLevels;
        }

        public LocalDateTime getCourseScheduleTimetable() {
            return courseScheduleTimetable;
        }

        public void setCourseScheduleTimetable(LocalDateTime courseScheduleTimetable) {
            this.courseScheduleTimetable = courseScheduleTimetable;
        }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}