package kr.co.hs.domain.sample.service;

import kr.co.hs.domain.sample.entity.Sample;
import kr.co.hs.domain.sample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleDomainService {

    private final SampleRepository sampleRepository;

    public void save(Sample sample){
        sampleRepository.save(sample);
    }

}
