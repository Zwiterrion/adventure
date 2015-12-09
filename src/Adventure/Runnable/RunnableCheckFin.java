package Adventure.Runnable;

import Adventure.Heros;
import Adventure.ObjetsCarte.Vide;
import Adventure.Position;

public class RunnableCheckFin implements Runnable {

    private boolean end = false;
    private boolean stop = false;
    private Heros h;

    public RunnableCheckFin(Heros h) {
        this.h = h;
    }

    @Override
    public void run() {


        while (!stop) {

            while (!end) {

                check();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void check() {

        Position pHeros = new Position(h.getPos_in().x, h.getPos_in().y);

        if(pHeros.x == 4 && pHeros.y == 3) {
            h.getWorld().getPlace().ajoutObjet(4,4, new Vide());
            end = true;
            stop = true;
            h.getWorld().gagne();
        }
    }
    public void setEnd(boolean end) {
        this.end = end;
    }
}
