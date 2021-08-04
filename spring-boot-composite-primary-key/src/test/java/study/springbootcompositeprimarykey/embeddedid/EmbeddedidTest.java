package study.springbootcompositeprimarykey.embeddedid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EmbeddedidTest {

    @Autowired
    EntityManager em;

    @Test
    @Commit
    void test1() {
        Dept deptA = new Dept("deptA");
        Dept deptB = new Dept("deptB");
        em.persist(deptA);
        em.persist(deptB);

        Emp emp1 = new Emp("emp1");
        Emp emp2 = new Emp("emp2");
        Emp emp3 = new Emp("emp3");
        Emp emp4 = new Emp("emp4");
        Emp emp5 = new Emp("emp5");
        em.persist(emp1);
        em.persist(emp2);
        em.persist(emp3);
        em.persist(emp4);
        em.persist(emp5);

        em.persist(new DeptEmp(new DeptEmpId(deptA.getId(), emp1.getId())));
        em.persist(new DeptEmp(new DeptEmpId(deptA.getId(), emp2.getId())));
        em.persist(new DeptEmp(new DeptEmpId(deptB.getId(), emp3.getId())));
        em.persist(new DeptEmp(new DeptEmpId(deptB.getId(), emp4.getId())));
        em.persist(new DeptEmp(new DeptEmpId(deptB.getId(), emp5.getId())));
    }
}
