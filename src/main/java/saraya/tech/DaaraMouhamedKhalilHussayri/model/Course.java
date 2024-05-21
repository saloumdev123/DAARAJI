package saraya.tech.DaaraMouhamedKhalilHussayri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long courseId;
    private String courseType;
    private String courseName;
    private String courseDescription;
    private String courseSubject;
    private LocalDateTime courseStartDate ;
    private LocalDateTime courseEndDate;
    private LocalDateTime courseDuration;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "course_teacher",
                joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teacherList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "course_student",
                joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> studentList;
    private int numberOfStudents;
    private String courseSchedule;
    private Duration courseDurations = Duration.ofHours(2);
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
