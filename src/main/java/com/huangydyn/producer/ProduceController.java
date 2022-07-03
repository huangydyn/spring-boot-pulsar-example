package com.huangydyn.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProduceController {

    private final ProducerService service;

    public ProduceController(ProducerService service) {
        this.service = service;
    }

    @GetMapping("/string")
    public void produceString(@RequestParam String value) throws Exception {
        service.sendStringMsg(value);
    }

    @GetMapping("/class")
    public void produceClassMsg(@RequestParam String value) throws Exception {
        service.sendClassMsg(value);
    }
}
