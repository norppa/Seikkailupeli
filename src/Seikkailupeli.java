import java.util.*;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {
    Huone huone;
    Seikkailija pelaaja;
    Set<String> komennot;

    public Seikkailupeli() {
        alustaMetodi();
        tulostaTervetuloa();
    }

    public void tulostaTervetuloa() {
        String nimi = "Seikkailija";
        System.out.println("Hei " + nimi + "! Peli alkaa. Heräät pimeästä huoneesta, josta sinun on päästävä ulos, jotta peli loppuu. \nVoit katsoa ympärillesi, ottaa esineitä käteesi ja tehdä niillä asioita. Loput sinun on selvitettävä itse. Onnea peliin!");
        System.out.println("\nMitä teet?");
    }

    public void alustaMetodi() {
        //Luodaan huone, sen kuvaus ja huoneen sisältö.
        huone = new Huone();
        huone.asetaKuvaus("Huoneessa on patja ja pöytä. Huoneessa on ovi.");

        //Luodaan pelaaja ja asetetaan hänet huoneeseen.
        pelaaja = new Seikkailija();
        pelaaja.setHuone(huone);

        //Luodaan esineet huoneeseen
        Esine patja = new Esine("patja");
        patja.asetaKatsoKuvaus("Kusenkeltainen patja on niin likainen, että sinua hieman puistattaa, kun tajuat nukkuneesi siinä. Näyttää siltä, että patjan alla on jotain.");
        patja.lisaaTaivutusmuodot("patja", "patjaa");
        Esine poyta = new Esine("pöytä");
        poyta.asetaKatsoKuvaus("Huoneen ainoa huonekalu on puinen antiikkipöytä. Pöydällä on rasia.");
        poyta.lisaaTaivutusmuodot("pöytä", "pöytää");
        Esine ovi = new Esine("ovi");
        ovi.lisaaTaivutusmuodot("ovi", "ovea");
        ovi.asetaKatsoKuvaus("Ovi on teräksinen ja erittäin jykevä. Sen murtamista on turha yrittää. Ovi on lukossa, mutta ruosteisessa lukkopesässä on avaimenreikä, josta näkyy himmeästi valaistuun tilaan.");
        Esine rasia = new Esine("rasia");
        rasia.asetaKatsoKuvaus("Kädessäsi on metallinen rasia, joka on lukittu. Heiluttaessa rasia kolisee...");
        rasia.lisaaTaivutusmuodot("rasia", "rasiaa");

        // Lisätään huoneeseen esineet
        huone.lisaaEsine(patja);
        huone.lisaaEsine(poyta);
        huone.lisaaEsine(rasia);
        huone.lisaaEsine(ovi);


        //Lisätään esineissä olevat toiset esineet
        Esine vasara = new Esine("vasara");
        vasara.lisaaTaivutusmuodot("vasara", "vasaraa");
        vasara.asetaKatsoKuvaus("Vasara on vanha ja siinä on hieman ruostetta. Puinen varsi tuntuu kuitenkin tarpeeksi vahvalta, jotta vasaraa voi käyttää.");
        Esine avain = new Esine("avain");
        avain.lisaaTaivutusmuodot("avain", "avainta");
        avain.asetaKatsoKuvaus("Avain on metallinen ja muihin huoneen esineisiin verrattuna uuden näköinen.");
        Esine tiirikka = new Esine("tiirikka");
        tiirikka.lisaaTaivutusmuodot("tiirikka", "tiirikkaa");
        tiirikka.asetaKatsoKuvaus("Tämä taitaa olla tiirikka. Mitenhän tätä käytetään..?");

        //Lisätään patjan sisältö
        patja.lisaaSisalto(vasara);

        //Lisätään pöydän sisältö
        poyta.lisaaSisalto(avain);

        //Lisätään rasian sisältö
        rasia.lisaaSisalto(tiirikka);

        //Asetetaan huoneessa olevien esineiden kuvaukset

        Map<Esine, String> patjanKayttoKuvaukset = new HashMap<>();
        patjanKayttoKuvaukset.put(patja, "Et voi käyttää patjaa patjaan.");
        patjanKayttoKuvaukset.put(avain, "Yrität avata patjan avaimella, mutta et löydä avaimenreikää.");
        patjanKayttoKuvaukset.put(tiirikka, "Yrität avata patjan tiirikalla, mutta et löydä avaimenreikää.");
        patjanKayttoKuvaukset.put(vasara, "Turhaan hakkaat patjaa vasaralla, se ei hyödytä sinua mitenkään.");
        patjanKayttoKuvaukset.put(poyta, "Pöytä on liian painava, et jaksa nostaa sitä.");
        patja.asetaKayttoKuvaukset(patjanKayttoKuvaukset);

        Map<Esine, String> poydanKayttoKuvaukset = new HashMap<>();
        poydanKayttoKuvaukset.put(patja, "Tyhmä idea, kokeile jotain muuta.");
        poydanKayttoKuvaukset.put(avain, "Yrität avata pöydän avaimella, mutta et löydä avaimenreikää.");
        poydanKayttoKuvaukset.put(tiirikka, "Yrität avata pöydän tiirikalla, mutta et löydä avaimenreikää.");
        poydanKayttoKuvaukset.put(vasara, "Löit pöytää vasaralla, ja sait pienen avaimen käyttöösi.");
        poydanKayttoKuvaukset.put(poyta, "Et voi käyttää pöytää pöytään.");
        poyta.asetaKayttoKuvaukset(poydanKayttoKuvaukset);

        Map<Esine, String> rasianKayttoKuvaukset = new HashMap<>();
        rasianKayttoKuvaukset.put(patja, "Tyhmä idea, kokeile jotain muuta.");
        rasianKayttoKuvaukset.put(avain, "Rasia aukesi. Löysit sisältä toisen avaimen.");
        rasianKayttoKuvaukset.put(tiirikka, "Rasia on jo auki.");
        rasianKayttoKuvaukset.put(vasara, "Mitään ei tapahdu.");
        rasianKayttoKuvaukset.put(poyta, "Pöytä on liian painava, et jaksa nostaa sitä.");
        rasia.asetaKayttoKuvaukset(rasianKayttoKuvaukset);

        Map<Esine, String> ovenKayttoKuvaukset = new HashMap<>();
        ovenKayttoKuvaukset.put(patja, "Tyhmä idea, kokeile jotain muuta.");
        ovenKayttoKuvaukset.put(avain, "Avain ei sovi lukkoon. Kokeile avainta toiseen paikkaan.");
        ovenKayttoKuvaukset.put(tiirikka, "Oven lukko raksahtaa auki.");
        ovenKayttoKuvaukset.put(vasara, "Mitään ei tapahdu.");
        ovenKayttoKuvaukset.put(poyta, "Pöytä on liian painava, et jaksa nostaa sitä.");
        ovi.asetaKayttoKuvaukset(ovenKayttoKuvaukset);
    }

    private Esine sovita(String esineString, List<Esine> esineLista) {
        for (Esine e : esineLista) {
            if (e.getTaivutusmuodot().contains(esineString)) {
                return e;
            }
        }
        return null;
    }

    public boolean lueKomento() {
        // Otetaan käyttäjältä komento ja muutetaan se pieniksi kirjaimiksi
        Scanner lukija = new Scanner(System.in);
        String rivi=lukija.nextLine();
        rivi =rivi.toLowerCase();
        String[] komento = rivi.split("\\s+");

        /* Esineet, joihin pelaaja voi vaikuttaa */
        List<Esine> esineet = pelaaja.getHuone().getEsineet();
        esineet.addAll(pelaaja.getEsineet());

        // Katsotaan sisältääkö käyttäjän teksti jonkun komennon:
        if(komento[0].contains("katso")){
            Esine katsottava = sovita(komento[1], esineet);
            if (katsottava == null) {
                System.out.println(pelaaja.getHuone().getKuvaus());
            } else {
                System.out.println(katsottava.haeKuvaus());
            }
        } else if (komento[0].contains("nosta")) {
            Esine nostettava = sovita(komento[1], esineet);
            patja.kayta(kayttoOlio);

        } else if (komento[0].equals("luovuta") && komento[1].equals("peli")) {
            System.out.println("Kiitos pelaamisesta!");
            System.exit(0);
        }
        else {
            System.out.println("En ymmärrä komentoa");
        }
        return true;
    }

}
