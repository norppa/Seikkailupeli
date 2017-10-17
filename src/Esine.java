import java.util.*;

public class Esine { // Jari & Riina
    private String kuvaus;
    private Esine sisalto;
    private Map<Esine, String> kayttoKuvaukset;
    private String nimi;
    private Set<String> taivutusmuodot;
    private String oikeaKayttoKomento;
    private Esine oikeaKayttoEsine;
    private String oikeaKayttoTeksti, vaaraKayttoTeksti;

    public String getOikeaKayttoTeksti() {
        return oikeaKayttoTeksti;
    }


    public Esine(String nimi) {
        this.nimi = nimi;
        taivutusmuodot = new HashSet<>();
        kayttoKuvaukset = new HashMap<>();
        sisalto = null;
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
    public Esine kayta(String komento, Esine esine) {
        if (komento.equals(oikeaKayttoKomento) && esine.equals(oikeaKayttoEsine)) {
            return sisalto;
        }
        return null;
    }

    public void asetaKayttoKuvaukset(Map<Esine, String> kayttokuvaukset) {

    }

    public void lisaaSisalto(Esine esine) {
        sisalto = esine;
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