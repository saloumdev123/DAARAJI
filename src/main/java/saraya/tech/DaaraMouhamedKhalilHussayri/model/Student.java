package saraya.tech.DaaraMouhamedKhalilHussayri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private LocalDateTime dateOfBirth;
    private int studentNumber;
    private String parentsAddress;
    private String parentsContactsInfo;
    private LocalDateTime entryDateDaara;
    private String koranicStudyLevel;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courseList;
    @ManyToMany(fetch= FetchType.EAGER)
    private Set<Teacher> teachers;
    private Double totalFees;

}
