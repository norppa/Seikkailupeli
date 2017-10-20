/**
 *Muuttuva esine poistaa itsensä huoneen inventaariosta ja
 *lisää sinne uuden esineen eli "muuttuu" toiseksi esineeksi.
 *
 * Esine uusiEsine esine, jolla nykyinen korvataan
 * Huone huone huone, jonka inventaariota käsitellään
 * String uusiHuoneenKuvaus uudistettu kuvaus huoneesta
 */
public class MuuttuvaEsine extends Esine {
    private Esine uusiEsine;
    private Huone huone;
    private String uusiHuoneenKuvaus;

    public MuuttuvaEsine(String nimi, Huone huone, Esine uusiEsine, String uusiHuoneenKuvaus) {
        super(nimi);
        this.uusiEsine = uusiEsine;
        this.huone = huone;
        this.uusiHuoneenKuvaus = uusiHuoneenKuvaus;
    }

    @Override
    Esine toiminto() {
        huone.poistaEsine(this);
        huone.lisaaEsine(uusiEsine);
        huone.asetaKuvaus(uusiHuoneenKuvaus);
        return this.sisalto;
    }
}
