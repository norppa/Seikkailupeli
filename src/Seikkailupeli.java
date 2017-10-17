import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {


    Set<String> komennot;

    public Seikkailupeli() {
        komennot = new HashSet<>();
        komennot.add("katso");
        komennot.add("käänny");
    }

    public String lueKomento() {
        // Otetaan käyttäjältä komento ja muutetaan se pieniksi kirjaimiksi
        Scanner lukija = new Scanner(System.in);
        String komento=lukija.nextLine();
        komento =komento.toLowerCase();

        // Katsotaan sisältääkö käyttäjän teksti jonkun komennon:
        if(komento.contains("katso")){
            return "katso";
        } else if(komento.contains("käänny")){
            return "käänny";
        } return null;
    }

    public void suorita(String komento) {
        if (komento.equals("katso")) {
            System.out.println("Sinä katsot");
        } else if (komento.equals("käänny")) {
            System.out.println("Sinä käännyt");
        } else {
            System.out.println("Komentoa ei tunnistettu");
        }

    }

}
