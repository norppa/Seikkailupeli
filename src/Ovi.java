/**
 * Created by Administrator on 19/10/2017.
 */
public class Ovi extends Esine {
    private Huone seuraavaHuone;
    private Seikkailija seikkailija;

    public Ovi(String nimi, Huone seuraavaHuone, Seikkailija seikkailija) {
        super(nimi);
        this.seuraavaHuone = seuraavaHuone;
        this.seikkailija = seikkailija;
    }

    @Override
    Esine toiminto() {
        seikkailija.setHuone(seuraavaHuone);
        return new Esine();
    }

}
