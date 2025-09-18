package display.display_service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ExternalServiceCaller {
    private final WebClient webClient;

    public ExternalServiceCaller(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Student> fetchStudentById(Integer id) {
        String url = "http://localhost:8081/v1/api/ui/student/" + id;
        return webClient.get()
                .uri(url) // Endpoint to fetch the list
                .retrieve()
                .bodyToFlux(Student.class) // Convert JSON array to Flux<Employee>
                .collectList() // Collect Flux into a List
                .block(); // Block to get the result synchronously
    }

    public List<Student> fetchStudents() {
        String url = "http://localhost:8081/v1/api/ui/student";
        return webClient.get()
                .uri(url) // Endpoint to fetch the list
                .retrieve()
                .bodyToFlux(Student.class) // Convert JSON array to Flux<Employee>
                .collectList() // Collect Flux into a List
                .block(); // Block to get the result synchronously
    }
    public Student saveStudent(StudentEntity studentEntity) {
        String url = "http://localhost:8081/v1/api/ui/student";
        return webClient.post()
                .uri(url) // Endpoint for creating products
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(studentEntity))
                .retrieve()
                .bodyToMono(Student.class).block(); // Expecting a Product object in response

    }


}