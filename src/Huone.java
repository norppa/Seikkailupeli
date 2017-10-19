import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Huone {

    private String kuvaus;
    private List<Esine> esineet;

    public Huone() {
        esineet = new ArrayList<>();
    }
    public String getKuvaus() {
        return kuvaus;
    }

    public void lisaaEsine(Esine esine) {
        esineet.add(esine);
    }
    public void poistaEsine(Esine esine) {esineet.remove(esine); }

    public void asetaKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public List<Esine> getEsineet() {
        return esineet;
    }

}
