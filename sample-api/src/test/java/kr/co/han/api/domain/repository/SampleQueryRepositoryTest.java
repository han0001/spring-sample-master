package kr.co.han.api.domain.repository;

import kr.co.han.api.domain.entity.Sample;
import kr.co.han.api.domain.record.SampleRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleQueryRepositoryTest {

    @Autowired
    private SampleQueryRepository sampleQueryRepository;

    @Autowired
    private SampleRepository sampleRepository;

    @Test
    void SAMPLE_DB_TEST(){
        Sample sample = new Sample("홍길동");
        Sample saveSample = sampleRepository.save(sample);

        List<SampleRecord> sampleList = sampleQueryRepository.findById(saveSample.id);
    }
}