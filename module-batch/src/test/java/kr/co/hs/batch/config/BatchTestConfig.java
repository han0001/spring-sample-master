package kr.co.hs.batch.config;


import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@SpringBatchTest
@TestPropertySource(properties = "spring.batch.job.enabled=false")
public class BatchTestConfig {
}
