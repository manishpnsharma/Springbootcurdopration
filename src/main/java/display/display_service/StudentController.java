package display.display_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/ui/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public List<Student> getStudentById(@PathVariable Integer id) {
        System.out.println("Test ....." + id);
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getStudents() {
        System.out.println("Test .....");
        return studentService.getStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentEntity studentEntity) {
        System.out.println("Test .save...Database.");
        return studentService.createStudent(studentEntity);
    }
}
