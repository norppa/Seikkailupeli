import java.util.*;
public class Esine {
    protected String kuvaus;
    protected Esine sisalto;
    protected Map<Esine, String> kayttoKuvaukset;
    protected List<String> muodot;
    protected String oikeaKayttoKomento;
    protected Esine oikeaKayttoEsine;
    protected String oikeaKayttoTeksti;
    protected Map<String, Map<Esine, String>> kayttoTekstit;
    protected String viimeisinKayttoTeksti;
    protected String oletusKayttoTeksti = "Et voi käyttää tätä esinettä noin";


    public Esine(String nimi) {
        muodot = new ArrayList<String>();
        muodot.add(nimi);
        kayttoKuvaukset = new HashMap<>();
        sisalto = null;
        kayttoTekstit = new HashMap<>();
    }

    public void asetaKayttoKuvaus(String komento, Esine esine, String kayttoKuvaus) {
        if (!kayttoTekstit.containsKey(komento)) {
            kayttoTekstit.put("komento", new HashMap<Esine, String>());
        }
        kayttoTekstit.get(komento).put(esine, kayttoKuvaus);
    }

    public String haeKuvaus() {
        return this.kuvaus;
    }

    public void asetaKatsoKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public Esine kayta(String komento, Esine esine) {
        System.out.println("DEBUG:\n\"Tämä esine: " + this + " komento: " + komento +  " käyttöesine: " + esine +
                "\n oikea komento: " + oikeaKayttoKomento + " oikea käyttöesine: " + oikeaKayttoEsine);
        if (kayttoTekstit.containsKey(komento) && kayttoTekstit.get(komento).containsKey(esine)) {
            viimeisinKayttoTeksti = kayttoTekstit.get(komento).get(esine);
        } else {
            viimeisinKayttoTeksti = oletusKayttoTeksti;
        }

        if (esine == null) {
            if (oikeaKayttoEsine == null && komento.equals(oikeaKayttoKomento)) {
                System.out.println("palautetaan sisalto");
                return sisalto;
            }
        } else if (komento.equals(oikeaKayttoKomento) && esine.equals(oikeaKayttoEsine)) {
            return sisalto;
        }
        System.out.println("palautetaan null");
        return null;
    }

    public void lisaaSisalto(Esine esine) {
        sisalto = esine;
    }

    public void setOikeaKayttoKomento(String oikeaKayttoKomento) {
        this.oikeaKayttoKomento = oikeaKayttoKomento;
    }
    public void setOikeaKayttoEsine(Esine oikeaKayttoEsine) {
        this.oikeaKayttoEsine = oikeaKayttoEsine;
    }
    public void setOikeaKayttoTeksti(String oikeaKayttoTeksti) {
        this.oikeaKayttoTeksti = oikeaKayttoTeksti;
    }
    public String getOikeaKayttoTeksti() {
        return oikeaKayttoTeksti;
    }

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
}