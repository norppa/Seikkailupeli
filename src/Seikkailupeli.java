import java.util.*;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {
    Huone huone;
    Seikkailija pelaaja;
    private boolean jatkuuko;
//    Set<String> komennot;

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
        System.out.println("Hei " + nimi + "! Aloitetaan seikkailu! Heräät pimeästä huoneesta, josta sinun on päästävä ulos, jotta peli loppuu. \nVoit katsoa ympärillesi, ottaa esineitä käteesi ja tehdä niillä asioita. Loput sinun on selvitettävä itse. Onnea peliin!");
        System.out.println("\nMitä teet?");
    }

    public void tulostaLopetus() {
        System.out.println("Ovi aukeaa ja raitis ulkoilma virtaa kasvoillesi. Onnen kyyneleet valuvat poskiasi pitkin, kun tajuat, että kurjan elämäsi viimeiset hetket eivät olleet tunkkaisessa pakohuoneessa.");
    }

    public void alustaSeikkailu() {

        //Julistetaan käytettävät komennot
//        komennot = new HashSet<>();
//        komennot.add("katso");
//        komennot.add("nosta");
//        komennot.add("luovuta");

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
        patja.asetaMuodot("patjalla","patjaa");
        huone.lisaaEsine(patja);
        patja.setOikeaKayttoKomento("nosta");
        patja.setOikeaKayttoTeksti("Nostat patjaa ja sen alta paljastuu vasara");

        //Luodaan pöydän ominaisuudet ja lisätään se huoneeseen
        poyta.asetaKatsoKuvaus("Huoneen ainoa huonekalu on puinen antiikkipöytä. Pöydällä on rasia.");
        poyta.asetaMuodot("pöydällä", "pöytää");
        huone.lisaaEsine(poyta);
        poyta.setOikeaKayttoEsine(vasara);
        poyta.setOikeaKayttoKomento("lyö");
        poyta.setOikeaKayttoTeksti("Lyöt pöytää vasaralla ja sen pohjaan teipattu avain tipahtaa lattialle");

        //Luodaan oven ominaisuudet ja lisätään se huoneeseen
        ovi.asetaMuodot("ovella","ovea");
        ovi.asetaKatsoKuvaus("Ovi on teräksinen ja erittäin jykevä. Sen murtamista on turha yrittää. Ovi on lukossa, mutta ruosteisessa lukkopesässä on avaimenreikä, josta näkyy himmeästi valaistuun tilaan.");
        huone.lisaaEsine(ovi);
        ovi.setOikeaKayttoEsine(tiirikka);
        ovi.setOikeaKayttoKomento("avaa");
        ovi.setOikeaKayttoTeksti("Muistelet näkemääsi elokuvaa, jossa sankari avaa oven tiirikalla. Tovin sorkittuasi kuulet klikkauksen ja lukko aukeaa!");
        ovi.lisaaSisalto(new Esine(""));

        //Luodaan rasian ominaisuudet ja lisätään se huoneeseen
        rasia.asetaKatsoKuvaus("Kädessäsi on metallinen rasia, joka on lukittu. Heiluttaessa rasia kolisee...");
        rasia.asetaMuodot("rasialla","rasiaa");
        huone.lisaaEsine(rasia);
        rasia.setOikeaKayttoEsine(avain);
        rasia.setOikeaKayttoKomento("avaa");
        rasia.setOikeaKayttoTeksti("Avain sopii rasiaan! Avaat rasian ja löydät sen sisältä erikoisen näköisen esineen. Voisikohan tämä olla tiirikka?");
        //Lisätään esineissä olevat toiset esineet
        vasara.asetaMuodot("vasaralla","vasaraa");
        vasara.asetaKatsoKuvaus("Vasara on vanha ja siinä on hieman ruostetta. Puinen varsi tuntuu kuitenkin tarpeeksi vahvalta, jotta vasaraa voi käyttää.");
        avain.asetaMuodot("avaimella","avainta");
        avain.asetaKatsoKuvaus("Avain on metallinen ja muihin huoneen esineisiin verrattuna uuden näköinen.");
        tiirikka.asetaMuodot("tiirikalla","tiirikkaa");
        tiirikka.asetaKatsoKuvaus("Tämä taitaa olla tiirikka. Mitenhän tätä käytetään..?");
        //Lisätään patjan sisältö
        patja.lisaaSisalto(vasara);
        //Lisätään pöydän sisältö
        poyta.lisaaSisalto(avain);
        //Lisätään rasian sisältö
        rasia.lisaaSisalto(tiirikka);


    }

    private Esine sovita(String esineString, List<Esine> esineLista) {
        for (Esine e : esineLista) {
            if (e.getMuodot().contains(esineString)) {
                return e;
            }
        }
        return null;
    }

    public void lueKomento() {
        // Otetaan käyttäjältä komento ja muutetaan se pieniksi kirjaimiksi
        Scanner lukija = new Scanner(System.in);
        String rivi=lukija.nextLine();
        rivi =rivi.toLowerCase();
        String[] komento = rivi.split("\\s+");
//        for (int i = 0; i < komento.length; i++) {
//            if (i<riviPaloina.length) {
//                komento[i] = riviPaloina[i];
//            } else {
//                komento[i] = null;
//            }
//        }

        //komento = jarjestaKomento(komento);


        /* Esineet, joihin pelaaja voi vaikuttaa */
        List<Esine> esineet = pelaaja.getHuone().getEsineet();
        esineet.addAll(pelaaja.getEsineet());

        /* parsitaan komennosta toiminta. Komento on 1-3 sanaa.
         * Ensimmäinen on käskysana, toinen on kohde-esine, kolmas apuesine
          * esim. "nosta patjaa kepillä" */

        /* jos komento on tyhjä, pelaaja ei ole antanut komentoa */
        if (komento.length==0) {
            System.out.println("Mitä haluat tehdä?");
            return;
        }

        /* jos komennon pituus on 1, hyväksyttyjä komentoja on
        "luovuta" ja "katso"  */

        if (komento.length==1) {
            if (komento[0].equals("luovuta")) {
                System.out.println("Elämänhalusi valuu lattialle, et jaksa enempää. Jäät lattialle makaamaan, kunnes seuraava seikkalija löytää mätänevän ruumiisi...");
                System.exit(0);
            }
            if (komento[0].equals("katso")) {
                System.out.println(pelaaja.getHuone().getKuvaus());
                return;
            }

            System.out.println("En ymmärrä komentoa");
        }

        /* jos komennon pituus on 2, komento voi olla "katso" tai
        jokin käyttökomento.
         */

        if (komento.length == 2) {
            if (komento[0].equals("katso")) {
                Esine katsottava = sovita(komento[1], esineet);
                if (katsottava == null) {
                    System.out.println(pelaaja.getHuone().getKuvaus());
                } else {
                    System.out.println(katsottava.haeKuvaus());
                }
            } else {
                Esine valine = sovita(komento[1], esineet);
                Esine paluuarvo = valine.kayta(komento[0], null);
                if (paluuarvo == null) {
                    System.out.println("DEBUG: return null");
                    System.out.println("Et voi tehdä niin");
                } else {
                    System.out.println(valine.getOikeaKayttoTeksti());
                    pelaaja.lisaaEsine(paluuarvo);
                }
            }
            return;
        }

        if (komento.length== 3) {
            Esine valine = sovita(komento[1], esineet);
            Esine apuValine = sovita(komento[2], esineet);
            Esine paluuarvo = valine.kayta(komento[0], apuValine);
            if (paluuarvo == null) {
                System.out.println("Et voi tehdä niin");
            } else {
                System.out.println(valine.getOikeaKayttoTeksti());
                pelaaja.lisaaEsine(paluuarvo);
            }
            return;
        }
    }

//    public boolean onkoApuvaline (String komento) { // onko komennon sana apuobjekti/apuväline
//
//        if (komento.substring(komento.length() - 3).equals("lla")) {
//            return true;
//        } else if (komento.substring(komento.length() - 3).equals("llä")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public String[] jarjestaKomento (String[] kayttajanSanat) {
//        String[] uusikomento = new String[3];
//        for (String sana : kayttajanSanat) {
//            if (komennot.contains(sana)) {
//                uusikomento[0] = sana;
//            } else if (onkoApuvaline(sana)) {
//                uusikomento[2] = sana;
//            } else {
//                uusikomento[1] = sana;
//            }
//        }
//        return uusikomento;
//    }

}
