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

    public void siirry(Huone uusiHuone) {
        lokaatio = uusiHuone;
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
}

