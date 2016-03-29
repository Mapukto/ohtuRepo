package ohtu.verkkokauppa;

public class Viitegeneraattori implements ViitegeneraattoriIO {
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
