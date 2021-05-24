package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.Assert.assertEquals;

public class LogicTest {

    @Test
    public void move() throws FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        logic.add(bishopBlack);
        logic.move(bishopBlack.position(), Cell.H7);
        //для теста открыл геттером поле figure к классе Logic
        assertEquals(logic.getFigures()[0].position(), Cell.H7);
    }

    @Test
    public void freeOccupiedCellExceptionTest() throws FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new BishopBlack(Cell.D3));
        try {
            logic.move(Cell.B1, Cell.H7);
        } catch (OccupiedCellException e) {
            final String expected = "OccupiedCellException";
            assertEquals(e.getMessage(), expected);
        }
    }

    @Test(expected = FigureNotFoundException.class)
    public void freeFigureNotFoundExceptionTest() throws FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.B1, Cell.H7);

    }
}
