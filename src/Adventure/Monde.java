package Adventure;

import Adventure.Interface.*;
import Adventure.ObjetsCarte.*;
import Adventure.Places.*;

import javax.swing.*;
import java.awt.*;

/**
 * Cree une instance de la classe Monde : instance unique dans le jeu
 */
public final class Monde extends JPanel {

    private Heros heros;

    private Place place;
    private Niveaux niveaux;

    public UIutilisateur ath;

    private Annonce annonce;
    private Annonce description;

    // Constantes
    public static int TILE_SIZE;
    public static int SCREEN_SIZE;
    public static int X_MAX;
    public static int Y_MAX;

    /**
     * Construit le monde avec une taille fixe de case (par defaut: 100 cases) et une taille pour chaque case
     *
     * @param X_MAX
     *      Nombre de colonnes
     * @param Y_MAX
     *      Nombre de lignes
     * @param screen_size
     *      Taille de la fenetre
     */
    public Monde(int X_MAX, int Y_MAX, int screen_size) {
        Monde.X_MAX = X_MAX;
        Monde.Y_MAX = Y_MAX;

        SCREEN_SIZE = screen_size;
        TILE_SIZE = (SCREEN_SIZE / X_MAX );

        heros = new Heros(this);
        ath = new UIutilisateur(heros);

        annonce = new Annonce(SCREEN_SIZE, 50);
        description = new Annonce(SCREEN_SIZE, 25);

        niveaux = new Niveaux(heros);

        initialisationNiveau(null);
    }

