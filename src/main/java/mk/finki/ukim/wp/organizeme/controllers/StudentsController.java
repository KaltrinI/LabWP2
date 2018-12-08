package mk.finki.ukim.wp.organizeme.controllers;

import com.google.gson.Gson;
import mk.finki.ukim.wp.organizeme.models.Student;
import mk.finki.ukim.wp.organizeme.models.dtos.StudentDto;
import mk.finki.ukim.wp.organizeme.models.exceptions.IndexFormatException;
import mk.finki.ukim.wp.organizeme.models.exceptions.MissingArgumentException;
import mk.finki.ukim.wp.organizeme.models.exceptions.StudentNotFoundException;
import mk.finki.ukim.wp.organizeme.models.exceptions.StudyProgramNotFoundException;
import mk.finki.ukim.wp.organizeme.persistance.StudentRepository;
import mk.finki.ukim.wp.organizeme.persistance.implementations.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsController {

    private StudentRepository repository;

    @Autowired
    public StudentsController(StudentRepositoryImpl repo){
        repository=repo;
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return repository.listAllStudents();
    }

    @GetMapping("/{index}")
    public Student getStudentByIndex(@PathVariable("index") String index) throws StudentNotFoundException {
        return repository.getStudentByIndex(index);
    }


    @GetMapping("/by_study_program/{id}")
    public List<StudentDto> getStudentByProgram(@PathVariable("id") long studyProgram) {
        return repository.listStudentsByProgram(studyProgram);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody String studentJson, HttpServletResponse response) throws IndexFormatException, MissingArgumentException, StudyProgramNotFoundException {
        Gson g=new Gson();
        Student student=g.fromJson(studentJson,Student.class);
        student.id=Student.count++;
        repository.addNewStudent(student);
        response.setHeader("Location", "/students/" + student.index);
    }

    @PatchMapping("/{index}")
    public void updateStudent(@PathVariable String index,@RequestBody String studentJson) throws StudentNotFoundException {
        Gson g=new Gson();
        Student student=g.fromJson(studentJson,Student.class);
        repository.updateStudent(student);
    }

    @DeleteMapping("/{index}")
    public void deleteStudent(@PathVariable String index) throws StudentNotFoundException {
        repository.deleteStudent(index);
    }



}
