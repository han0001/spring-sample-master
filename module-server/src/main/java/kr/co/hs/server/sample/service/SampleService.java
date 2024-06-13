package kr.co.hs.server.sample.service;

import kr.co.hs.domain.modules.sample.domain.model.Sample;
import kr.co.hs.domain.modules.sample.domain.model.SampleRepository;
import kr.co.hs.domain.modules.sample.infrastructure.platform.SampleJpaRepository;
import kr.co.hs.server.sample.controller.model.form.SampleForm;
import kr.co.hs.server.sample.controller.model.view.SampleView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;
    private final SampleJpaRepository sampleJpaRepository;

    public SampleView getSampleOne(Long id){
        Sample sample = sampleRepository.findById(20L);
        return SampleView.fromEntity(sample) ;
    }

    public SampleView saveSampleOne(SampleForm sampleForm){
        Sample sample = sampleJpaRepository.save(sampleForm.toEntityForInsert());
        return SampleView.fromEntity(sample);
    }
}
