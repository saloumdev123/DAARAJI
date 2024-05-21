package saraya.tech.DaaraMouhamedKhalilHussayri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Long StudentId;
    private LocalDate paymentDate;
    private Double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionReference;

    @ManyToOne
    private Student student;





}
//Use '@Column(insertable=false, updatable=false)' when mapping multiple properties to the same column)