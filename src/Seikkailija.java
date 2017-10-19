import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailija {
    private Huone lokaatio;
    private List<Esine> inventaario;

    public Seikkailija() {
        inventaario = new ArrayList<>();
    }

    public void setHuone(Huone huone) {
        lokaatio = huone;
    }

    public Huone getHuone() {
        return lokaatio;
    }

    public List<Esine> getEsineet() {
        return inventaario;
    }

    public void lisaaEsine(Esine esine) {
        if (inventaario.contains(esine)) {
            System.out.println("Sait Deja vu -kokemuksen, ja luulet saavasi uudelleen äsken löytämäsi esineen, mutta ethän sinä voi uudelleen löytää \n" +
                    "samaa esinettä. Oletkohan tulossa pikkuhiljaa hulluksi..?");
            return;
        }
        if (esine == null || esine.equals(new Esine())) return;
        inventaario.add(esine);
    }
    public void Inventaario() {

        if (inventaario.isEmpty()) {
            System.out.println("Et ole vielä löytänyt käytettäviä esineitä. Etsi tarkemmin.");
        } else {
            System.out.println("Sinulla on käytössäsi:  ");
            for (Esine e : inventaario) System.out.print(e + " ");
            System.out.println();
        }


    }
}


