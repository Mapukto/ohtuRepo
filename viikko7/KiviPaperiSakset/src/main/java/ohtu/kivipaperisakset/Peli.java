package ohtu.kivipaperisakset;

/**
 * Created by Jussi on 04/05/16.
 */
public abstract class Peli {
    protected Tekis tekis;

    abstract void pelaa();

    public Peli(Tekis tekis) {
        this.tekis = tekis;
    }

    public static Peli luoParempiTekoalyPeli(IO io) {
        return new Peli(new KPSParempiTekoaly(io, new TekoalyParannettu()));
    }

    public static Peli luoHuonoTekoAlyPeli(IO io) {
        return new Peli(new KPSTekoaly(io, new Tekoaly()));
    }

    public static Peli luoPelaajaVastaanPelaajaPeli(IO io) {
        return new Peli(new KPSPelaajaVsPelaaja(io, new Tekoaly()));
    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
