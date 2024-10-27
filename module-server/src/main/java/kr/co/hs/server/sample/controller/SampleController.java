package kr.co.hs.server.sample.controller;

import kr.co.hs.server.sample.controller.model.form.SampleForm;
import kr.co.hs.server.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sample")
public class SampleController {

    private final SampleService sampleService;

    @PostMapping("/one")
    public String saveSampleOne(@RequestBody SampleForm sampleForm){
        sampleService.saveSample(sampleForm);
        return "ok";
    }
}
