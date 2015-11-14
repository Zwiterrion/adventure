package Adventure.Interface;

/**
 * Created by Etienne on 14/11/2015.
 */
public interface Ramassable {

    public default int quantite() {
        return 30;
    }
}
