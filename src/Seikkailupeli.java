import java.util.*;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {
    Huone huone;
    Seikkailija pelaaja;
    Set<String> komennot;

    public Seikkailupeli() {
        alustaSeikkailu();
        tulostaTervetuloa();
    }

    public void tulostaTervetuloa() {
        String nimi = "Seikkailija";
        System.out.println("Hei " + nimi + "! Peli alkaa. Heräät pimeästä huoneesta, josta sinun on päästävä ulos, jotta peli loppuu. \nVoit katsoa ympärillesi, ottaa esineitä käteesi ja tehdä niillä asioita. Loput sinun on selvitettävä itse. Onnea peliin!");
        System.out.println("\nMitä teet?");
    }

    public void alustaSeikkailu() {
        //Julistetaan käytettävät komennot
        komennot = new HashSet<>();
        komennot.add("katso");
        komennot.add("nosta");
        komennot.add("luovuta");

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

    public void lueKomento() {
        // Otetaan käyttäjältä komento ja muutetaan se pieniksi kirjaimiksi
        Scanner lukija = new Scanner(System.in);
        String rivi=lukija.nextLine();
        rivi =rivi.toLowerCase();
        String[] riviPaloina = rivi.split("\\s+");
        String[] komento = new String[3];
        for (int i = 0; i < komento.length; i++) {
            if (i<riviPaloina.length) {
                komento[i] = riviPaloina[i];
            } else {
                komento[i] = null;
            }
        }

        komento = jarjestaKomento(komento);


        /* Esineet, joihin pelaaja voi vaikuttaa */
        List<Esine> esineet = pelaaja.getHuone().getEsineet();
        esineet.addAll(pelaaja.getEsineet());

        /* parsitaan komennosta toiminta */
        if (komento[0] == null) {
            System.out.println("Mitä haluat tehdä?");
            return;
        }

        if (komento[0].equals("luovuta")) {
            System.out.println("Kiitos pelaamisesta!");
            System.exit(0);
        }

        /* "katso" toimii ilman argumentteja tai yhdellä argumentilla */
        if(komento[0].equals("katso")){
            if (komento.length==1) {
                System.out.println(pelaaja.getHuone().getKuvaus());
                return;
            }
            Esine katsottava = sovita(komento[1], esineet);
            if (katsottava == null) {
                System.out.println(pelaaja.getHuone().getKuvaus());
            } else {
                System.out.println(katsottava.haeKuvaus());
            }
            return;
        }

        /* Vain "katso" kelpaa ilman argumentteja */
        if (komento.length<2) {
            System.out.println("Epäselvä komento");
            return;
        }

        /* muut toiminnat ovat geneerisiä: lyö - pöytää - vasaralla */
        Esine valine = sovita(komento[1], esineet);
        Esine apuvaline = null;
        if (komento.length ==3) {
            apuvaline = sovita(komento[2], esineet);
        }
        Esine paluuarvo = valine.kayta(komento[0], apuvaline);
        if (paluuarvo == null) {
            System.out.println("Et voi tehdä niin");
        } else {
            System.out.println(valine.getOikeaKayttoTeksti());
            pelaaja.lisaaEsine(valine);
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

    public String[] jarjestaKomento (String[] kayttajanSanat) {
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
