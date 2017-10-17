import java.util.List;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Huone {
    private String kuvaus;
    List<Esine> huoneenEsineet;

    public void lisaaEsine(Esine esine) {
        huoneenEsineet.add(esine);
    }

    public void asetaKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

}
