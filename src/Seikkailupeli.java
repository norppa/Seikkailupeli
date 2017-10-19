import java.util.*;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {
    Huone huone;
    Seikkailija pelaaja;
    private boolean jatkuuko;
    private Set<String> komennot;


    // Null ei kelpaa avaimeksi
    Esine nul = new Esine();

    public Seikkailupeli() {
        alustaSeikkailu();
        jatkuuko = true;
    }

    public void lopetaPeli() {
        jatkuuko = false;
    }

    public boolean jatkuuko() {
        return jatkuuko;
    }

    public void tulostaTervetuloa() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Tervetuloa seikkailupeliin! Kerro nimesi: ");
        String nimi = lukija.nextLine();
        System.out.println("Hei seikkailija " + nimi + "! Aloitetaan seikkailu! Heräät pimeästä huoneesta, josta sinun on päästävä ulos, jotta peli loppuu. \nVoit katsoa ympärillesi ja käyttää löytämisiä esineitä. Loput sinun on selvitettävä itse. Onnea peliin!");
        System.out.println("\nKäske seikkailijaa tekemään jotain.");
    }

    public void tulostaLopetus() {
        System.out.println("Ovi aukeaa ja raitis ulkoilma virtaa kasvoillesi. Onnen kyyneleet valuvat poskiasi pitkin, kun tajuat, että kurjan elämäsi viimeiset hetket eivät olleet tunkkaisessa pakohuoneessa.");
    }

    public void alustaSeikkailu() {


        // Käytettävissä olevat komennot
        komennot = new HashSet<>();
        komennot.add("katso");
        komennot.add("avaa");
        komennot.add("lyö");
        komennot.add("nosta");
        komennot.add("inventaario");
        komennot.add("luovuta");

        //Luodaan huone, sen kuvaus ja huoneen sisältö.
        huone = new Huone();
        huone.asetaKuvaus("Huoneessa on patja ja pöytä. Huoneessa on ovi.");


        //Luodaan pelaaja ja asetetaan hänet huoneeseen.
        pelaaja = new Seikkailija();
        pelaaja.setHuone(huone);

        //luodaan huoneen 1 esineet:
        Esine patja = new Esine("patja");
        Esine poyta = new Esine("pöytä");
        Esine ovi = new LopetusEsine("ovi", this);

        //luodaan huoneen 1 käyttöesineet
        Esine vasara = new Esine("vasara");
        Esine avain = new Esine("avain");
        Esine tiirikka = new Esine("tiirikka");
        Esine rasia = new Esine("rasia");

        //Luodaan patjan ominaisuudet ja lisätään se huoneeseen
        patja.asetaKatsoKuvaus("Kusenkeltainen patja on niin likainen, että sinua hieman puistattaa, kun tajuat nukkuneesi siinä. Näyttää siltä, että patjan alla on jotain.");
        patja.asetaMuodot("patjalla", "patjaa");
        huone.lisaaEsine(patja);

//        patja.setOikeaKayttoKomento("nosta");
        patja.setOikeaKaytto("nosta", nul, "Nostat patjaa ja sen alta paljastuu vasara. Otat vasaran mukaasi.");

        //Luodaan pöydän ominaisuudet ja lisätään se huoneeseen
        poyta.asetaKatsoKuvaus("Huoneen ainoa huonekalu on puinen antiikkipöytä. Pöydällä on rasia.");
        poyta.asetaMuodot("pöydällä", "pöytää");
        huone.lisaaEsine(poyta);
        poyta.setOikeaKaytto("lyö", vasara, "Lyöt pöytää vasaralla ja sen pohjaan teipattu avain tipahtaa lattialle. Kyykistyt lattialle ja noukit avaimen käteesi.");
//        poyta.setOikeaKayttoEsine(vasara);
//        poyta.setOikeaKayttoKomento("lyö");
//        poyta.setOikeaKayttoTeksti("Lyöt pöytää vasaralla ja sen pohjaan teipattu avain tipahtaa lattialle. Kyykistyt lattialle ja noukit avaimen käteesi.");

        //Luodaan oven ominaisuudet ja lisätään se huoneeseen
        ovi.asetaMuodot("ovella", "ovea");
        ovi.asetaKatsoKuvaus("Ovi on teräksinen ja erittäin jykevä. Sen murtamista on turha yrittää. Ovi on lukossa, mutta ruosteisessa lukkopesässä on avaimenreikä, josta näkyy himmeästi valaistuun tilaan.");
        huone.lisaaEsine(ovi);
        ovi.setOikeaKaytto("avaa", tiirikka, "Muistelet näkemääsi elokuvaa, jossa sankari avaa oven tiirikalla. Tovin sorkittuasi kuulet klikkauksen ja lukko aukeaa!");

//        ovi.setOikeaKayttoEsine(tiirikka);
//        ovi.setOikeaKayttoKomento("avaa");
//        ovi.setOikeaKayttoTeksti("Muistelet näkemääsi elokuvaa, jossa sankari avaa oven tiirikalla. Tovin sorkittuasi kuulet klikkauksen ja lukko aukeaa!");
        ovi.lisaaSisalto(new Esine(""));

        //Luodaan rasian ominaisuudet ja lisätään se huoneeseen
        rasia.asetaKatsoKuvaus("Kädessäsi on metallinen rasia, joka on lukittu. Heiluttaessa rasia kolisee... Onkohan sisällä jotain?");
        rasia.asetaMuodot("rasialla", "rasiaa");
        huone.lisaaEsine(rasia);
        rasia.setOikeaKaytto("avaa", avain, "Avain sopii rasiaan! Avaat rasian ja löydät sen sisältä erikoisen näköisen esineen. Voisikohan tämä olla tiirikka? Nappaat tiirikan mukaasi.");

//        rasia.setOikeaKayttoEsine(avain);
//        rasia.setOikeaKayttoKomento("avaa");
//        rasia.setOikeaKayttoTeksti("Avain sopii rasiaan! Avaat rasian ja löydät sen sisältä erikoisen näköisen esineen. Voisikohan tämä olla tiirikka? Nappaat tiirikan mukaasi.");

        //Lisätään esineissä olevat toiset esineet
        vasara.asetaMuodot("vasaralla", "vasaraa");
        vasara.asetaKatsoKuvaus("Vasara on vanha ja siinä on hieman ruostetta. Puinen varsi tuntuu kuitenkin tarpeeksi vahvalta, jotta vasaraa voi käyttää.");
        avain.asetaMuodot("avaimella", "avainta");
        avain.asetaKatsoKuvaus("Avain on metallinen ja muihin huoneen esineisiin verrattuna uuden näköinen.");
        tiirikka.asetaMuodot("tiirikalla", "tiirikkaa");
        tiirikka.asetaKatsoKuvaus("Tämä taitaa olla tiirikka. Mitenhän tätä käytetään..?");
        //Lisätään patjan sisältö
        patja.lisaaSisalto(vasara);
        //Lisätään pöydän sisältö
        poyta.lisaaSisalto(avain);
        //Lisätään rasian sisältö
        rasia.lisaaSisalto(tiirikka);

        /***   TOINEN HUONE   ***/
        Huone huone2 = new Huone();
        String huoneenKaksiKuvaus = "Tämän huoneen seinät ovat punaista tiiltä";

        // Huoneessa on taulu, ovi ja peili. Peilistä tulee sirpaleita.
        Esine sirpaleet = new Esine("sirpaleet");
//        MuuttuvaEsine peili = new MuuttuvaEsine("peili", huone2, );


    }

    private Esine sovita(String esineString, List<Esine> esineLista) {
        for (Esine e : esineLista) {
            if (e.getMuodot().contains(esineString)) {
                return e;
            }
        }
        return nul;
    }

    public void lueKomento() {

        /* Esineet, joihin pelaaja voi vaikuttaa */
        List<Esine> esineet = pelaaja.getHuone().getEsineet();
        esineet.addAll(pelaaja.getEsineet());

        // Otetaan käyttäjältä komento ja muutetaan se pieniksi kirjaimiksi
        Scanner lukija = new Scanner(System.in);
        String rivi = lukija.nextLine();
        rivi = rivi.toLowerCase();
        String[] komento = rivi.split("\\s+");

        if (komento.length == 0) {
            System.out.println("Mitä haluat tehdä?");
            return;
        }

        if (!komennot.contains(komento[0])) {
            System.out.println("\'" + komento[0] + "\' ei ole validi komento. Käytettävissäsi olevat komennot:");
            for (String s : komennot) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }

        if (komento.length > 3) {
            System.out.println("En ole niin fiksu että ymmärtäisin noin pitkiä komentoja.");
            return;
        }

        if (komento.length == 3) {
            for (int i = 1; i < 3; i++) {
                if (sovita(komento[i], esineet) == nul) {
                    System.out.println("Mikä on " + komento[i]);
                    return;
                }
            }
            komento = jarjestaKomento(komento);
        }

        if (komento.length == 2) {
            if (sovita(komento[1], esineet) == nul) {
                System.out.println("Mikä on " + komento[1]);
                return;
            }
        }


        /* parsitaan komennosta toiminta. Komento on 1-3 sanaa.
         * Ensimmäinen on käskysana, toinen on kohde-esine, kolmas apuesine
          * esim. "nosta patjaa kepillä" */

        /* jos komento on tyhjä, pelaaja ei ole antanut komentoa */


        /* jos komennon pituus on 1, hyväksyttyjä komentoja on
        "luovuta" ja "katso"  */

        if (komento.length == 1) {
            if (komento[0].equals("luovuta")) {
                System.out.println("Elämänhalusi valuu lattialle, et jaksa enempää. Jäät lattialle makaamaan, kunnes seuraava seikkalija löytää mätänevän ruumiisi...");
                System.exit(0);
            }
            if (komento[0].equals("katso")) {
                System.out.println(pelaaja.getHuone().getKuvaus());
                return;
            }
            if (komento[0].equals("inventaario")) { //pelaaja voi selvittää käytössään olevat esineet tällä komennolla
                pelaaja.Inventaario();
                return;
            }

            System.out.println("En ymmärrä komentoa. Anna komento käskymuodossa.");
        }

        /* jos komennon pituus on 2, komento voi olla "katso" tai
        jokin käyttökomento.
         */

        if (komento.length == 2) {
            if (komento[0].equals("katso")) {
                Esine katsottava = sovita(komento[1], esineet);
                if (katsottava == nul) {
                    System.out.println(pelaaja.getHuone().getKuvaus());
                } else {
                    System.out.println(katsottava.haeKuvaus());
                }
            } else {
                Esine valine = sovita(komento[1], esineet);
                Esine paluuarvo = valine.kayta(komento[0], nul);
                if (paluuarvo == nul) {
                    System.out.println("DEBUG: return null");
                    System.out.println("Et voi tehdä niin. Kokeile tehdä jotakin muuta.");
                } else {
                    System.out.println(valine.getViimeisinKayttoTeksti());
                    pelaaja.lisaaEsine(paluuarvo);
                }
            }
            return;
        }/* Jos pelaaja kokeilee väärää apuobjektia kohdeobjektiin, tulee virheilmoitus. Muutoin esine lisätään
            käyttäjän käytössä oleviin välineisiin*/
        if (komento.length == 3) {
            Esine valine = sovita(komento[1], esineet);
            Esine apuValine = sovita(komento[2], esineet);
            Esine paluuarvo = valine.kayta(komento[0], apuValine);
            if (paluuarvo == nul) {
                System.out.println("Et voi tehdä niin. Kokeile tehdä jotakin muuta.");
            } else {
                System.out.println(valine.getViimeisinKayttoTeksti());
                pelaaja.lisaaEsine(paluuarvo);
            }
            return;
        }
    }
    public boolean onkoApuvaline (String komento) { // onko komennon sana apuobjekti/apuväline

        if (komento.substring(komento.length() - 3).equals("lla")) {
            return true;
        } else if (komento.substring(komento.length() - 3).equals("llä")) {
            return true;
        } else {
            return false;
        }
    }

    public String[] jarjestaKomento (String[] kayttajanSanat) { //järjestää käyttäjän antaman komennon sanat ohjelman luettavaksi
        String[] uusikomento = new String[3];
        for (String sana : kayttajanSanat) {
            if (komennot.contains(sana)) {
                uusikomento[0] = sana;
            } else if (onkoApuvaline(sana)) {
                uusikomento[2] = sana;
            } else {
                uusikomento[1] = sana;
            }
        }
        return uusikomento;
    }

}