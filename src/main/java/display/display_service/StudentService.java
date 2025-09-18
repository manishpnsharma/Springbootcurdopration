package display.display_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    ExternalServiceCaller externalServiceCaller;

    List<Student> getStudentById(Integer id){
        return externalServiceCaller.fetchStudentById(id);
    }

    List<Student> getStudents(){
        return externalServiceCaller.fetchStudents();
    }

    Student createStudent(StudentEntity studentEntity){
        return externalServiceCaller.saveStudent(studentEntity);
    }
}