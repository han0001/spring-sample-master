package kr.co.hs.server.sample.service;

import kr.co.hs.domain.modules.sample.service.SampleDomainService;
import kr.co.hs.server.sample.controller.model.form.SampleForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleDomainService sampleDomainService;

    public void saveSample(SampleForm sampleForm){
        sampleDomainService.save(sampleForm.toEntityForInsert());
    }
}
