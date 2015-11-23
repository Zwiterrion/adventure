package Adventure;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecteurNiveau {

    private Tuple LEVEL_SOL[][] = new Tuple[10][10];
    private Tuple LEVEL_OBJETS[][] = new Tuple[10][10];

    public LecteurNiveau(String file)  {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document= builder.parse(new File("res/Niveau/" + file + ".xml"));

            Element racine = document.getDocumentElement();

            final NodeList racineNoeuds = racine.getChildNodes();
            final int nbRacineNoeuds = racineNoeuds.getLength();

            int x = 0;
            int y = 0;
            boolean sol = true;
            int fin = 0;

            for (int i = 0; i<nbRacineNoeuds; i++) {
                if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    if(fin != 2) {
                        final Element cellule = (Element) racineNoeuds.item(i);

                        int type = Integer.parseInt(cellule.getAttribute("type"));
                        Direction direction = Direction.change(cellule.getAttribute("direction"));

                        ajoutElement(x, y, sol, type, direction);

                        if (y == 9 && x == 9) {
                            x = 0;
                            y = 0;
                            sol = false;
                            fin++;
                        } else if (y == 9) {
                            x++;
                            y = 0;
                        }
                        else
                            y++;
                    }
                }
            }

        }
        catch (final ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void ajoutElement(int i, int j, boolean sol, int type, Direction dir) {

        if(sol)
            LEVEL_SOL[i][j] = new Tuple(type, dir);
        else
            LEVEL_OBJETS[i][j] = new Tuple(type, dir);

    }

    public Tuple[][] getLEVEL_SOL() {
        return LEVEL_SOL;
    }

    public Tuple[][] getLEVEL_OBJETS() {
        return LEVEL_OBJETS;
    }
}
