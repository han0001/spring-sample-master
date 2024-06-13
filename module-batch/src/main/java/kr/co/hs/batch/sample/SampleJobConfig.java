package kr.co.hs.batch.sample;

import kr.co.hs.batch.sample.step.SampleTaskStepConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SampleJobConfig {
    public static final String JOB_NAME = "sampleJob";

    private final JobRepository jobRepository;
    private final SampleTaskStepConfig sampleTaskStepConfig;

    @Bean
    public Job sampleJob() throws Exception {
        return new JobBuilder(JOB_NAME, jobRepository)
                .start(sampleTaskStepConfig.sampleTaskStep())
                .build();
    }
}
