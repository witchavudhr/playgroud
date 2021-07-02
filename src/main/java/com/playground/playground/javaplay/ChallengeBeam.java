package com.playground.playground.javaplay;

import com.playground.playground.dto.Game;
import com.playground.playground.dto.GameType;
import com.playground.playground.dto.Platform;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Setter(onMethod_ = @Autowired)
public class ChallengeBeam {

    public final String BEAM = "BEAM";

    public List<Game> games = new ArrayList<>();

    public ChallengeBeam() {
        initGames();
    }

    public HashSet<Integer> uniqNumber() {
        List<Integer> initialData = Arrays.asList(1,1,1,1,1,1,2,2,2,2,2);

        return new HashSet<>(initialData);
    }

    public List<Integer> streamPlay() {

        Set<Integer> test = new HashSet<>(Arrays.asList(1, 10, 5 , 8, 2));

        Integer max = test.stream().max(Integer::compareTo).get();
        Integer min = test.stream().min(Integer::compareTo).get();

        List<Integer> result = test.stream().sorted().collect(Collectors.toList());

        return result;
    }

    private void initGames() {
        games.add(Game.builder().name("max payne").type(GameType.FPS).creator("Activision").platform(Platform.PC).rating(8).build());
        games.add(Game.builder().name("Final Fantasy").type(GameType.MMORPG).creator("Square Enix").platform(Platform.CONSOLE).rating(9).build());
        games.add(Game.builder().name("Zelda").type(GameType.MMORPG).creator("Nintendo").platform(Platform.CONSOLE).rating(10).build());
        games.add(Game.builder().name("DOTA").type(GameType.MOBA).creator("Blizzard").platform(Platform.PC).rating(9).build());
        games.add(Game.builder().name("ROV").type(GameType.MOBA).creator("Tencent").platform(Platform.MOBILE).rating(8).build());
        games.add(Game.builder().name("PUBG").type(GameType.FPS).creator("Tencent").platform(Platform.MOBILE).rating(9).build());
        games.add(Game.builder().name("Mario").type(GameType.ADVENTURE).creator("Nintendo").platform(Platform.CONSOLE).rating(6).build());
        games.add(Game.builder().name("Diablo").type(GameType.MMORPG).creator("Blizzard").platform(Platform.PC).rating(10).build());
    }

    public Map<GameType, List<Game>> groupGame() {
        Map<GameType, List<Game>> result = games.stream().collect(Collectors.groupingBy(Game::getType));


        return result;
    }

    public GameType filterGame(String game) {

        GameType result = games.stream()
                .filter(a -> a.getName().toLowerCase().equals(game))
                .findFirst()
                .map(Game::getType)
                .orElseThrow(() -> new IllegalArgumentException());

        return result;
    }

    public Map<GameType, List<Game>> filterByGameType(GameType gameType) {
        //return Map group of game
        Map<GameType, List<Game>> resultGroup = games.stream()
                .filter(game -> game.getType().equals(gameType))
                .collect(Collectors.groupingBy(Game::getType));

        //return list of game String
        List<String> resultGroup2 = games.stream()
                .filter(game -> game.getType().equals(gameType))
                .map(a -> a.getName())
                .collect(Collectors.toList());

        //Return Game object not group
        List<Game> result = games.stream()
                .filter(game -> game.getType().equals(gameType))
                .collect(Collectors.toList());

        return resultGroup;
    }


    public synchronized  ConcurrentMap<GameType, List<Game>> searchGame(String input) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.get();

        ConcurrentMap<GameType, List<Game>> result = games.stream()
                .filter(game -> game.getName().toLowerCase().contains(nonNull(input)))
                .sorted(Comparator.comparing(Game::getRating))
                .collect(Collectors.groupingByConcurrent(Game::getType));

        Optional<String> opt = Optional.of("baeldung");
        opt.isPresent();

        return result;
    }

    private <T> T nonNull(T input) {
        return Optional.ofNullable(input).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Game> deleteGames(String gameName) {
        List<Game> deleteGame = games.stream().
                filter(game -> game.getName().toLowerCase().contains(gameName)).
                collect(Collectors.toList());

        if(deleteGame.size() == 0) {
            throw new IllegalArgumentException();
        }

        games.removeAll(deleteGame);

        return games;
    }
}
