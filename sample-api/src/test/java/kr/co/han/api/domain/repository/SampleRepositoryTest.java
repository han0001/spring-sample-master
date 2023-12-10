package kr.co.han.api.domain.repository;

import kr.co.han.api.domain.entity.Sample;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;


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