package display.display_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/ui/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Student fetchStudentById(@PathVariable Integer id) {
        System.out.println("Test ....." + id);
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentEntity studentEntity) {
        System.out.println("Test .save...Database.");
        return studentService.createStudent(studentEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Integer id) {
        String msg = "";
        Student std = studentService.getStudentById(id);
        if (std != null) {
            studentService.deleteStudent(id);
            System.out.println("Test .delete...Database." + id);
            msg = "delete record  is : " + id;
        } else {
            msg = "delete record is not present in data base: " + id;
            System.out.println("delete record is not present in data base: " + id);
        }
        return msg;
    }
}
