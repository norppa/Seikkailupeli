/**
 * Created by Administrator on 17/10/2017.
 */
public class Main {
    public static void main(String[] args) {

        String nimi;    // käyttäjän antama nimi?
        Seikkailupeli peli = new Seikkailupeli();

        peli.tulostaTervetuloa();
        while (peli.jatkuuko()) {
            peli.lueKomento();

        }
        peli.tulostaLopetus();

    }
}
