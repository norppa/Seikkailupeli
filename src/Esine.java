import java.util.*;
public class Esine {
    protected String kuvaus;
    protected Esine sisalto;
    // depricated protected Map<Esine, String> kayttoKuvaukset;
    protected List<String> muodot;
    protected String oikeaKayttoKomento;
    protected Esine oikeaKayttoEsine;
    protected String oikeaKayttoTeksti;
    protected Map<String, Map<Esine, String>> kayttoTekstit;
    protected String viimeisinKayttoTeksti;
    protected String oletusKayttoTeksti = "Et voi käyttää tätä esinettä noin";

    public Esine() {
        this("");
    }


    public Esine(String nimi) {
        muodot = new ArrayList<String>();
        muodot.add(nimi);
        // depricated kayttoKuvaukset = new HashMap<>();
        sisalto = null;
        kayttoTekstit = new HashMap<>();
    }

    private void asetaKayttoKuvaus(String komento, Esine esine, String kayttoKuvaus) {
        if (!kayttoTekstit.containsKey(komento)) {
            kayttoTekstit.put(komento, new HashMap<>());
        }
        kayttoTekstit.get(komento).put(esine, kayttoKuvaus);
    }

    public String haeKuvaus() {
        return this.kuvaus;
    }

    public void asetaKatsoKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    /**
     * Kun Esinettä käytetään, esineen muuttujaan 'viimeisinKayttoTeksti' tallennetaan
     * kuvaus siitä, mitä tapahtuu kun Esinettä käytetään Komennolla komento ja
     * Esineellä esine.
     * @param komento komento, jolla Esinettä käytetään
     * @param esine esine, jolla Esinettä käytetään
     */
    private void asetaViimeisinKayttoTeksti(String komento, Esine esine) {
        if (kayttoTekstit.containsKey(komento) && kayttoTekstit.get(komento).containsKey(esine)) {
            viimeisinKayttoTeksti = kayttoTekstit.get(komento).get(esine);
        } else {
            viimeisinKayttoTeksti = oletusKayttoTeksti;
        }

    }

    public Esine kayta(String komento, Esine esine) {
        asetaViimeisinKayttoTeksti(komento, esine);
        if (esine.equals(oikeaKayttoEsine) && komento.equals(oikeaKayttoKomento)) {
            toiminto();
            return sisalto;
        }
        return new Esine();
    }

    /* Lapset overridaa tämän ja luo lisätoiminnallisuutta */
    void toiminto() {}

    public void lisaaSisalto(Esine esine) {
        sisalto = esine;
    }

    public void setOikeaKaytto(String oikeaKayttoKomento, Esine oikeaKayttoEsine, String oikeaKayttoTeksti) {
        this.oikeaKayttoKomento = oikeaKayttoKomento;
        this.oikeaKayttoEsine = oikeaKayttoEsine;
        asetaKayttoKuvaus(oikeaKayttoKomento, oikeaKayttoEsine, oikeaKayttoTeksti);

    }

    public String getViimeisinKayttoTeksti() {
        return viimeisinKayttoTeksti;
    }
//    public String getOikeaKayttoTeksti() {
//        return oikeaKayttoTeksti;
//    }

    // muoto1=patjalla, muoto2=patjaa
    public void asetaMuodot(String muoto1, String muoto2){
        muodot.add(muoto1);
        muodot.add(muoto2);
    }

    public List<String> getMuodot() {
        return muodot;
    }

    public String toString() {
        return this.muodot.get(0);
    }

    public boolean equals(Esine e) {
        return this.muodot.get(0).equals(e.getMuodot().get(0));
    }
}