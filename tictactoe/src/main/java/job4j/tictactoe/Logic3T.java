package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWin(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0) ||
                this.fillBy(predicate, 0, 1, 1, 0) ||
                this.fillBy(predicate, 0, 2, 1, 0) ||
                this.fillBy(predicate, 0, 0, 0, 1) ||
                this.fillBy(predicate, 1,0, 0, 1) ||
                this.fillBy(predicate, 2,0, 0, 1) ||
                this.fillBy(predicate, 0,0, 1, 1) ||
                this.fillBy(predicate, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        return Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .dropWhile(x -> x.hasMarkX() || x.hasMarkO())
                .count() != 0;
    }
}
