package saraya.tech.DaaraMouhamedKhalilHussayri.service;

import saraya.tech.DaaraMouhamedKhalilHussayri.dao.PaymentRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.dao.StudentRepository;
import saraya.tech.DaaraMouhamedKhalilHussayri.exception.ResourceNotFoundException;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Payment;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class StudentImpl implements IStudent{
    private final StudentRepository studentRepository;
    private final PaymentRepository paymentRepository;

    public StudentImpl(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Student createStudent(LocalDateTime dateOfBirth, int studentNumber, String parentsAddress, String parentsContactsInfo, LocalDateTime entryDateDaara, String koranicStudyLevel, Set<Course> courseList, Set<Teacher> teachers) {
        return null;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void updateStudentInfo(Long studentId, LocalDateTime dateOfBirth, int studentNumber, String parentsAddress, String parentsContactsInfo, LocalDateTime entryDateDaara, String koranicStudyLevel, Set<Course> courseList, Set<Teacher> teachers) {
        Student student = getStudentById(studentId);
        student.setDateOfBirth(dateOfBirth);
        student.setStudentNumber(studentNumber);
        student.setParentsAddress(parentsAddress);
        student.setParentsContactsInfo(parentsContactsInfo);
        student.setEntryDateDaara(entryDateDaara);
        student.setKoranicStudyLevel(koranicStudyLevel);
        student.setCourseList(courseList);
        student.setTeachers(teachers);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        Student student = getStudentById(studentId);
        studentRepository.delete(student);
    }



    @Override
    public Payment makePayment(Long studentId,
                               LocalDate paymentDate,
                               Double paymentAmount,
                               String paymentMethod,
                               String paymentStatus,
                               String transactionReference) {
        Student student = getStudentById(studentId);
        Payment payment = new Payment(student,
                                      paymentDate,
                                      paymentAmount, paymentMethod,
                                      paymentStatus, transactionReference);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentHistoryByStudent(Long studentId) {
        Student student = getStudentById(studentId);
        return paymentRepository.findByStudent(student);
    }

    @Override
    public Double getOutstandingBalance(Long studentId) {
        Student student = getStudentById(studentId);
        List<Payment> payments = getPaymentHistoryByStudent(studentId);
        double totalPaid = payments.stream().mapToDouble(Payment::getPaymentAmount).sum();
        // Calcul du solde restant à payer
        return student.getTotalFees() - totalPaid;
    }

    @Override
    public void updatePaymentStatus(Long paymentId, String newPaymentStatus) {
        Payment payment = paymentRepository.findById(paymentId).
                orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + paymentId));
        payment.setPaymentStatus(newPaymentStatus);
        paymentRepository.save(payment);
    }
}

