package com.example.Task1.Student_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<Object> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student records not found!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(students);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student record saved!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        return studentService.getStudentById(id)
                .map(oldStud -> {
                    student.setStudId(oldStud.getStudId());
                    studentService.saveStudent(student);
                    return ResponseEntity.status(HttpStatus.OK).body("Student record updated for id " + id);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found for id " + id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        return studentService.getStudentById(id)
                .map(student -> {
                    studentService.deleteStudent(id);
                    return ResponseEntity.status(HttpStatus.OK).body("Student record deleted for id " + id);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found for id " + id));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body("All student records deleted successfully!");
    }
}
