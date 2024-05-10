package kr.co.han.domain.sample.repository;

import kr.co.han.domain.constant.legacy.LegacyPayType;
import kr.co.han.domain.sample.entity.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleRepositoryTest {

    @Autowired
    SampleRepository sampleRepository;

    @Test
    void 저장테스트(){
        Sample sample = new Sample("홍길동", LegacyPayType.BANK);
        Sample saveSample = sampleRepository.save(sample);

        assertThat(saveSample).isSameAs(sample);
    }

    @Test
    void 조회테스트(){
        Optional<Sample> sample = sampleRepository.findById(20L);
        assertThat(sample.isPresent());
    }
}