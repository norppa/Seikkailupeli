import java.util.List;
import java.util.Map;

public class Esine { // Jari & Riina
    private String kuvaus;
    private List<Esine> sisalto;
    private Map<Esine, String> kayttoKuvaukset;

    public Esine(String nimi) {
        this.nimi = nimi;
    }

    private String nimi;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String haeKuvaus() {
        return this.kuvaus;
    }
    public void kayta(Esine esine) {}

    public void asetaKayttoKuvaukset(Map<Esine, String> kayttokuvaukset) {

    }

    public void lisaaSisalto(Esine esine) {
        sisalto.add(esine);
    }
}