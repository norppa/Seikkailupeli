/**
 * Kun luokan LopetusEsine ilmentymää käytetään oikealla tavalla,
 * peli päättyy.
 *
 * Seikkailupeli peli on peli, joka päätetään
 */
public class LopetusEsine extends Esine {
    Seikkailupeli peli;

    public LopetusEsine(String nimi, Seikkailupeli peli) {
        super(nimi);
        this.peli = peli;
    }

    @Override
    Esine toiminto() {
        peli.lopetaPeli();
        return this.sisalto;
    }
}
