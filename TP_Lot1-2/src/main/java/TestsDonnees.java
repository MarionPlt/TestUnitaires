import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestsDonnees extends TestCase {


    public String nodatapass = "..\\src\\main\\nodata.txt";


    @Test
    public void testFileExist() {
        String rightpass = ".\\src\\main\\client.txt";
        List<String[]> test = new ArrayList(Donnees.importFichier(rightpass));
        assertNotNull(test);
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileCatchException() {
        String errorpass = "";
        Donnees.importFichier(errorpass);
    }



}
