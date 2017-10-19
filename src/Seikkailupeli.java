import java.util.*;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {
    Huone huone, huone2;
    Seikkailija pelaaja;
    private boolean jatkuuko;
    private Set<String> komennot;
    Scanner scanner;


    // Null ei kelpaa avaimeksi
    Esine nul = new Esine();

    public Seikkailupeli() {
        scanner = new Scanner(System.in);
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
        String tervehdysteksti;
        switch (nimi.toLowerCase()) {
            case "pia":
                tervehdysteksti = "Hei Pia. Sinäkin osaat pelin kiemurat varmasti ulkoa, kun olet testin toimivuutta testannut niin yksin," +
                        "\nkuin ulkopuolisen testaajan kanssa. Toivottavasti et tässä vaiheessa enää löydä pelistä virheitä, kun peli on jo julkaistu.";
                break;
            case "jari":
                tervehdysteksti = "Hei Jari. Oletan, että sinä tiedät tästä pelistä jokaisen toiminnon jo etukäteen, " +
                        "\njoten voisit luovuttaa pelivuorosi jollekulle muulle.";
                break;
            case "tuukka":
                tervehdysteksti = "Hei Tuukka. Kannattaakohan sinun harkita uudelleen tämän pelin pelaamista? Voit toki pyytää apua vierustovereiltasi," +
                        "\njos ensimmäisen vaiheen läpipääsy turhauttaa.";
                break;
            case "riina":
                tervehdysteksti = "Hei Riina. Sinä olet kyllä pelannut pelin jo niin monta kertaa läpi, että kannattaako enää? Anna jonkun muun yrittää.";
                break;
            case "samu":
                tervehdysteksti = "Hei Samu. Sinun ansiostasi tämä peli on edes olemassa, kun opetit meille GIT:in käyttöä." +
                        "\nKiitokseksi siitä saat pelata peliä niin monta kertaa kuin haluat.";
                break;
            case "tommi":
                tervehdysteksti = "Hei Tommi. Oletettavasti pidät pelistämme, vaikka olisit itse tehnyt samanlaisen pelin varmaan noin viidessä minuutissa." +
                        "\nYritimme kuitenkin parhaamme taitotasoomme nähden :)";
                break;
            case "jake":
                tervehdysteksti = "Hei Jake. Tässä pelissä ei sallita voimasanoja, ja toivomme, että komennat kiltisti Seikkailijaa.";
                break;
            case "hennileena":
                tervehdysteksti = "Hei Hentsu. Vaikka olet kilpailevassa ryhmässä, annamme sinullekin mahdollisuuden pelata hienoa peliämme." +
                        "\nToivottavasti et pahoita mieltäsi, jos koet meidän pelin paremmaksi.";
                break;
            case "pekka":
                tervehdysteksti = "Hei Pekka. Tämä peli on melko lapsiystävällinen peli, joten voit myös antaa lapsesi pelata tätä peliä huoletta," +
                        "\nkunhan autat lastasi hädän iskiessä.";
                break;
            case "maiju":
                tervehdysteksti = "Hei Maiju. Toivomme, että pelaat peliämme, vaikka oletkin pyrkinyt koodaamaan samankaltaista peliä." +
                        "\nKatsotaan, kumpi ryhmä pääsee pelillään viereiseen taloon töihin, vai näemmekö kaikki siellä ;)";
                break;
            case "minna":
                tervehdysteksti = "Hei Minna. Emme valitettavasti saaneet vielä koodattua lautapeliä, mutta toivomme, että tämä peli viihdyttää myös sinua.";
                break;
            case "josefin":
                tervehdysteksti = "Hei Josefin. Toivomme syvästi, että olemme neljässä viikossa oppineet koodaamaan yhtä hienon (tai jopa hienomman) pelin," +
                        "\nkuin teille opetettiin yliopistossa. :)";
                break;
            case "kristiina":
                tervehdysteksti = "Hei Kristiina. Toivomme, että hyväksyt äidinkielen tason pelissämme, etkä tuomitse liikaa mahdollisia kirjoitusvirheitä. " +
                        "\nKirjoitusvirheet on tarkastettu, eikä niitä pitäisi olla enääN.";
                break;
            case "ville":
                tervehdysteksti = "Hei Ville. Näimme sinun vilkuilevan meidän pöytäämme päin hieman kateellisen oloisena toivoen, " +
                        "\nettä olisit osa meidän ryhmää. Ei huolta, pääset nyt pelaamaan aikaansaamaamme peliä.";
                break;
            case "mika":
                tervehdysteksti = "Hei Mika. Sinulla ei ollut vieläkään mainittuna minkäänlaista salaista taitoa." +
                        "\nVoisit pelata tätä peliä niin monta kertaa, että sen läpipääsystä tulee sinulle 'salainen taito'.";
                break;
            case "sonja":
                tervehdysteksti = "Hei Sonja. Valitettavasti olet valinnut väärän pelin, ja pyydämme sinua lopettamaan pelin, " +
                        "\nennen kuin huomaat harmiksesi, että siinä ei ole yhtäkään Hello Kitty -hahmoa.";
                break;
            case "kalle":
                tervehdysteksti = "Hei Kalle. Vaikka tämä peli on seikkailupeli, ei siinä (toistaiseksi) ole mitään jääkiekkoon liittyvää." +
                        "\nToivottavasti silti jatkat pelin pelaamista.";
                break;
            case "katja":
                tervehdysteksti = "Hei Katja. Sinähän olet koodannut Pythonia, joten voisit ottaa seuraavaksi haasteeksesi " +
                        "\nkoodata samanlainen (tai parempi) peli Pythonilla.";
                break;
            case "anna-reetta":
                tervehdysteksti = "Hei Anna-Reetta. Voit muistella menneitä ja kuvitella tämän pelin lokaation olevan esimerkiksi Riossa tai New Yorkissa," +
                        "\nkoska emme ole määrittäneet pelin sijaintia sen tarkemmin, joten pelaaja saa käyttää vapaasti mielikuvitustaan.";
                break;
            case "risto":
                tervehdysteksti = "Hei Risto. Toivomme, että pidät pelistämme, ja valikoit sen yhdeksi suosikkipeliksesi " +
                        "\nmuiden (x määrän) pelaamisiesi pelien rinnalle.";
                break;
            case "antti":
                tervehdysteksti = "Hei Antti. Mukavaa, että sinäkin päätit pelata peliämme. Voit halutessasi antaa meille kehitysideoita," +
                        "\nmutta emme ota vastaan ideoita, jotka liittyvät siihen, että peliä pitäisi saada ohjattua esimerkiksi silmän liikkeillä.";
                break;
            case "titta":
                tervehdysteksti = "Hei Titta. Tässä sinullekin uusi peli, jota voit vaikka pelata koko viikonlopun samalla," +
                        "\nkun katsot Black Mirroria (jos et ole vielä sitä tehnyt), ja syöt irtokarkkeja Halloween-aiheisesta karkkipussista.";
                break;
            default:
                tervehdysteksti = "Hei " + nimi + "! Tervetuloa kaikkien aikojen seikkailuun!";
        }
        System.out.println(tervehdysteksti);
        System.out.println();
        System.out.println("Aloitetaan seikkailu! Heräät pimeästä huoneesta, josta sinun on päästävä ulos, jotta peli loppuu. \nVoit katsoa ympärillesi ja käyttää löytämisiä esineitä. Loput sinun on selvitettävä itse. Onnea peliin!");
        System.out.println("\nKäske seikkailijaa tekemään jotain.");
    }

    public void tulostaLopetus() {
        System.out.println("Ovi aukeaa ja raitis ulkoilma virtaa kasvoillesi. Onnen kyyneleet valuvat poskiasi pitkin, kun tajuat,\n" +
                "että kurjan elämäsi viimeiset hetket eivät olleet tunkkaisessa pakohuoneessa.");

        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMmdmNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMh:----:+yNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMM/--------/NMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMd---------sMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMo--------oMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMN/------:sMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMh-----:/hMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMs----://hMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMM/-----:/yMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMM:-----:/yMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMN------:/omMMNNNNNmyssssydNMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMm--------:+mmmdhyso-------/mMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMd+----------/+mN+//:---------/NMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMNs------------:/oMh///--------:/NMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMN+-------------://mNo++/+oshddddydMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMo--------------///dMMNmhys+/:----:NMMMMMMMMM\n" +
                "MMMMMMMMNNmmmmMh--------------:///mNo//:----------mMMMMMMMMM\n" +
                "MMMMmo/:-----/m+--------------///sMh////--------:hMMMMMMMMMM\n" +
                "MMMMh--------:/--------------///+NMs///:-:/+oyhddNMMMMMMMMMM\n" +
                "MMMMh--------:/------------:///+mMNmmdddddhyo+:--dMMMMMMMMMM\n" +
                "MMMMh---------/----------:////sNms////----------/NMMMMMMMMMM\n" +
                "MMMMh----------------::///////mNo+//:----------oNMMMMMMMMMMM\n" +
                "MMMMh---------------------////+dNmmdhyyso++/oymMMMMMMMMMMMMM\n" +
                "MMMMh----------------------////Nh///:/+oosymMMMMMMMMMMMMMMMM\n" +
                "MMMMd:-----------:hd+-------///yNs+/:::://+mMMMMMMMMMMMMMMMM\n" +
                "MMMMd///::--:::////yNmyo+/:::///ohmmdhhyhdNMMMMMMMMMMMMMMMMM\n" +
                "MMMMd////++oosyhdmNMMMMMMMMMMNNNNMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    }

    public void alustaSeikkailu() {


        // Käytettävissä olevat komennot
        komennot = new HashSet<>();
        komennot.add("katso");
        komennot.add("avaa");
        komennot.add("lyö");
        komennot.add("nosta");
        komennot.add("paina");
        komennot.add("inventaario");
        komennot.add("apua");
        komennot.add("luovuta");

        /***   LUODAAN PELISSÄ KÄYTETTÄVÄT HUONEET   ***/
        huone = new Huone();
        huone.asetaKuvaus("Huone, jossa olet, on hämärä ja tunkkainen. Hajusta päätellen täällä ei ole \n" +
                "siivottu vuosikausiin. Huoneen nurkassa lojuu nuhjuinen patja, jolta juuri heräsit. Viereisellä \n" +
                "seinustalla on puinen pöytä, jolla näyttää olevevan rasia. Yhdellä seinällä on ovi. Huoneen \n" +
                "lattia ja katto ovat harmaata betonia ja seiniä peittää tapetti, joka on joskus ollut \n" +
                "räikeän värinen, mutta on nykyään repeytynyt, tahriintunut ja kellastunut. \n" +
                "Katossa roikkuva lamppu luo kellertävää valoa ja välkkyy satunnaisesti.");


        huone2 = new Huone();

        String huoneenKaksiKuvaus = "Tämän huoneen seinät ovat rosoista punaista tiiltä.\n" +
                "Laasti on ajan tummentamaa, mutta edelleen vankan näköistä.\n" +
                "Myös huoneen lattia ja katto ovat samaa materiaalia, mikä tekee huoneesta\n" +
                "ahdistavan oloisen. Ainoat huoneessa olevat esineet ovat\n" +
                "kokovartalopeili ja potrettimaalaus, jotka ovat aseteltu huoneen\n" +
                "vastakkaisille seinille. Aivan kuin potretin henkilö katsoisi itseään peilistä.\n" +
                "Sinua vastapäisellä seinällä on ovi, jossa näyttäisi olevan sormenjälkitunnistin\n" +
                "Huoneessa ei ole näkyvää valonlähdettä, mutta silti huone ei ole pimeä.\n" +
                "Valaistus väreilee hieman, aivan kuin valo tulisi lepattavista kynttilöistä." ;
        huone2.asetaKuvaus(huoneenKaksiKuvaus);



        //Luodaan pelaaja ja asetetaan hänet huoneeseen.
        pelaaja = new Seikkailija();
        pelaaja.setHuone(huone);


        /***   LUODAAN HUONEEN 1 SISÄLTÖ   ***/

        //luodaan huoneen 1 esineet:
        Esine patja = new Esine("patja");
        patja.asetaKatsoKuvaus("Kusenkeltainen patja on niin likainen, että sinua hieman puistattaa, kun tajuat \n" +
                "nukkuneesi siinä. Näyttää siltä, että patjan alla on jotain.");
        patja.asetaMuodot("patjalla", "patjaa");

        Esine poyta = new Esine("pöytä");
        poyta.asetaKatsoKuvaus("Huoneen ainoa huonekalu on puinen antiikkipöytä. Pöydällä on rasia.");
        poyta.asetaMuodot("pöydällä", "pöytää");

        Esine ovi = new Ovi("ovi", huone2, pelaaja);
        ovi.asetaKatsoKuvaus("Ovi on teräksinen ja erittäin jykevä. Sen murtamista on turha yrittää. Ovi on lukossa, \n" +
                "mutta ruosteisessa lukkopesässä on avaimenreikä, josta näkyy himmeästi valaistuun tilaan.");
        ovi.asetaMuodot("ovella", "ovea");

        Esine vasara = new Esine("vasara");
        vasara.asetaMuodot("vasaralla", "vasaraa");
        vasara.asetaKatsoKuvaus("Vasara on vanha ja siinä on hieman ruostetta. Puinen varsi tuntuu kuitenkin tarpeeksi vahvalta, jotta vasaraa voi käyttää.");

        Esine avain = new Esine("avain");
        avain.asetaMuodot("avaimella", "avainta");
        avain.asetaKatsoKuvaus("Avain on metallinen ja muihin huoneen esineisiin verrattuna uuden näköinen.");

        Esine tiirikka = new Esine("tiirikka");
        tiirikka.asetaMuodot("tiirikalla", "tiirikkaa");
        tiirikka.asetaKatsoKuvaus("Tämä taitaa olla tiirikka. Mitenhän tätä käytetään..?");

        Esine rasia = new Esine("rasia");
        rasia.asetaKatsoKuvaus("Kädessäsi on metallinen rasia, joka on lukittu. Heiluttaessa rasia kolisee... Onkohan sisällä jotain?");
        rasia.asetaMuodot("rasialla", "rasiaa");

        // Lisätään esineille oikeat käyttötava
        patja.setOikeaKaytto("nosta", nul, "Nostat patjaa ja sen alta paljastuu vasara. Otat vasaran mukaasi.");
        poyta.setOikeaKaytto("lyö", vasara, "Lyöt pöytää vasaralla ja sen pohjaan teipattu avain \n" +
                "tipahtaa lattialle. Kyykistyt lattialle ja noukit avaimen käteesi.");

        ovi.setOikeaKaytto("avaa", tiirikka, "Muistelet näkemääsi elokuvaa, jossa " +
                "sankari avaa oven tiirikalla. \nTovin sorkittuasi kuulet klikkauksen ja lukko aukeaa! " +
                "Siirryt seuraavaan huoneeseen.");

        rasia.setOikeaKaytto("avaa", avain, "Avain sopii rasiaan! Avaat rasian ja löydät sen sisältä erikoisen näköisen esineen. Voisikohan tämä olla tiirikka? Nappaat tiirikan mukaasi.");


        // Lisätään esineille sisällöt, jos tarpeen
        patja.lisaaSisalto(vasara);
        poyta.lisaaSisalto(avain);
        rasia.lisaaSisalto(tiirikka);
        ovi.lisaaSisalto(new Esine(""));

        // Lisätään huoneeseen esineet, joihin pelaaja voi koskea

        huone.lisaaEsine(patja);
        huone.lisaaEsine(poyta);
        huone.lisaaEsine(ovi);
        huone.lisaaEsine(rasia);

        // Lisätään käyttökuvauksia vääriin tapoihin käyttää asioita
        ovi.asetaKayttoKuvaus("avaa", avain, "Avain ei sovi lukkoon");
        ovi.asetaKayttoKuvaus("lyö", vasara, "Mitään ei tapahdu.");
        ovi.asetaKayttoKuvaus("nosta", poyta, "Pöytä on liian painava, et jaksa nostaa sitä.");
        ovi.asetaKayttoKuvaus("paina", tiirikka, "Kokeile tehdä jotain muuta, kuin painaa");
        ovi.asetaKayttoKuvaus("lyö", tiirikka, "Lopeta! Tiirikkasi menee pian rikki.");
        patja.asetaKayttoKuvaus("lyö", vasara, "Patjaan tulee reikä. Mene purkamaan aggressioitasi muualle.");
        poyta.asetaKayttoKuvaus("avaa", avain, "Yrität avata pöydän avaimella, mutta et löydä avaimenreikää.");
        rasia.asetaKayttoKuvaus("lyö", vasara, "Rasia kestää iskusi. Kokeile jotakin muuta.");
        rasia.asetaKayttoKuvaus("avaa", tiirikka, "Rasia on jo auki, älä turhaan yritä uudelleen avata sitä!");

        /***   LUODAAN TOISEN HUONEEN SISÄLTÖ   ***/

        // Luodaan esineet

        Esine lappu = new Esine("lappu");
        lappu.asetaKatsoKuvaus("Paperi on vanha ja kellastunut. Lappuun on kirjoitettu\nmustekynällä numerosarja 39 27 15");
        lappu.asetaMuodot("lapulla", "lappua");


        Esine sirpaleet = new Esine("sirpaleet");
        sirpaleet.asetaMuodot("sirpaleilla", "sirpaleita");
        sirpaleet.asetaMuodot("sirpaleella", "sirpaletta");
        sirpaleet.asetaKatsoKuvaus("Peilin sirpaleet heijastavat huoneen lepattavaa valoa luoden kylmältä\n" +
                "tuntuvan kimalluksen. Erityisesti sirpaleiden terävät reunat kimaltava uhkaavasti.\n" +
                " Suurin osa sirpaleista on pieniä, mutta joukossa on muutama suurempikin kappale.\n");


        String huoneenKaksiUusiKuvaus = "Huoneen punatiiliset seinät, lattia ja katto luovat edelleen \n" +
                "painostavan tunnelman, mutta lattialla olevat peilinsirpaleet piristävät tunnelmaa.\n" +
                "Vanha kansa sanoo, että sirpaleet tuovat onnea. Mieleesi juolahtaa, että jos et\n" +
                "muuta keksi, sirpaleilla voi ainakin päättää tämän surkean seikkailun yhdellä\n" +
                "lopullisella tavalla...";
        MuuttuvaEsine peili = new MuuttuvaEsine("peili", huone2, sirpaleet, huoneenKaksiUusiKuvaus);
        peili.asetaMuodot("peilillä", "peiliä");
        peili.asetaKatsoKuvaus("Tämä peili on ihmisen mittainen. Näet siitä itsesi kiirestä kantapäähän.\n" +
                "Peilissä on yksinkertainen puuraami, joka on nähnyt parhaat päivänsä aikaa sitten.\n" +
                "Peilin pinta on likainen ja näet siinä sormen- ja kädenjälkiä. Takanasi oleva maalaus näyttää\n" +
                "tuijottavan sinua peilin kautta.");


        Esine taulu = new Esine("taulu");
        taulu.asetaMuodot("taululla", "taulua");
        taulu.asetaKatsoKuvaus("Seinään kiinnitetty taulu esittää vanhaa voimakaspiirteistä naista.\n" +
                "Hänellä on harmaantuvat " +
                "hiukset sidottuna koristeellisella piikillä nutturaksi. \nHänen ilmeensä on tuima ja vahva, " +
                "ehkä hieman ylpeä. Hänellä on yllään tumma puku ja punainen kravatti. Taulun kehys on\n" +
                "koristeellisesti veistettyä puuta ja koko taulu on paljon paremmassa kunnossa kuin\n" +
                "mikään mitä olet täällä aikaisemmin nänyt.");

        PulmaEsine kassakaappi = new PulmaEsine("kassakaappi",
                "Kassakaappi vaatii tunnusluvun. Minkä tunnusluvun annat?",
                "39 27 15",
                "Tunnusluku on oikea. Kaappi avautuu narahtaen ja sisältä löytyy verinen sormi." +
                        "Otat sormen mukaasi",
                "Tunnusluku on väärä. Kaappi ei avaudu.", scanner);
        kassakaappi.asetaMuodot("kassakaapilla", "kassakaappia");
        kassakaappi.asetaKatsoKuvaus("Kassakaappi on jykevä ja lukittu. Siinä on naarmuja ja lommoja, joten \n" +
                "näyttää siltä että sitä on ennenkin yritetty turhaan avata väkivalloin. Tämä näyttää olevan\n" +
                "numerokoodilla toimiva kassakaappi.");

        Esine sormi = new Esine("sormi");
        sormi.asetaMuodot("sormella", "sormea");
        sormi.asetaKatsoKuvaus("Ihmisen etusormi. Leikattu irti kolmannen nivelen kohdalla ja tähän " +
                "amputaatioon ei ole kirurgia käytetty. \nLuu törröttää tyngän päästä ja sormesta valuva veri " +
                "on vielä juoksevaa.");

        LopetusEsine sormenjälkitunnistin = new LopetusEsine("sormenjälkitunnistin", this);
        sormenjälkitunnistin.asetaMuodot("sormenjälkitunnistimella", "sormenjälkitunnistinta");
        sormenjälkitunnistin.asetaKatsoKuvaus("Tunnistimessa on lasinen levy, jossa on sormenjäljen kuva.");

        // Asetetaan oikat käyttötavat

        peili.setOikeaKaytto("lyö", vasara, "Huitaiset vasaralla peiliä, joka\n" +
                "hajoaa tuhansiksi sirpaleiksi. Ääni on hiljaisessa huoneessa korvia huumaava. Voisit vaikka\n" +
                "vannoa, että juuri ennen vasaran osumista peiliin, taustalla näkyvä maalaus näytti kauhistuneelta.\n" +
                "Kun melu on laantunut ja sirpaleet lojuvat lattialla, havaitset sirpaleiden joukossa paperilapun.\n");

        taulu.setOikeaKaytto("lyö", sirpaleet,
                "Turhautuneena tilanteeseen päätät purkaa ahdistuksesi kuvan naiseen. Tartut \n" +
                        "peilinsirpaleeseen, jonka terävä reuna pureutuu kämmeneesi. Sirpaleen heijastava reuna saa \n" +
                        "veresi kimaltamaan uhkaavasti. Viillät taulua uudestaan ja uudestaan kunnes kuvan naisesta \n" +
                        "ei ole jäljellä kuin muisto. Yllätykseksesi kuvan takaa paljastuu seinässä oleva sisennys, \n" +
                        "johon on upotettu kassakaappi. Rauhoituttuasi hieman havaitset, että taulussa on toisessa \n" +
                        "reunassa saranat, joilla syvennykseen olisi päässyt käsiksi ilman väkivaltaa. Pyyhit verisen \n" +
                        "kätesi likaisten housujesi lahkeeseen.");


        kassakaappi.setOikeaKaytto("avaa", nul, "");

        sormenjälkitunnistin.setOikeaKaytto("paina",sormi, "Sormenjälkitunnistin" +
                "väläyttää sinisen valon verisen sormen alapuolella. Hetken päästä oven lukosta kuuluu " +
                "naksahdus.");

        // Lisätään esineet toistensa sisään

        kassakaappi.lisaaSisalto(sormi);
        peili.lisaaSisalto(lappu);

        // Lisätään esineet huoneeseen

        huone2.lisaaEsine(peili);
        huone2.lisaaEsine(taulu);
        huone2.lisaaEsine(kassakaappi);
        huone2.lisaaEsine(sormenjälkitunnistin);

        // Asetetaan käyttökuvauksia
        taulu.asetaKayttoKuvaus("lyö", vasara, "Taululle ei tapahdu mitään, vaikka hakkaat sitä vasaralla");
        sormenjälkitunnistin.asetaKayttoKuvaus("lyö", vasara, "Miksi hakkaat sormenjälkitunnistinta vasaralla? Ei auta...");
        sormenjälkitunnistin.asetaKayttoKuvaus("lyö", sirpaleet, "Sirpaleet aiheuttavat syviä verta vuotavia haavoja käsiisi, mutta sormenjälkitunnistin ei mene rikki eikä ovi aukea...");
        sormenjälkitunnistin.asetaKayttoKuvaus("avaa", tiirikka, "Tiirikka ei toimi tähän tarkoitukseen, mitäköhän sormenjälkitunnisimeen kannattaisia laittaa...?");
        kassakaappi.asetaKayttoKuvaus("lyö", vasara, "Kassakaappi ei hievahdakaan vaikka lyöt sitä vasaralla");
        kassakaappi.asetaKayttoKuvaus("avaa", tiirikka, "Kassakaappi vaatii numerokoodin, typerys...");
        kassakaappi.asetaKayttoKuvaus("avaa", avain, "Kassakaappi vaatii numerokoodin, typerys...");

    }

    private Esine sovita(String esineString, List<Esine> esineLista) {
        for (Esine e : esineLista) {
//            System.out.println("DEBUG: " + e);
            if (e.getMuodot().contains(esineString)) {
                return e;
            }
        }
        return nul;
    }

    public void lueKomento() {

        /* Esineet, joihin pelaaja voi vaikuttaa */
        List<Esine> esineet = new ArrayList<>();
        esineet.addAll(pelaaja.getHuone().getEsineet());
        esineet.addAll(pelaaja.getEsineet());
        // Otetaan käyttäjältä komento ja muutetaan se pieniksi kirjaimiksi
        String rivi = scanner.nextLine();
        rivi = rivi.toLowerCase();

        //debug
        if (rivi.equals("debug")) {
            System.out.println("Huoneen esineet");
            for (Esine e : pelaaja.getHuone().getEsineet()) {
                System.out.println(e);
            }
            System.out.println("-");
            return;
        }
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
            if (komento[0].equals("apua")) {
                System.out.println("Oletko varma, että haluat näyttää haavoittuvaisuutesi ja pyytää apua? Vastaa kyllä tai ei.");
                String vastaus = scanner.nextLine();
                if (vastaus.equals("kyllä")) {
                    System.out.println("Ota yhteyttä Piaan, Jariin, Tuukkaan tai Riinaan. Veloitamme 50 euroa / yhteydenotto.");
                    System.out.println("Kun olet saanut apua, jatka peliä antamalla seuraava käsky.");
                    return;
                } else System.out.println("Jatka peliä normaalisti.");
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
                if (katsottava.equals(nul)) {
                    System.out.println(pelaaja.getHuone().getKuvaus());
                } else {
                    System.out.println(katsottava.haeKuvaus());
                }
            } else {
                Esine valine = sovita(komento[1], esineet);
                Esine paluuarvo = valine.kayta(komento[0], nul);
                if (paluuarvo == nul) {
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
        if (kayttajanSanat.length < 3) return kayttajanSanat;
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