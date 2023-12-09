package kr.co.han.api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_sample_member")
public class SampleMember {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public Long id;

    @Column
    private String memberName;

    public SampleMember(String memberName){
        this.memberName = memberName;
    }
}
