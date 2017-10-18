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
        inventaario.add(esine);
        System.out.println("DEBUG: inventaario: ");
        for (Esine e : inventaario) System.out.print(e + " ");
        System.out.println();

    }
}


