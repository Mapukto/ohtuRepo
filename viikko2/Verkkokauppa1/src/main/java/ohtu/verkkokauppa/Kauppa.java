package ohtu.verkkokauppa;

public class Kauppa {

    private VarastoIO varastoIO;
    private PankkiIO pankkiIO;
    private OstoskoriIO ostoskoriIO;
    private ViitegeneraattoriIO viitegeneraattoriIO;
    private String kaupanTili;

    public Kauppa(VarastoIO varasto, PankkiIO pankki, ViitegeneraattoriIO viitegeneraattori) {
        varastoIO = varasto;
        pankkiIO = pankki;
        viitegeneraattoriIO = viitegeneraattori;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskoriIO = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varastoIO.haeTuote(id);
        varastoIO.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varastoIO.saldo(id)>0) {
            Tuote t = varastoIO.haeTuote(id);
            ostoskoriIO.lisaa(t);
            varastoIO.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattoriIO.uusi();
        int summa = ostoskoriIO.hinta();
        
        return pankkiIO.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}

//Kauppa kauppa = new Kauppa(Varasto.getInstance(), Pankki.getInstance(), Viitegeneraattori.getInstance() );