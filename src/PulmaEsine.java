import java.util.Scanner;

/**
 * PulmaEsine kysyy pelaajalta kysymyksen ja luovuttaa
 * sisältönsä vasta kun kysymykseen vastataan oikein.
 *
 * String pulmaTeksti on kysymyksenasetteluteksti
 * String pulmaRatkaisu on oikea vastaus, joka käyttäjän tulee antaa
 * String ratkaistuTeksti tulostetaan käyttäjälle kun oikea vastaus on annettu
 * String eiRatkaistuTeksti tulostetaan käyttäjälle jos annettu vastaus on väärä
 *
 */
public class PulmaEsine extends Esine {
    private String pulmaTeksti;
    private String pulmaRatkaisu;
    private String ratkaistuTeksti;
    private String eiRatkaistuTeksti;
    private Scanner scanner;

    public PulmaEsine(String nimi, String pulmaTeksti, String pulmaRatkaisu, String ratkaistuTeksti, String eiRatkaistuTeksti, Scanner scanner) {
        super(nimi);
        this.pulmaTeksti = pulmaTeksti;
        this.pulmaRatkaisu = pulmaRatkaisu;
        this.ratkaistuTeksti = ratkaistuTeksti;
        this.eiRatkaistuTeksti = eiRatkaistuTeksti;
        this.scanner = scanner;
    }

    @Override
    Esine toiminto(){
        System.out.println(pulmaTeksti);
        String vastaus = scanner.nextLine();
        if (vastaus.equals(pulmaRatkaisu)) {
            System.out.print(ratkaistuTeksti);
            return this.sisalto;
        } else {
            System.out.print(eiRatkaistuTeksti);
            return new Esine();
        }
    }
}
