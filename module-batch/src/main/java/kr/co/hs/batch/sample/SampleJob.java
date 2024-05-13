package kr.co.hs.batch.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SampleJob {

    public static final String JOB_NAME = "sampleJob";
    public static final String BEAN_PREFIX = JOB_NAME + "_";

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final SampleJobParameter sampleJobParameter;

    @Bean
    public Job job() {
        return new JobBuilder(JOB_NAME, jobRepository)
                .start(sampleStep())
                .build();
    }

    @Bean
    public Step sampleStep(){
        return new StepBuilder(BEAN_PREFIX + "sampleStep", jobRepository)
                .tasklet(sampleTasklet(), transactionManager)
                .build();
    }

    @Bean
    public Tasklet sampleTasklet(){
        return ((contribution, chunkContext) -> {
            log.info(String.format("baseDt  : %s", sampleJobParameter.getBaseDt()));
            log.info(String.format("chunkSize  : %s", sampleJobParameter.getChunkSize()));
            log.info(">>>>> This is Step1");
            return RepeatStatus.FINISHED;
        });
    }
}
