import java.util.List;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailija {
    private Huone lokaatio;
    private List<Esine> inventaario;

    public void siirry(Huone uusiHuone) {
        lokaatio = uusiHuone;
    }
}

