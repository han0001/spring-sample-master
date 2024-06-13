package kr.co.hs.server.sample.controller;

import kr.co.hs.server.sample.controller.model.form.SampleForm;
import kr.co.hs.server.sample.controller.model.view.SampleView;
import kr.co.hs.server.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sample")
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/one")
    public SampleView getSampleOne(@RequestParam Long id){
        return sampleService.getSampleOne(id);
    }

    @PostMapping("/one")
    public String saveSampleOne(@RequestBody SampleForm sampleForm){
        sampleService.saveSampleOne(sampleForm);
        return "ok";
    }
}
