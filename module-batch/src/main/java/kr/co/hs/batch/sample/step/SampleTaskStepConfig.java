package kr.co.hs.batch.sample.step;

import kr.co.hs.batch.sample.SampleJobParameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
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
public class SampleTaskStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final SampleJobParameter sampleJobParameter;

    @Bean
    @JobScope
    public Step sampleTaskStep(){
        return new StepBuilder("sampleTaskStep", jobRepository)
                .tasklet(sampleTasklet(), transactionManager)
                .build();
    }

    @Bean
    @StepScope
    protected Tasklet sampleTasklet(){
        return ((contribution, chunkContext) -> {
            log.info(">>>>> This is Step1");
            log.info(String.format("baseDt : %s", sampleJobParameter.getBaseDt()));
            log.info(String.format("chunkSize : %s", sampleJobParameter.getChunkSize()));
            return RepeatStatus.FINISHED;
        });
    }
}
