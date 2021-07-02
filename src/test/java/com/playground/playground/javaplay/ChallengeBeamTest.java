package com.playground.playground.javaplay;

import com.playground.playground.dto.Game;
import com.playground.playground.dto.GameType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeBeamTest {
    private ChallengeBeam challengeBeam;

    @BeforeEach
    void setup() {
        challengeBeam = new ChallengeBeam();
    }


    @Test
    public void gameGroupingTest() {
        List<Game> gameList = new ArrayList<>();
        Map<GameType, List<Game>> expectResult = new HashMap<>();

        assertEquals(null, challengeBeam.groupGame());
    }

    @Test
    public void test4() {
        assertEquals(new HashSet<>(Arrays.asList(1, 2)), challengeBeam.uniqNumber());
    }

    @Test
    public void test5() {
        assertEquals(Arrays.asList(1, 2, 5, 8, 10), challengeBeam.streamPlay());
    }

    @Test
    public void test6() {
        assertEquals(GameType.MMORPG, challengeBeam.filterGame("zelda"));
        assertThrows(IllegalArgumentException.class, () -> challengeBeam.filterGame("rrrr"));
    }

    @Test
    public void test7() {
        Optional<String> opt = null;
        Optional<String> a = Optional.ofNullable(opt).orElse(Optional.of("test"));

        assertEquals("test", a.get());

//        assertEquals(null, challengeBeam.filterByGameType(GameType.MMORPG));

    }

    @Test
    public void test8() {
        ConcurrentMap<GameType, List<Game>> result = challengeBeam.searchGame("o");

        assertEquals("Diablo", result.get(GameType.MMORPG).get(0).getName());
        assertEquals("Mario", result.get(GameType.ADVENTURE).get(0).getName());
        
        assertEquals(new ConcurrentHashMap<>(), challengeBeam.searchGame("223445"));

        assertThrows(new IllegalArgumentException().getClass(), () -> challengeBeam.searchGame(null));
    }

    @Test
    public void test9() {
        challengeBeam.deleteGames("blo");
        assertEquals( 0, challengeBeam.searchGame("blo").size());
        assertThrows(IllegalArgumentException.class, () -> challengeBeam.deleteGames("b2346lo"));
    }
}