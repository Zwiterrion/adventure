package Adventure.ObjetsCarte;

import Adventure.Heros;
import Adventure.Images;
import Adventure.Interface.Animable;
import Adventure.Interface.Piege;
import Adventure.Position;
import Adventure.Runnable.AnimationPersonnage;

/**
 * Crée une instance de Personnage
 */
public class Personnage extends ObjetCarte implements Piege,Animable {

    public Position p;

    public int x = 0;
    public int y = 0;

    private Thread t;
    private AnimationPersonnage m;

    /**
     * Contruit le Personnage
     * @param p
     *        La position dans la carte
     * @param h
     *        Instance du héros
     */
    public Personnage(Position p, Heros h) {
        this.p = p;
        m = new AnimationPersonnage(p,h, this);
        t = new Thread(m);
    }

    @Override
    public void active() {
        t.start();
    }

    @Override
    public void stop() { m.setNiveauFini(true);}

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

    /**
     * Assigne l'image qui corresponde au Herbe, selon la direction à dessiner
     */
    public void assigneImage() {
        switch (dir) {
            case AUCUNE:
                image = Images.LAPIN_EST;
                break;
            case SUD:
                image = Images.LAPIN_SUD;
                break;
            case NORD:
                image = Images.LAPIN_NORD;
                break;
            case EST:
                image = Images.LAPIN_EST;
                break;
            case OUEST:
                image = Images.LAPIN_OUEST;
                break;
            default:
                image = Images.LAPIN_EST;
        }
    }
}
