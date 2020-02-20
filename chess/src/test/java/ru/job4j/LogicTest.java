package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void logicDoesNotMove() {
        BishopBlack bb1 = new BishopBlack(Cell.A2);
        BishopBlack bb2 = new BishopBlack(Cell.B3);
        Logic temp = new Logic();
        temp.add(bb1);
        temp.add(bb2);
        assertThat( temp.move(Cell.A2, Cell.C4), is(false));
    }

    @Test
    public void logicMove() {
        BishopBlack bb1 = new BishopBlack(Cell.A2);
        BishopBlack bb2 = new BishopBlack(Cell.A3);
        Logic temp = new Logic();
        temp.add(bb1);
        temp.add(bb2);
        assertThat( temp.move(Cell.A2, Cell.C4), is(true));
    }
}
