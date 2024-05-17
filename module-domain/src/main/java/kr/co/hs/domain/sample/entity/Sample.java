package kr.co.hs.domain.sample.entity;

import jakarta.persistence.*;
import kr.co.hs.domain.constant.legacy.LegacyPayType;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tb_sample")
@ToString
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
    public Long id;

    @Column
    private String name;

    @Column
    private LegacyPayType legacyPayType;

    @Builder
    public Sample(String name, LegacyPayType legacyPayType){
        this.name = name;
        this.legacyPayType = legacyPayType;
    }
}
