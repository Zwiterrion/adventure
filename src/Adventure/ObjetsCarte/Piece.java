package Adventure.ObjetsCarte;

import Adventure.Heros;
import Adventure.Images;
import Adventure.Interface.Animable;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;
import Adventure.IsometricHelper;
import Adventure.Position;
import Adventure.Runnable.AnimationPiece;

/**
 * Cree une instance de Piece
 */
public class Piece extends ObjetCarte implements Fixe, Ramassable, Animable {

    public Position p;

    public int x = 0;
    public int y = 0;

    private Thread t;
    private AnimationPiece m;

    /**
     * Contruit la Piece
     * @param p
     *        La position dans la carte
     * @param h
     *        Instance du heros
     */
    public Piece(Position p, Heros h) {
        this.p = IsometricHelper.point2DToIso(p);
        m = new AnimationPiece(h,this);
        t = new Thread(m);
    }

    /**
     * Assigne l'image qui correspond a la Piece
     */
    @Override
    public void assigneImage() {
        image = Images.PIECE;
    }

    @Override
    public void active() {
        m.setNiveauFini(false);
        if(t.getState() == Thread.State.NEW)
            t.start();
    }

    @Override
    public void stop() {
        m.setNiveauFini(true);
    }

    /**
     *
     * @return
     *      Retourne le decalage horizontal du Personnage dans la carte
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     *      Retourne le decalage vertical du Personnage dans la carte
     */
    @Override
    public int getY() {
        return y;
    }
}
