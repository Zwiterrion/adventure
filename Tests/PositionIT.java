import Adventure.Position;

import org.junit.*;
import static org.junit.Assert.*;

public class PositionIT {

    @Test
    public void testPositionIsEquals() {
        Position a = new Position(1,1);
        Position b = new Position(1,1);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }

    @Test
    public void testisNotNull() {
        Position p = new Position(5,5);
        assertNotNull(p);
    }

    @Test
    public void testAdditionPosition() {
        Position a = new Position(2,5);
        Position b = new Position(4,8);
        Position resultat = new Position(6,13);
        assertTrue(Position.add(a,b).equals(resultat));
    }

    @Test
    public void testMultiplicationPosition() {
        Position a = new Position(2,5);
        Position b = new Position(4,8);
        Position resultat = new Position(8,40);
        assertTrue(Position.mul(a, b).equals(resultat));
    }

    @Test
    public void testDifferencePosition() {
        Position a = new Position(2,5);
        Position b = new Position(4,8);
        Position resultat = new Position(-2,-3);
        assertTrue(Position.diff(a,b).equals(resultat));
    }

}
