package kr.co.hs.domain.modules.sample.service;

import kr.co.hs.domain.modules.sample.domain.model.Sample;
import kr.co.hs.domain.modules.sample.infrastructure.SampleCommandRepository;
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
