package com.playground.playground.controller;

import com.playground.playground.dto.Game;
import com.playground.playground.dto.GameType;
import com.playground.playground.javaplay.ChallengeBeam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
@Setter(onMethod_ = @Autowired)
@Validated
@Slf4j
public class PlaygroundController {

    private ChallengeBeam challengeBeam;

    @Operation
    @GetMapping("test")
    public String getResult(@RequestParam("playground") @NotEmpty String playground){
        log.info("controller test");
        return playground;
    }

    @GetMapping("games/{gameType}")
    public synchronized ConcurrentMap<GameType, List<Game>> searchGame(@PathVariable("gameType") String gameType,
                                                          @RequestParam("input") @NotNull @NotEmpty String input) {

        return challengeBeam.searchGame(input);
    }

    @PostMapping("games")
    public List<Game> addGame(@RequestBody Game game) {

        return null;
    }

    @PutMapping("games")
    public Game updateGame(@RequestParam("name") String name, @RequestBody Game game) {

        return null;
    }

    @DeleteMapping("games")
    public Game deleteGame(@RequestParam Game game) {

        return null;
    }
}
