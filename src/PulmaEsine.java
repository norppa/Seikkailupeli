import java.util.Scanner;

/**
 * Created by Administrator on 19/10/2017.
 */
public class PulmaEsine extends Esine {
    private String pulmaTeksti;
    private String pulmaRatkaisu;
    private String ratkaistuTeksti;
    private String eiRatkaistuTeksti;

    @Override
    Esine toiminto(){
        System.out.println(pulmaTeksti);
        Scanner s = new Scanner(System.in);
        String vastaus = s.nextLine();
        s.close();
        if (pulmaRatkaisu.equals(pulmaRatkaisu)) {
            System.out.println(ratkaistuTeksti);
            return this.sisalto;
        } else {
            System.out.println(eiRatkaistuTeksti);
            return new Esine();
        }
    }
}
