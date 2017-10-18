import org.junit.Test;

import static org.junit.Assert.*;

public class HuoneTest {

    Huone h = new Huone();

    @Test
    public void kuvausOnAlussaTyhja() {
        assertNull(h.getKuvaus());
    }

    @Test
    public void alussaEsinelistausTyhja() {
        assertTrue(h.getEsineet().isEmpty());

    }

    @Test
    public void kuvauksenAsettaminenOnnistuu() {
        h.asetaKuvaus("Kuvaus huoneesta");
        assertNotNull(h.getKuvaus());
    }

    @Test
    public void esineidenLisaysOnnistuu() {
        Esine esine = new Esine("esine");
        h.lisaaEsine(esine);
        assertEquals(h.getEsineet().size(), 1);

    }
}