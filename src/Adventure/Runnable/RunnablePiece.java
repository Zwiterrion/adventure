package Adventure.Runnable;

import Adventure.*;
import Adventure.ObjetsCarte.Piece;

public class RunnablePiece implements Runnable {

    private Heros heros;
    private Piece piece;

    private boolean niveauFini = false;

    public RunnablePiece(Heros h, Piece piece) {
        this.heros = h;
        this.piece = piece;
    }

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

    public void setNiveauFini(boolean niveauFini) {
        this.niveauFini = niveauFini;
    }
}
