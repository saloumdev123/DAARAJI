package saraya.tech.DaaraMouhamedKhalilHussayri.endPoinds;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Student;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Teacher;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.TeacherImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherImpl teacherService;

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestParam Integer registrationNumber,
                                                 @RequestParam Long number,
                                                 @RequestParam String religiousExperienceTraining,
                                                 @RequestParam LocalDateTime teachingStartDateDaara,
                                                 @RequestParam List<String> subjectsTaughtLevels,
                                                 @RequestParam LocalDateTime courseScheduleTimetable,
                                                 @RequestParam List<Student> studentList,
                                                 @RequestParam Set<Course> courses) {
        Teacher teacher = teacherService.createTeacher(registrationNumber, number, religiousExperienceTraining,
                teachingStartDateDaara, subjectsTaughtLevels, courseScheduleTimetable, studentList, courses);
        return ResponseEntity.status(HttpStatus.CREATED).body(teacher);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Void> updateTeacherInfo(@PathVariable Long teacherId,
                                                  @RequestParam Integer registrationNumber,
                                                  @RequestParam Long number,
                                                  @RequestParam String religiousExperienceTraining,
                                                  @RequestParam LocalDateTime teachingStartDateDaara,
                                                  @RequestParam List<String> subjectsTaughtLevels,
                                                  @RequestParam LocalDateTime courseScheduleTimetable,
                                                  @RequestParam List<Student> studentList,
                                                  @RequestParam Set<Course> courses) {
        teacherService.updateTeacherInfo(teacherId, registrationNumber, number, religiousExperienceTraining,
                teachingStartDateDaara, subjectsTaughtLevels, courseScheduleTimetable, studentList, courses);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable Long teacherId) {
        teacherService.deleteTeacherById(teacherId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{teacherId}/students/{studentId}")
    public ResponseEntity<Void> addStudentToTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        teacherService.addStudentToTeacher(teacherId, studentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{teacherId}/students/{studentId}")
    public ResponseEntity<Void> removeStudentFromTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        teacherService.removeStudentFromTeacher(teacherId, studentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{teacherId}/courses/{courseId}")
    public ResponseEntity<Void> addCourseToTeacher(@PathVariable Long teacherId, @PathVariable Long courseId) {
        teacherService.addCourseToTeacher(teacherId, courseId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{teacherId}/courses/{courseId}")
    public ResponseEntity<Void> removeCourseFromTeacher(@PathVariable Long teacherId, @PathVariable Long courseId) {
        teacherService.removeCourseFromTeacher(teacherId, courseId);
        return ResponseEntity.noContent().build();
    }
}