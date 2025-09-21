package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Игрок1", 89);
    Player player2 = new Player(2, "Игрок2", 41);
    Player player3 = new Player(3, "Игрок3", 20);
    Player player4 = new Player(4, "Игрок4", 89);
    Player player5 = new Player(5, "Игрок5", 98);

    @Test
    public void shouldRoundWhenFirstStrongerThanSecond() {
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round(player5.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenSecondStrongerThanFirst() {
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round(player4.getName(), player5.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenStrengthTheSame() {
        game.register(player1);
        game.register(player4);

        int expected = 0;
        int actual = game.round(player1.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRoundWhenOnePlayerIsNotRegistered() {
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void shouldNotRoundWhenBothPlayersIsNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }
}
