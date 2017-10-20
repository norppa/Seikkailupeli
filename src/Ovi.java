/**
 * Ovi on poikkeuksellinen esine. Se siirtää pelaajan nykyisestä huoneesta
 * uuteen huoneeseen.
 *
 * Huone seuraavaHuone on huone, johon seikkalija siirretään
 * Seikkailija seikkailija on siirrettävä seikkailija
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
