package TestsObjets;

import Adventure.ObjetsCarte.PiegeSol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrapIT {

    @Test
    public void testCreationHerbe() {
        PiegeSol piege = new PiegeSol();
        assertEquals(piege.toString(), "PiegeSol");
    }

    @Test
    public void testDegats() {
        PiegeSol piege = new PiegeSol();
        assertEquals(piege.degat(), 10);
    }
}
