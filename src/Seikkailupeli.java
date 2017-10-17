import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Seikkailupeli {
    public static void main(String[] args) {
        System.out.println("Ei oo kummonen peli vielä");
    }

    Set<String> komennot;

    public Seikkailupeli() {
        komennot = new HashSet<>();
        komennot.add("katso");
        komennot.add("käänny");
    }
}
