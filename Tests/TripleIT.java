import Adventure.Direction;
import Adventure.Triple;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripleIT {   

    @Test
    public void testX() {
        Triple t = new Triple(10, Direction.TOUTES, "PARKING");
        assertEquals(t.getType(), 10);
    }

    @Test
    public void testDirection() {
        Triple t = new Triple(2, Direction.EST, "FUTUROSCOPE");
        assertEquals(t.getDir(), Direction.EST);
    }

    @Test
    public void testDestination() {
        Triple t = new Triple(4, Direction.SUD, "PARIS");
        assertEquals(t.getDestination(), "PARIS");
    }
}
