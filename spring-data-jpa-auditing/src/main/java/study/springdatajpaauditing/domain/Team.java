package study.springdatajpaauditing.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.springdatajpaauditing.domain.base.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