    /**
     * Fonction de dessin du monde
     * La fonction est coupee en plusieurs parties : le dessin se fait du plus eloigne en Z au plus proche
     * On dessine tout d'abord le fond (sol), les objets de la carte puis ensuite l'interface utilisateur (inventaire)
     * @param g
     *      Graphics instance
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(new Color(10, 55, 51));
        g.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);

        dessineSol(g);
        dessineObjetsMap(g);
        dessineATH(g);

        description.paint(g);
    }

    /**
     * Fonction de dessin du sol : dessine le sol en appelant la fonction getImage de chaque objet du sol
     * @param g
     *      Graphics instance
     */
    public void dessineSol(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Position point = IsometricHelper.point2DToIso(new Position(j, i));
                ObjetCarte object = place.mapSol.get(place.positions[i][j]);
                if (!(object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, (TILE_SIZE * 2), this);
            }
        }
    }

    /**
     * Dessine les objets du dessus, les objets animables ainsi que le heros
     * @param g
     *      Graphics instance
     */
    public void dessineObjetsMap(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Position point = IsometricHelper.point2DToIso(new Position(j, i));
                ObjetCarte object = place.mapObjects.get(place.positions[i][j]);

                if(object instanceof Animable) {
                    g.drawImage(object.getImage(),point.x + ((Animable) object).getX(),
                                                  point.y + ((Animable) object).getY(), TILE_SIZE, TILE_SIZE*2, this);
                }
                else {
                    if (!(object instanceof Vide))
                        g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);

                    if (i == heros.getPos_in().x && j == heros.getPos_in().y)
                        g.drawImage(heros.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
                }
            }
        }

    }

    /**
     * Appelle la fonction de dessin de l'interface utilisateur
     * @param g
     *          Graphics instance
     */
    public void dessineATH(Graphics g) {
        ath.paint(g);
    }

    /**
     * Permet de tester la nature de la prochaine case : la fonciton verifie l'ojet du sol et l'objet du dessus
     * afin de savoir ce que le heros doit faire.
     * @param p
     *      Position de la case a verifier
     * @param dir
     *      Direction du heros
     * @param x
     *      Ligne i de la case
     * @param y
     *      Colonne j de la case
     * @return
     *      Vrai si le heros peut avancer sur la case, faux dans le case contraire
     */
    public Boolean videOuPas(Position p, Direction dir, int x, int y) {

        ObjetCarte object = place.mapObjects.get(place.positions[p.x][p.y]);
        ObjetCarte objectSol = place.mapSol.get(place.positions[p.x][p.y]);

        if (objectSol instanceof Fixe) {

            if (objectSol instanceof Piege) {
                heros.perdVie(((Piege) objectSol).degat());
                return true;
            }
            else if (object instanceof Piege) {
                heros.perdVie(((Piege) object).degat());
                return false;
            }
            else if (object instanceof Sortie) {
                niveauSuivant(x, y, dir, (Sortie) object);
                return false;
            }
            else if (object instanceof Ramassable) {
                heros.ramasserObjet((Ramassable) object);
                afficheClefTrouve((Ramassable)object);
                place.mapObjects.put(place.positions[p.x][p.y], new Vide());
                return true;
            }
            else if (object instanceof Deplacable) {
                deplaceObjet(p, dir, x, y);
                return false;
            }
            else
                return !(object instanceof Fixe);
        } else
            return false;
    }

    /**
     * Fonction qui deplace un objet deplaçable. Elle vérifie egalement l'objet au sol car s'il c'est un vide
     * le heros pousse l'objet du dessus dans le vide et peut ainsi monter dessus.
     * @param positionObjet
     *        Position de l'objet à déplacer
     * @param dir
     *        Direction dans laquelle le heros doit se trouver apres le deplacement
     * @param x
     *      Ligne i de la case
     * @param y
     *      Colonne j de la case
     */
    public void deplaceObjet(Position positionObjet, Direction dir, int x, int y) {

        Position p = new Position(positionObjet.x + x, positionObjet.y + y);

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjetCarte object = place.mapObjects.get(place.positions[p.x][p.y]);
            ObjetCarte objectSol = place.mapSol.get(place.positions[p.x][p.y]);

            if (object instanceof Vide) {

                if (objectSol instanceof Fixe) {
                    Deplacable w = (Deplacable) place.mapObjects.get(place.positions[positionObjet.x][positionObjet.y]);
                    place.mapObjects.put(place.positions[p.x][p.y], (ObjetCarte) w);
                } else
                    place.mapSol.put(place.positions[p.x][p.y], new Herbe(Direction.TOUTES));

                place.mapObjects.put(place.positions[positionObjet.x][positionObjet.y], new Vide());
                heros.setPos_in(positionObjet);
                heros.changeImage(dir);
                repaint();
            }
        }
    }

    /**
     * Arrete tous les objets animables de la carte.
     * Deplace le heros sur la sortie choisie.
     * Si la porte est ouverte alors le heros change de monde.
     * Sinon il ne se passe rien.
     *
     * @param x
     *      Ligne i
     * @param y
     *      Colonne j
     * @param dir
     *      Direction suivante du heros
     * @param s
     *      Sortie à passer
     */
    public void niveauSuivant(int x, int y, Direction dir, Sortie s) {

        place.animables.forEach(Animable::stop);
        deplacement(x, y, dir);
        attente(300);

        if(s instanceof SortieFermee) {
            if(((SortieFermee) s).isOuverte())
                teleportation(s);
        }
        else
            teleportation(s);
    }

    /**
     * Fait la transition entre deux lieux et marque une pause pour afficher la description du nouveau lieu
     *
     * @param s
     *      Sortie à franchir
     */
    public void teleportation(Sortie s) {
        initialisationNiveau(s);
        pageDeDescription(place.nom);
        attente(1000);
        repaint();
    }

    /**
     * Affiche la page noire de transition entre deux lieux
     */
    public void pageDeDescription(String s) {

        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);
        annonce.setTexteAAfficher(s);
        annonce.paint(g);
    }

    /**
     * Fait patienter le thread principal
     * @param time
     */
    public void attente(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Initialise le prochain niveau et lance les objets animables
     * @param s
     *      Sortie qui vient d'être franchie
     */
    public void initialisationNiveau(Sortie s) {

        if (s == null)
            place = new Parking(heros);
        else {
            niveaux.sauvegarde(place);
            place = placeCorrespondante(s);
        }

        place.lancePersonnage();
        description.setTexteAAfficher(place.nom);
    }

    public Place placeCorrespondante(Sortie s) {

        String dest = s.getDestination();
        String placeCourante = s.getNomPlace();

        if(!s.dansUnCouloir()) {
            if(placeCourante.equalsIgnoreCase("parking")) {
                if(dest.equalsIgnoreCase("ifmi") || dest.equalsIgnoreCase("sp2mi")) {
                    heros.setPos_in(place.positions[4][8]);
                    return new CouloirPiege(heros, dest, placeCourante, true);
                }
                else {
                    heros.setPos_in(place.positions[4][1]);
                    return new CouloirPiege(heros, placeCourante, dest, false);
                }
            }
            else {
                if(placeCourante.equalsIgnoreCase("ifmi") || placeCourante.equalsIgnoreCase("sp2mi")) {
                    heros.setPos_in(place.positions[4][1]);
                    return new CouloirPiege(heros, placeCourante, dest, true);
                }
                else {
                    heros.setPos_in(place.positions[4][8]);
                    return new CouloirPiege(heros, dest, placeCourante, false);
                }
            }
        }
        else {
            if(dest.equalsIgnoreCase("parking")){
                    heros.setPos_in(place.positions[4][5]);
            }
            else {
                int y = 8-heros.getPos_in().y;
                if(y == -1)
                    y = 1;
                heros.setPos_in(place.positions[heros.getPos_in().x][y]);
            }
            return niveaux.niveauSuivant(s.getDestination());
        }

    }

    public void deplacementHeros(int x, int y, Direction dir) {

        Position nextPos = new Position(heros.getPos_in().x + x, heros.getPos_in().y + y);

        if(positionInGrille(nextPos))
            if (videOuPas(nextPos, dir, x, y))
                deplacement(x, y, dir);
    }

    public void deplacement(int x, int y, Direction dir) {

        heros.setPos_in(new Position(heros.getPos_in().x + x, heros.getPos_in().y + y));
        heros.changeImage(dir);
        paint(getGraphics());
    }

    public void changePositionPersonnage(Position e, Position precedente, Personnage personnage) {

        place.mapObjects.put(place.positions[precedente.x][precedente.y], new Vide());
        place.mapObjects.put(place.positions[e.x][e.y], personnage);
        paint(getGraphics());
    }

    public boolean estUnVide(Position nextPos, Personnage p) {
        if(positionInGrille(nextPos)) {
            if(nextPos.x == heros.getPos_in().x && nextPos.y == heros.getPos_in().y) {
                heros.perdVie(p.degat());
                return false;
            }
            else
                return (place.mapObjects.get(place.positions[nextPos.x][nextPos.y]) instanceof Vide &&
                        !(place.mapSol.get(place.positions[nextPos.x][nextPos.y]) instanceof Vide));
        }
        return false;
    }

    public boolean poseBombe() {

        if(heros.getMana() >= 10 && heros.getInventaire().getNbBombes() > 0) {
            heros.perdMana(10);
            ObjetCarte c = place.mapObjects.get(place.positions[heros.getPos_in().x][heros.getPos_in().y]);
            if(c instanceof SortieFermee) {
                ((SortieFermee) c).enExplosion();
                repaint();
                attente(500);
                lanceAnimationOuverture();
                repaint();
                attente(500);
                ((SortieFermee) c).ouvre();
            }
            else
                place.mapObjects.put(place.positions[heros.getPos_in().x][heros.getPos_in().y], new Bombe());

            repaint();
            return true;
        }else
            return false;
    }

    public boolean positionInGrille(Position nextPos) {
        return ((nextPos.x >= 0 && nextPos.x < X_MAX) && (nextPos.y >= 0 && nextPos.y < Y_MAX));
    }

    public boolean lanceAnimationOuverture() {

        Position pHeros = new Position(heros.getPos_in().x, heros.getPos_in().y);

        if(positionInGrille(new Position(pHeros.x+1, pHeros.y))) {
            if(place.mapObjects.get(place.positions[pHeros.x+1][pHeros.y]) instanceof Vide) {
                deplacement(1, 0, Direction.OUEST);
                return true;
            }

        }
        if(positionInGrille(new Position(pHeros.x-1, pHeros.y))) {
            if(place.mapObjects.get(place.positions[pHeros.x-1][pHeros.y]) instanceof Vide) {
                deplacement(-1, 0, Direction.EST);
                return true;
            }
        }
        if(positionInGrille(new Position(pHeros.x, pHeros.y+1))) {
            if(place.mapObjects.get(place.positions[pHeros.x][pHeros.y+1]) instanceof Vide) {
                deplacement(0, 1, Direction.NORD);
                return true;
            }
        }
        else {
            deplacement(0,-1,Direction.SUD);
            return true;
        }

        return true;

    }

    public Heros getHeros() {
        return heros;
    }

    public void relance() {
        niveaux = new Niveaux(heros);
        initialisationNiveau(null);
        heros.recommenceNiveau();
        heros.getInventaire().recommencer();
        repaint();
    }

    public void setMouse(boolean mouse) {
        heros.getInventaire().setMouse(mouse);
    }

    public void afficheClefTrouve(Ramassable r) {
        if(r instanceof Clef) {
            pageDeDescription("Clef trouve !");
            attente(1200);
            repaint();
        }

    }
}

