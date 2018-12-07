package mk.finki.ukim.wp.organizeme.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class StudyProgram {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column
    public long id;
    @Column
    public String name;

    public StudyProgram(String name){
        this.name=name;
    }
}
