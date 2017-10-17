import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 17/10/2017.
 */
public class Tekstit {
    private ArrayList<String> tekstit;

    public Tekstit(String filename) {
        this.tekstit = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String rivi;
            while ((rivi = reader.readLine()) != null) {
                tekstit.add(rivi);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String haeTeksti(int indeksi) {
        return tekstit.get(indeksi);
    }
}
