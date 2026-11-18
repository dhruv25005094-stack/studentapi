package com.example.studentapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // GET METHOD
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    // POST METHOD
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        students.add(student);

        return ResponseEntity.ok(student);
    }

    // PUT METHOD
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(updatedStudent.getName());
                s.setAge(updatedStudent.getAge());

                return ResponseEntity.ok(s);
            }
        }

        return ResponseEntity.notFound().build();
    }
}