import java.util.Scanner;

/**
 * Created by Administrator on 19/10/2017.
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
            System.out.println(ratkaistuTeksti);
            return this.sisalto;
        } else {
            System.out.println(eiRatkaistuTeksti);
            return new Esine();
        }
    }
}
