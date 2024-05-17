package kr.co.hs.batch.sample.step;

import kr.co.hs.batch.comm.BatchServicePagingItemReader;
import kr.co.hs.batch.comm.BatchServicePagingItemReaderBuilder;
import kr.co.hs.batch.sample.SampleJobParameter;
import kr.co.hs.domain.sample.record.SampleRecord;
import kr.co.hs.domain.sample.repository.SampleQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SampleStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final SampleJobParameter sampleJobParameter;
    private final SampleQueryRepository sampleQueryRepository;


    @Bean
    @JobScope
    public Step sampleStep() throws Exception {
        return new StepBuilder("sampleStep", jobRepository)
                .<SampleRecord, SampleRecord>chunk(sampleJobParameter.getChunkSize(), transactionManager)
                .reader(sampleReader())
                .writer(sampleWriter())
                .build();
    }


    @Bean
    @StepScope
    protected BatchServicePagingItemReader<SampleRecord> sampleReader() {
        return new BatchServicePagingItemReaderBuilder<SampleRecord>()
                .name("sampleReader")
                .batchService(sampleQueryRepository)
                .methodName("findById")
                .pageSize(10)
                .build();
    }

    @Bean
    @StepScope
    protected ItemWriter<SampleRecord> sampleWriter() {
        return list -> {
            for (SampleRecord sample : list) {
                log.info(String.format("sample : %s", sample));
            }
        };
    }

}
