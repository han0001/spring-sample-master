package kr.co.han.server.sample.service;

import kr.co.han.domain.sample.service.SampleDomainService;
import kr.co.han.server.sample.model.form.SampleForm;
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
