package ohtu.verkkokauppa;

/**
 * Created by Jussi on 29/03/16.
 */
public interface OstoskoriIO {
    void lisaa(Tuote t);

    void poista(Tuote t);

    int hinta();
}
