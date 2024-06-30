package com.example.Task1.Student_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    //sorting
    public List<Student> sortStudent(String field) {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    //pagination
    public Page<Student> getStudentWithPagination(int page, int pageSize) {
        return studentRepository.findAll(PageRequest.of(page, pageSize));
    }

}
