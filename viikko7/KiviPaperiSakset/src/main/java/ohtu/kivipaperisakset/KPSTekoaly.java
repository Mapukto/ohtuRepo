package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {
    private Tekis tekis;
    private IO io;

    public KPSTekoaly(IO io, Tekis tekis) {
        super(tekis);
        this.io = io;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.read();
        String tokanSiirto;

        tokanSiirto = tekis.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);


        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.read();

            tokanSiirto = tekis.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            tekis.asetaSiirto(ekanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}