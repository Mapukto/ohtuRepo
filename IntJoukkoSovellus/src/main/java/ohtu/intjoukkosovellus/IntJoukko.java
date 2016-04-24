
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alustaLista(KAPASITEETTI);
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaLista(kapasiteetti);
        this.kasvatuskoko = OLETUSKASVATUS;

    }

    private void alustaLista(int kapasiteetti) {
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
    }


    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        alustaLista(kapasiteetti);
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {

        int eiOle = 0;
        if (alkioidenLkm == 0) {
            return lisaaTyhjaan(luku);
        } else {
        }
        if (!kuuluu(luku)) {
            lisaaEiTyhjaan(luku);
            return true;
        }
        return false;
    }

    private void lisaaEiTyhjaan(int luku) {
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % ljono.length == 0) {
            kopiointi();
        }
    }

    private void kopiointi() {
        int[] taulukkoOld = new int[ljono.length];
        taulukkoOld = ljono;
        kopioiTaulukko(ljono, taulukkoOld);
        ljono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, ljono);
    }

    private boolean lisaaTyhjaan(int luku) {
        ljono[0] = luku;
        alkioidenLkm++;
        return true;
    }

    public boolean kuuluu(int luku) {
        int on = 0;
        on = getOn(luku, on);
        if (on > 0) {
            return true;
        } else {
            return false;
        }
    }

    private int getOn(int luku, int on) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                on++;
            }
        }
        return on;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        int apu;
        kohta = poistaSuoraan(luku, kohta);
        if (kohta != -1) {
            return korjaaJarjestys(kohta);
        }

        return false;
    }

    private boolean korjaaJarjestys(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
        alkioidenLkm--;
        return true;
    }

    private int poistaSuoraan(int luku, int kohta) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                ljono[kohta] = 0;
                break;
            }
        }
        return kohta;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i];
                tuotos += ", ";
            }
            tuotos += ljono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        yhdisteLoop(x, aTaulu, bTaulu);
        return x;
    }

    private static void yhdisteLoop(IntJoukko x, int[] aTaulu, int[] bTaulu) {
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        leikkausLoop(y, aTaulu, bTaulu);
        return y;

    }

    private static void leikkausLoop(IntJoukko y, int[] aTaulu, int[] bTaulu) {
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
    }

    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        erotusLoop(z, aTaulu, bTaulu);
 
        return z;
    }

    private static void erotusLoop(IntJoukko z, int[] aTaulu, int[] bTaulu) {
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
    }

}