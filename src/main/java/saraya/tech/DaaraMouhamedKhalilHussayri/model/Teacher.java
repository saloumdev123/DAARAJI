package saraya.tech.DaaraMouhamedKhalilHussayri.model;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @Column(name = "registration_number")
    private Integer registrationNumber;

    @Column(length = 10,name="number_of_teachers", nullable = false)
    private Long number;

    @Column(name = "religious_experience")
    private String religious_experience_training;

    private LocalDateTime teachingStartDateDaara;

    @Column(name = "subject_taught_levels")
    private List<String> subjectsTaughtLevels;

    @Column(name = "student_schedule-timetable")
    private LocalDateTime course_schedule_timetable;

    @ManyToMany(fetch = FetchType.LAZY)
   private List<Student> studentList;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
