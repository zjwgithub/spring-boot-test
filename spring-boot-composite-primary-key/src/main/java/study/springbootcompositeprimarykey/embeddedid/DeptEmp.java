package study.springbootcompositeprimarykey.embeddedid;

import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class DeptEmp {

    @EmbeddedId
    private DeptEmpId deptEmpId;

    public DeptEmp(DeptEmpId deptEmpId) {
        this.deptEmpId = deptEmpId;
    }
}
