package kr.co.han.api.domain.repository;

import kr.co.han.api.domain.entity.Sample;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleRepositoryTest {

    @Autowired SampleRepository sampleRepository;

    @Test
    void Repository_테스트(){



        Sample sample = new Sample("홍길동");
        Sample saveSample = sampleRepository.save(sample);

        Assertions.assertThat(saveSample).isSameAs(sample);
    }

}