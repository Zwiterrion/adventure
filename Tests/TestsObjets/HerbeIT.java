package TestsObjets;

import Adventure.Direction;
import Adventure.Images;
import Adventure.ObjetsCarte.Herbe;
import org.junit.Test;
import static org.junit.Assert.*;

public class HerbeIT {

    @Test
    public void testCreationHerbe() {
        Herbe herbe = new Herbe(Direction.AUCUNE);
        assertEquals(herbe.toString(), "Herbe");
    }

    @Test
    public void testImage() {
        Herbe herbe = new Herbe(Direction.AUCUNE);
        assertEquals(herbe.getImage(), Images.HERBE);
        herbe.setDir(Direction.SUD);
        assertEquals(herbe.getImage(), Images.HERBE_SUD_NORD);
    }
}
