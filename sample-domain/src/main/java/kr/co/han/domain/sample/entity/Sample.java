package kr.co.han.domain.sample.entity;

import jakarta.persistence.*;
import kr.co.han.domain.constant.legacy.LegacyPayType;
import lombok.Getter;
import lombok.NoArgsConstructor;


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

    @Column
    private LegacyPayType legacyPayType;

    public Sample(String name, LegacyPayType legacyPayType){
        this.name = name;
        this.legacyPayType = legacyPayType;
    }
}
