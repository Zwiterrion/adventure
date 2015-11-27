import Adventure.Direction;
import Adventure.Heros;

import Adventure.Images;
import Adventure.Monde;
import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;

public class HerosIT {

    private static Heros h;

    @Before
    public void setUp() throws Exception {
        h = new Heros(null);
    }


    @Test
    public void testHerosEtWorld() {
        assertNull(h.getWorld());
        Monde w = new Monde(10,10,1024);
        h = new Heros(w);
        assertNotNull(h.getWorld());
    }

    @Test
    public void testInitialisaitonHeros() {
        assertEquals(h.getVie(), 100);
        assertEquals(h.getMana(), 100);
    }

    @Test
    public void testVieHeros() {
        assertEquals(h.getVie(), 100);
        h.perdVie(80);
        assertEquals(h.getVie(), 20);
        h.setVie(35);
        assertEquals(h.getVie(), 55);
        h.perdVie(200);
        assertEquals(h.getVie(), 0);
        h.setVie(500);
        assertEquals(h.getVie(), 100);
    }

    @Test
    public void testManaHeros() {
        assertEquals(h.getMana(), 100);
        h.perdMana(80);
        assertEquals(h.getMana(), 20);
        h.setMana(35);
        assertEquals(h.getMana(), 55);
        h.perdMana(200);
        assertEquals(h.getMana(), 0);
        h.setMana(500);
        assertEquals(h.getMana(), 100);
    }


    @Test
    public void testImageHeros() {
        assertEquals(h.getImage(), Images.HEROS_E);
        h.changeImage(Direction.OUEST);
        assertEquals(h.getImage(), Images.HEROS_O);
        h.changeImage(Direction.SUD);
        assertEquals(h.getImage(), Images.HEROS_S);
        h.changeImage(Direction.NORD);
        assertEquals(h.getImage(), Images.HEROS_N);
    }

    @Test
    public void testCouleurVie() {
        assertEquals(h.getCouleurVie(), Color.GREEN);
    }

}
