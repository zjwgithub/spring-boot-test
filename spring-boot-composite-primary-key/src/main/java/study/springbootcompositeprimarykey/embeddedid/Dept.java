package study.springbootcompositeprimarykey.embeddedid;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Dept {

    @Id @GeneratedValue
    @Column(name = "dept_id")
    private Long id;

    private String name;

    public Dept(String name) {
        this.name = name;
    }
}
