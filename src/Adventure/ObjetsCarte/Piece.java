package Adventure.ObjetsCarte;

import Adventure.Heros;
import Adventure.Images;
import Adventure.Interface.Animable;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;
import Adventure.IsometricHelper;
import Adventure.Position;
import Adventure.Runnable.RunnablePiece;

public class Piece extends ObjetCarte implements Fixe, Ramassable, Animable {

    public Position p;

    public int x = 0;
    public int y = 0;

    private Thread t;
    private RunnablePiece m;

    public Piece(Position p, Heros h) {
        this.p = IsometricHelper.point2DToIso(p);
        m = new RunnablePiece(h,this);
        t = new Thread(m);
    }

    @Override
    public void assigneImage() {
        image = Images.PIECE;
    }


    @Override
    public void active() {
        t.start();
    }

    @Override
    public void stop() {
        m.setNiveauFini(true);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
