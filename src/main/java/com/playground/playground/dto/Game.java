package com.playground.playground.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Game {
    @NotEmpty
    String name;

    @NotEmpty
    GameType type;

    @NotEmpty
    String creator;

    @NotEmpty
    Platform platform;

    @NotEmpty
    int rating;
}
