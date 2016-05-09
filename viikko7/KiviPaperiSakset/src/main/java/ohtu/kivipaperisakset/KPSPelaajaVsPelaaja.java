package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Peli {

    public KPSPelaajaVsPelaaja(IO io, Tekis tekis) {
        super(tekis);
        this.io = io;
    }

    private IO io;

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.read();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.read();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.read();
            
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = io.read();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}