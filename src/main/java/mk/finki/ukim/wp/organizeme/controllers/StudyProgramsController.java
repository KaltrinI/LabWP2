package mk.finki.ukim.wp.organizeme.controllers;

import com.google.gson.Gson;
import mk.finki.ukim.wp.organizeme.models.StudyProgram;
import mk.finki.ukim.wp.organizeme.persistance.StudyProgramRepository;
import mk.finki.ukim.wp.organizeme.persistance.implementations.StudentRepositoryImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/study_programs", produces = MediaType.APPLICATION_JSON_VALUE)

public class StudyProgramsController {

    private StudyProgramRepository repository;

    public StudyProgramsController(StudentRepositoryImpl repo){
        repository=repo;
    }

    @GetMapping
    public List<StudyProgram> listAllStudyPrograms(){
        return repository.listAllStudyPrograms();
    }

    @PostMapping
    public void addStudyProgram(@RequestBody String progName){
        Gson g=new Gson();
        String name=g.fromJson(progName,String.class);
        repository.addNewStudyProgram(name);
    }

    @DeleteMapping("/{progName}")
    public void removeStudyProgram(@PathVariable String progName){
        Gson g=new Gson();
        String name=g.fromJson(progName,String.class);
        repository.deleteStudyProgram(name);
    }

}
