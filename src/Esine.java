import java.util.*;

public class Esine { // Jari & Riina
    private String kuvaus;
    private List<Esine> sisalto;
    private Map<Esine, String> kayttoKuvaukset;
    private String nimi;
    private Set<String> taivutusmuodot;

    public Esine(String nimi) {
        this.nimi = nimi;
        taivutusmuodot = new HashSet<>();
        kayttoKuvaukset = new HashMap<>();
        sisalto = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String haeKuvaus() {
        return this.kuvaus;
    }

    public void asetaKatsoKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    public void kayta(String tapa, Esine esine) {

    }

    public void asetaKayttoKuvaukset(Map<Esine, String> kayttokuvaukset) {

    }

    public void lisaaSisalto(Esine esine) {
        sisalto.add(esine);
    }

    public Set<String> getTaivutusmuodot() {
        return taivutusmuodot;
    }

    public void lisaaTaivutusmuodot(String... lisattavat) {
        for (int i = 0; i < lisattavat.length; i++) {
            this.taivutusmuodot.add(lisattavat[i]);

        }
    }
}