package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        try {
            if (!isDiagonal(source, dest)) {
                throw new IllegalStateException(
                        String.format("Could not move by diagonal from %s to %s", source, dest)
                );
            }
        } catch (IllegalStateException nme) {}

        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = (source.x - dest.x) < 0 ? 1 : -1;
        int deltaY = (source.y - dest.y) < 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            int x = source.x + (index + 1) * deltaX;
            int y = source.y + (index + 1) * deltaY;
            steps[index] = Cell.findBy(x,y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean res = false;
        if(Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            res = true;
        }
        return res;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
