package com.playground.playground.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.logging.Logger;

@RestController
@RequestMapping("/playground")
@Setter(onMethod_ = @Autowired)
@Validated
@Slf4j
public class PlaygroundController {

    @Operation
    @GetMapping("test")
    public String gerResult(@RequestParam("playground") @NotEmpty String playground){
        log.info("controller test");
        return playground;
    }
}
