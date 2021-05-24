package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(bishopBlack.position(), Cell.C1);
    }

    @Test
    public void testWayXY() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(Arrays.toString(bishopBlack.way(Cell.G5)), Arrays.toString(expected));
    }

    @Test
    public void testWayDescXY() {
        Figure bishopBlack = new BishopBlack(Cell.G1);
        Cell[] expected = new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        assertEquals(Arrays.toString(bishopBlack.way(Cell.A7)), Arrays.toString(expected));
    }

    @Test
    public void testWayXDescY() {
        Figure bishopBlack = new BishopBlack(Cell.D4);
        Cell[] expected = new Cell[]{Cell.E3, Cell.F2, Cell.G1};
        assertEquals(Arrays.toString(bishopBlack.way(Cell.G1)), Arrays.toString(expected));
    }

    @Test
    public void testWayDescXDescY() {
        Figure bishopBlack = new BishopBlack(Cell.D4);
        Cell[] expected = new Cell[]{Cell.C3, Cell.B2, Cell.A1};
        assertEquals(Arrays.toString(bishopBlack.way(Cell.A1)), Arrays.toString(expected));
    }

    @Test
    public void testWayException() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        try {
            bishopBlack.way(Cell.G6);
        } catch (Exception e) {
            final String expected = "Could not way by diagonal from C1 to G6";
            assertEquals(e.getMessage(), expected);
        }
    }

    @Test
    public void testIsDiagonal() {
        BishopBlack bishopBlackActual = new BishopBlack(Cell.C1);
        Cell expected = Cell.H6;
        assertTrue(bishopBlackActual.isDiagonal(bishopBlackActual.position(), expected));
    }

    @Test
    public void testCopy() {
        Figure bishopBlackActual = new BishopBlack(Cell.C1);
        Figure bishopBlackExpected = bishopBlackActual.copy(Cell.C1);
        assertEquals(bishopBlackActual.position(), bishopBlackExpected.position());
    }
}