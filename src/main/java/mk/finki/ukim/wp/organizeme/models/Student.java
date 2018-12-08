package mk.finki.ukim.wp.organizeme.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Student {
    public static long count=0;

    @Column
    public long id;
    @Id
    @Column
    @JsonProperty
    public String index;
    @Column
    @JsonProperty
    public String name;
    @Column
    @JsonProperty
    public String lastName;
    @ManyToOne
    @JsonProperty
    public StudyProgram studyProgram;

    @JsonCreator
    public Student(String index, String name, String lastName, StudyProgram studyProgram){
        id=count++;
        this.index=index;
        this.name=name;
        this.lastName=lastName;
        this.studyProgram=studyProgram;
    }
}
