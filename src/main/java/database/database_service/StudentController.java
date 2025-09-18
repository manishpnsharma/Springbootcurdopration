package database.database_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/ui/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id) {
        System.out.println("Test ....Database." + id);
        Student se = new Student();
        se.setStudent_id(id);
        return studentService.displayById(se);

    }

    @GetMapping
    public List<Student> getStudents() {
        System.out.println("Test .all...Database." );
              return studentService.displayStudents();

    }

    @PostMapping
    public Student createStudent(@RequestBody StudentEntity studentEntity) {
        System.out.println("Test .save...Database.");
        return studentService.createStudent(studentEntity);
    }


}
