/**
 * Created by Administrator on 18/10/2017.
 */
public class LopetusEsine extends Esine {
    Seikkailupeli peli;

    public LopetusEsine(String nimi, Seikkailupeli peli) {
        super(nimi);
        this.peli = peli;
    }

    @Override
    public Esine kayta(String komento, Esine esine) {
        if (super.kayttoTekstit.containsKey(komento) && kayttoTekstit.get(komento).containsKey(esine)) {
            viimeisinKayttoTeksti = kayttoTekstit.get(komento).get(esine);
        } else {
            viimeisinKayttoTeksti = oletusKayttoTeksti;
        }

        if (esine == null) {
            if (oikeaKayttoEsine == null && komento.equals(oikeaKayttoKomento)) {
                System.out.println("palautetaan sisalto");
                peli.lopetaPeli();
                return sisalto;
            }
        } else if (komento.equals(oikeaKayttoKomento) && esine.equals(oikeaKayttoEsine)) {
            peli.lopetaPeli();
            return sisalto;
        }
        return null;
    }
}
