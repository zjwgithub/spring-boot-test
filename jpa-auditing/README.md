- ### JpaBaseEntity
  - @MappedSuperclass
  - @PrePersist
  - @PreUpdate

  ```java
  @MappedSuperclass
  @ToString
  public class JpaBaseEntity {
    
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
        
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }
        
    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
  }
  ```

- ### Member
  - extends JpaBaseEntity

  ```java
  @Getter @Setter
  @ToString(callSuper = true)
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public class Member extends JpaBaseEntity {
    
      @Id @GeneratedValue
      @Column(name = "member_id")
      private Long id;
        
      private String name;
      private Integer age;
    
      public Member(String name) {
          this.name = name;
      }
  }
  ```

- ### MemberJpaRepositoryTest
    ```java
    @SpringBootTest
    @Transactional
    @Commit
    class MemberJpaRepositoryTest {
    
        @Autowired
        MemberJpaRepository memberJpaRepository;
        
        @Autowired
        EntityManager em;
    
        @Test
        void auditingTest() throws InterruptedException {
            Member member = memberJpaRepository.save(new Member("member1"));
            System.out.println("member Created = " + member);
            
            Thread.sleep(100);
            
            member.setName("MEMBER 1 updated");
            
            em.flush();
            em.clear();
    
            member = memberJpaRepository.findById(member.getId()).get();
            System.out.println("member Updated = " + member);
        }
    }
    ```