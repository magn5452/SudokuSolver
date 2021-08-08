package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import standard.Position;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position position12;
    private Position position84;

    @BeforeEach
    void setUp() {
        position12 = new Position(1,2);
        position84 = new Position(8,4);
    }

    @Test
    void correctRowAndColumnFromPosition12() {
        assertEquals(position12.getRow(),1);
        assertEquals(position12.getColumn(),2);
    }

    @Test
    void position12AndPosition84AreNotEqual(){
        assertFalse(position12.equals(position84));
    }

    @Test
    void position84AndPosition84AreEqual(){
        assertTrue(position84.equals(position84));
    }


}