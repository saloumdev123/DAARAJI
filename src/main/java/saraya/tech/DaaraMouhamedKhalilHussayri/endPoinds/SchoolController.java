package saraya.tech.DaaraMouhamedKhalilHussayri.endPoinds;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.School;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.SchoolServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {


    private final SchoolServiceImpl schoolService;


    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School createdSchool = schoolService.createSchool(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return ResponseEntity.ok(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return ResponseEntity.ok(schools);
    }

    @PutMapping("/{schoolId}")
    public ResponseEntity<Void> updateSchoolInfo(@PathVariable Long schoolId,
                                                 @RequestParam String name,
                                                 @RequestParam String address,
                                                 @RequestParam String phoneNumber) {
        schoolService.updateSchoolInfo(schoolId, name, address, phoneNumber);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{schoolId}")
    public ResponseEntity<Void> deleteSchoolById(@PathVariable Long schoolId) {
        schoolService.deleteSchoolById(schoolId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{schoolId}/teachers/{teacherId}")
    public ResponseEntity<Void> addTeacherToSchool(@PathVariable Long schoolId, @PathVariable Long teacherId) {
        schoolService.addTeacherToSchool(schoolId, teacherId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{schoolId}/teachers/{teacherId}")
    public ResponseEntity<Void> removeTeacherFromSchool(@PathVariable Long schoolId, @PathVariable Long teacherId) {
        schoolService.removeTeacherFromSchool(schoolId, teacherId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{schoolId}/students/{studentId}")
    public ResponseEntity<Void> addStudentToSchool(@PathVariable Long schoolId, @PathVariable Long studentId) {
        schoolService.addStudentToSchool(schoolId, studentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{schoolId}/students/{studentId}")
    public ResponseEntity<Void> removeStudentFromSchool(@PathVariable Long schoolId, @PathVariable Long studentId) {
        schoolService.removeStudentFromSchool(schoolId, studentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{schoolId}/courses/{courseId}")
    public ResponseEntity<Void> addCourseToSchool(@PathVariable Long schoolId, @PathVariable Long courseId) {
        schoolService.addCourseToSchool(schoolId, courseId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{schoolId}/courses/{courseId}")
    public ResponseEntity<Void> removeCourseFromSchool(@PathVariable Long schoolId, @PathVariable Long courseId) {
        schoolService.removeCourseFromSchool(schoolId, courseId);
        return ResponseEntity.noContent().build();
    }
}
