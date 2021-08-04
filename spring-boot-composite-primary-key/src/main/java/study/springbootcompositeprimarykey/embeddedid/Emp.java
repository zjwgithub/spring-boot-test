package study.springbootcompositeprimarykey.embeddedid;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Emp {

    @Id @GeneratedValue
    @Column(name = "emp_id")
    private Long id;

    private String name;

    public Emp(String name) {
        this.name = name;
    }
}
