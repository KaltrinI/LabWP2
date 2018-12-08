package mk.finki.ukim.wp.organizeme.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class StudyProgram {
    private static long count=0;
    @Column
    public long id;
    @Id
    @Column
    public String name;

    @JsonCreator
    public StudyProgram(String name){
        id=count++;
        this.name=name;
    }
}