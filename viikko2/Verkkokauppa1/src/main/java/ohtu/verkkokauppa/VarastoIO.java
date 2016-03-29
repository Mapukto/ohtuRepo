package ohtu.verkkokauppa;

/**
 * Created by Jussi on 29/03/16.
 */
public interface VarastoIO {
    Tuote haeTuote(int id);

    int saldo(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);
}
