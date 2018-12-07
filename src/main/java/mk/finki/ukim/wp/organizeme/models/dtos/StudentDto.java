package mk.finki.ukim.wp.organizeme.models.dtos;

public class StudentDto {
    public String index;
    public String name;
    public String lastName;

    public StudentDto(String i, String n, String l){
        index=i;
        name=n;
        lastName=l;
    }
}
