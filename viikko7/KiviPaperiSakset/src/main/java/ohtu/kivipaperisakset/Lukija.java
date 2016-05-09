package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 * Created by Jussi on 05/05/16.
 */
public class Lukija implements IO {
    private Scanner sc;

    public Lukija() {
        sc = new Scanner(System.in);
    }

    @Override
    public String read() {
        return sc.nextLine();
    }
}
