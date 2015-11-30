package Adventure.Runnable;

import Adventure.Heros;
import Adventure.ObjetsCarte.Piece;

/**
 * Crée une instance de AnimationPiece
 */
public class AnimationPiece implements Runnable {

    private Heros heros;
    private Piece piece;

    private boolean niveauFini = false;
    private boolean end = false;

    /**
     * Construit AnimationPiece
     * @param piece
     *      Instance de Potion
     * @param h
     *      Instance du héros
     */
    public AnimationPiece(Heros h, Piece piece) {
        this.heros = h;
        this.piece = piece;
    }

    /**
     * La piece continue à bouger tant que le héros n'a pas changé de lieu
     * ou qu'il ne l'a pas ramasse
     */
    @Override
    public void run() {

        while (!end) {

            if(!niveauFini)
                animation();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Le processus fait bouger la piece de haut en bas dans le lieu
     */
    public void animation() {

        int offset = 1;

        int i = 0;
        while (i < 20) {

            piece.y -= offset;
            heros.getWorld().repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;
        }
        i = 0;
        while (i < 20) {

            piece.y += offset;
            heros.getWorld().repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;
        }

    }

    /**
     * Change la situation de niveauFini
     * @param niveauFini
     *          Vaut vrai si le héros se déplace vers un autre lieu
     */
    public void setNiveauFini(boolean niveauFini) {
        this.niveauFini = niveauFini;
    }
}
