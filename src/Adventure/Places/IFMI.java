package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;

/**
 * Created by Etienne on 10/11/2015.
 */
public class IFMI extends Place {

    public IFMI(Heros h) {
        super(h, "ifmi");
        h.changeImage(Direction.SUD);
    }

}
