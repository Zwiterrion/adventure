package Adventure.Runnable;

import Adventure.Heros;
import Adventure.ObjetsCarte.Piece;

/**
 * Crée une instance de RunnablePiece
 */
public class RunnablePiece implements Runnable {

    private Heros heros;
    private Piece piece;

    private boolean niveauFini = false;

    /**
     * Construit RunnablePiece
     * @param piece
     *      Instance de Potion
     * @param h
     *      Instance du héros
     */
    public RunnablePiece(Heros h, Piece piece) {
        this.heros = h;
        this.piece = piece;
    }

    /**
     * Les pieces continue à bouger tant que le héros n'a pas changé de lieu
     */
    @Override
    public void run() {

        while (!niveauFini) {

            animation();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Le processus déplace fait bouger les pieces dans le lieu
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
     *          vaut vrai si le héros se déplace vers un autre lieu
     */
    public void setNiveauFini(boolean niveauFini) {
        this.niveauFini = niveauFini;
    }
}
