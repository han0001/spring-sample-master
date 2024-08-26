package kr.co.hs.domain.sample;

import kr.co.hs.domain.sample.record.SampleRecord;
import kr.co.hs.domain.sample.repository.SampleQueryRepository;
import kr.co.hs.support.RepositoryTestSupport;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleQueryRepositoryTest extends RepositoryTestSupport {

    @Autowired
    private SampleQueryRepository sampleQueryRepository;

    @DisplayName("ID로 SAMPLE을 조회한다.")
    @Test
    void findById(){
        List<SampleRecord> samples = sampleQueryRepository.findById(20L);
        assertThat(samples).hasSize(1);
    }


}