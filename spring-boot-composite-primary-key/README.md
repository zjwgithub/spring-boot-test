### IdClass
    @Entity
    @IdClass(TeamMemberId.class)
    public class TeamMember {
    
        @Id
        private Long teamId;
    
        @Id
        private Long memberId;
    }

### EmbeddedId
    @Entity
    public class DeptEmp {
    
        @EmbeddedId
        private DeptEmpId deptEmpId;
    }