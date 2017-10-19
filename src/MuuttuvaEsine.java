/**
 * Created by Administrator on 19/10/2017.
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
