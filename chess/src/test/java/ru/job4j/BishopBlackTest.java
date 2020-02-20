package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void checkPosition() {
        BishopBlack bb = new BishopBlack(Cell.A2);
        Cell temp = bb.position();
        assertThat(temp, is(Cell.A2));
    }

    @Test
    public void checkCopy() {
        BishopBlack bb = new BishopBlack(Cell.A2);
        Cell temp = bb.copy(Cell.A2).position();
        assertThat(temp, is(Cell.A2));
    }

    @Test
    public void checkWayDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] steps = bb.way(Cell.C1 , Cell.G5);
        assertThat(steps, is(new Cell[] { Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void checkWayNotDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.A2);
        Cell[] steps = bb.way(Cell.A2, Cell.A7);
        assertThat(steps, is(new Cell[] {}));
    }
}
