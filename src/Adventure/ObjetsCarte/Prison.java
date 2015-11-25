package Adventure.ObjetsCarte;


import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

public class Prison extends ObjetCarte implements Fixe {

    public Prison(Direction d) {
        super(d);
    }

    @Override
    public void assigneImage() {
        if(dir == Direction.SUD || dir == Direction.NORD)
            image = Images.PRISON_NORD;
        else
            image = Images.PRISON_EST;
    }
}
