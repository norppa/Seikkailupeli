import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 18/10/2017.
 */
public class SeikkailijaTest {

    Seikkailija s;

    @Before
    public void setUp() {
        s = new Seikkailija();
    }

    @Test
    public void uudenSeikkailijanGetEsineetPalauttaaTyhjanListan() {
        assertTrue(s.getEsineet().isEmpty());
    }

    @Test
    public void uusienEsineidenLisaaminenKasvattaaListanKokoa() {
        s.lisaaEsine(new Esine("1"));
        s.lisaaEsine(new Esine("2"));
        assertEquals(2, s.getEsineet().size());
    }

    @Test
    public void lisattyEsineOnListalla() {
        Esine e = new Esine("1");
        s.lisaaEsine(e);
        assertTrue(s.getEsineet().contains(e));
    }
}