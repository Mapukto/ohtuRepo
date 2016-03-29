package ohtu.verkkokauppa;

/**
 * Created by Jussi on 29/03/16.
 */
public interface PankkiIO {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
