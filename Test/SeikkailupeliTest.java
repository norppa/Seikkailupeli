import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 18/10/2017.
 */
public class SeikkailupeliTest {
    Seikkailija s;
    Seikkailupeli p;

    @Before
    public void setUp() {
        s = new Seikkailija();
        p = new Seikkailupeli();
    }

    @Test
    public void uusiSeikkailupeliOnMoodissaPeliJatkuu() {
        assertTrue(p.jatkuuko());
    }

    @Test
    public void lopetaPeliLopettaaPelin() {
        p.lopetaPeli();
        assertFalse(p.jatkuuko());
    }

}