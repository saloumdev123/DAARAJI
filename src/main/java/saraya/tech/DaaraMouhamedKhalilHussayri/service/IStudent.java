package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface IStudent {


    Student createStudent(LocalDateTime dateOfBirth,
                          int studentNumber,
                          String parentsAddress,
                          String parentsContactsInfo,
                          LocalDateTime entryDateDaara,
                          String koranicStudyLevel,
                          Set<Course> courseList,
                          Set<Teacher> teachers);
    Student getStudentById(Long studentId);
    List<Student> getAllStudents();
    void updateStudentInfo(Long studentId,
                           LocalDateTime dateOfBirth,
                           int studentNumber,
                           String parentsAddress,
                           String parentsContactsInfo,
                           LocalDateTime entryDateDaara,
                           String koranicStudyLevel, Set<Course> courseList, Set<Teacher> teachers);
    void deleteStudentById(Long studentId);


    Payment makePayment(Long studentId,
                        LocalDate paymentDate,
                        Double paymentAmount,
                        String paymentMethod,
                        String paymentStatus,
                        String transactionReference);
    List<Payment> getPaymentHistoryByStudent(Long studentId);

    Double getOutstandingBalance(Long studentId);

    void updatePaymentStatus(Long paymentId, String newPaymentStatus);
}
