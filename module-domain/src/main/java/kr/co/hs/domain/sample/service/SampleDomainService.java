package kr.co.hs.domain.sample.service;

import kr.co.hs.domain.sample.entity.Sample;
import kr.co.hs.domain.sample.repository.SampleCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleDomainService {

    private final SampleCommandRepository sampleCommandRepository;

    public void save(Sample sample){
        sampleCommandRepository.save(sample);
    }

}
