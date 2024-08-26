package kr.co.hs.batch.sample;

import kr.co.hs.BatchApplication;
import kr.co.hs.batch.config.BatchTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.*;

@SpringJUnitConfig({
        BatchApplication.class,
        BatchTestConfig.class,
        SampleJobConfig.class})
class SampleJobConfigTest extends BatchTestConfig{

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;


    @Test
    void JobBean_로드_테스트(@Qualifier("sampleJob") Job job) throws Exception {
        this.jobLauncherTestUtils.setJob(job);

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("baseDt", "2022-01-01")
                .addString("chunkSize", "166")
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
        assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
    }
}