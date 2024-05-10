//package kr.co.han.batch.configuration;
//
//import lombok.val;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchTestConfig {
//
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("/org/springframework/batch/core/schema-h2.sql")
//                .build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean
//    public JobRepository jobRepository() throws Exception {
//        val jobrepositoryFactoryBean = new JobRepositoryFactoryBean();
//        jobrepositoryFactoryBean.setDataSource(dataSource());
//        jobrepositoryFactoryBean.setTransactionManager(transactionManager());
//        jobrepositoryFactoryBean.afterPropertiesSet();
//        return jobrepositoryFactoryBean.getObject();
//    }
//}
