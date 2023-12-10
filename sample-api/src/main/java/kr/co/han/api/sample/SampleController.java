package kr.co.han.api.sample;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("example1")
    public String example1(@RequestParam String param1) {
        return param1 + "";

    }

}
