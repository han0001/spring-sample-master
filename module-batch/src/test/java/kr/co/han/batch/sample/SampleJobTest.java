package kr.co.han.batch.sample;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringBatchTest
@SpringJUnitConfig(classes = {SampleJob.class})
public class SampleJobTest {

//    @Autowired
//    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void 그냥_테스트(){
        int a=0;
    }

    @Test
    public void givenVisitorsFlatFile_whenJobExecuted_thenSuccess(@Autowired Job job) throws Exception {
        // given
//        this.jobLauncherTestUtils.setJob(job);
//
//        // when
//        val jobExecution = jobLauncherTestUtils.launchJob();
//        val actualJobInstance = jobExecution.getJobInstance();
//        val actualJobExitStatus = jobExecution.getExitStatus();

        int a = 0;
    }
}