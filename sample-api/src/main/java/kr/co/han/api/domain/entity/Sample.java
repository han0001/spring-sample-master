package kr.co.han.api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_sample")
public class Sample {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
    public Long id;

    @Column
    private String name;

    public Sample(String name){
        this.name = name;
    }
}
