/**
 * Created by Administrator on 17/10/2017.
 */
public class Main {
    public static void main(String[] args) {

        String nimi;    // käyttäjän antama nimi?
        Seikkailupeli peli = new Seikkailupeli();

        while (true) { // Peli pyörii, kun komentoja suoritetaan
            //Set<String> komennot.., Jari lisää?
            String komento = peli.lueKomento();
            peli.suorita(komento);

        }

    }
}