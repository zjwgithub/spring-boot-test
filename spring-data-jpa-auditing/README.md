- ## AuditingConfig
    ```java
    @EnableJpaAuditing
    @Configuration
    public class AuditingConfig {
    
        @Bean
        public AuditorAware<String> auditorAware() {
            return () -> Optional.of("처리자");
        }
    
    }
    ```
- ## Base Entity
  - ### BaseTimeEntity
    ```java
    @EntityListeners(AuditingEntityListener.class)
    @MappedSuperclass
    @Getter
    @ToString
    public class BaseTimeEntity {
    
        @CreatedDate
        @Column(updatable = false)
        private LocalDateTime createdDate;
        
        @LastModifiedDate
        private LocalDateTime lastModifiedDate;
    
    }
    ```
  - ### BaseEntity
    ```java
    @EntityListeners(AuditingEntityListener.class)
    @MappedSuperclass
    @Getter
    @ToString(callSuper = true)
    public class BaseEntity extends BaseTimeEntity {
    
        @CreatedBy
        @Column(updatable = false)
        private String createdBy;
        
        @LastModifiedBy
        private String lastModifiedBy;
    
    }
    ```

- ## Entity
  - ### Member
    ```java
    @Entity
    @Getter @Setter
    @ToString(callSuper = true)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Member extends BaseEntity {
        
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
  
  - ### Team
    ```java
    @Entity
    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Team extends BaseTimeEntity {
        
        @Id @GeneratedValue
        @Column(name = "team_id")
        private Long id;
        
        private String name;
    
        public Team(String name) {
            this.name = name;
        }
    }
    ```
