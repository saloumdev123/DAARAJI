package saraya.tech.DaaraMouhamedKhalilHussayri.endPoinds;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saraya.tech.DaaraMouhamedKhalilHussayri.exception.ResourceNotFoundException;
import saraya.tech.DaaraMouhamedKhalilHussayri.model.Course;
import saraya.tech.DaaraMouhamedKhalilHussayri.service.CourseServiceImpl;

import java.util.List;

    @RestController
    @RequestMapping("/courses")
    @RequiredArgsConstructor
    public class CourseController {

       private final CourseServiceImpl courseService;

        @PostMapping
        public ResponseEntity<Course> createCourse(@RequestBody Course course) {
            Course savedCourse = courseService.saveCourse(course);
            return ResponseEntity.ok(savedCourse);
        }

        @GetMapping("/{courseId}")
        public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
            Course course = courseService.getCourseById(courseId)
                    .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
            return ResponseEntity.ok(course);
        }

        @GetMapping
        public ResponseEntity<List<Course>> getAllCourses() {
            List<Course> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        }

        @PutMapping("/{courseId}")
        public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course courseDetails) {
            Course updatedCourse = courseService.updateCourse(courseId, courseDetails);
            return ResponseEntity.ok(updatedCourse);
        }

        @DeleteMapping("/{courseId}")
        public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
            courseService.deleteCourse(courseId);
            return ResponseEntity.noContent().build();
        }

}
