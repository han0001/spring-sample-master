package kr.co.hs.batch.sample;

import lombok.Getter;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@JobScope
@Component
public class SampleJobParameter {

    private LocalDate baseDt;
    private int chunkSize;

    public SampleJobParameter(
            @Value("#{jobParameters[baseDt]}") LocalDate baseDt,
            @Value("#{jobParameters[chunkSize]}") int chunkSize
    ){
        this.baseDt = baseDt;
        this.chunkSize = chunkSize;
    }
}
