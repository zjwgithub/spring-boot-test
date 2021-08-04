package study.springbootcompositeprimarykey.embeddedid;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class DeptEmpId implements Serializable {

    private Long deptId;
    private Long empId;

    public DeptEmpId(Long deptId, Long empId) {
        this.deptId = deptId;
        this.empId = empId;
    }
}
