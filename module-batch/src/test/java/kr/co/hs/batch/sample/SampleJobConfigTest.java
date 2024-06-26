package kr.co.hs.batch.sample;

import kr.co.hs.BatchApplication;
import kr.co.hs.batch.config.BatchTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringBatchTest
@SpringJUnitConfig({BatchApplication.class, BatchTestConfig.class, SampleJobConfig.class})
class SampleJobConfigTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    void 그냥_테스트(){
        int a=0;
    }

    @Test
    void JobBean_로드_테스트(@Qualifier("sampleJob") Job job) throws Exception {
        this.jobLauncherTestUtils.setJob(job);

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("baseDt", "2022-01-01")
                .addString("chunkSize", "590")
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
//        assert jobExecution.getExitStatus() == ExitStatus.COMPLETED;
    }
}