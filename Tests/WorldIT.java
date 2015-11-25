import Adventure.Position;
import Adventure.World;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldIT {

    private static World w;
    
    @BeforeClass
    public static void setUpClass() {
        w = new World(10,10,1024);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp()  {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInitialisationWorld() {
        assertEquals(World.X_MAX, 10);
        assertEquals(World.Y_MAX, 10);
        assertEquals(World.TILE_SIZE, 1024 / 10);
    }

    @Test
    public void testHerosDifferentNull() {
        assertNotNull(w.getHeros());
    }

    @Test
    public void isInGrille() {
        int i = 9;
        int j = 7;
        assertTrue(w.positionInGrille(new Position(i,j)));
        j = 11;
        assertFalse(w.positionInGrille(new Position(i,j)));
    }

}
