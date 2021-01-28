import junit.framework.TestCase;
import org.junit.Test;

import javax.management.Query;
import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

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

    @Test
    public void testIdUnique(){
    }
}
