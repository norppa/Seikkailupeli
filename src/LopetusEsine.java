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
    Esine toiminto() {
        peli.lopetaPeli();
        return this.sisalto;
    }
}
