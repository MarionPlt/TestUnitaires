import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TestsDonnees {


    public String nodatapass = "..\\src\\main\\nodata.txt";

    public String randomId() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }


    @Test
    public void testFileExist() {
        String rightpass = ".\\src\\main\\client.txt";
        ArrayList test = new ArrayList(Donnees.importFichier(rightpass));
        Assert.assertNotNull(test);
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileCatchException() {
        String errorpass = "";
        Donnees.importFichier(errorpass);
    }

    @Test
    public void testIdUnique() throws SQLException {
        Client clienttest = new Client(randomId(), "prenomTest", "nomTest", "adresseTest");
        MariaDB database = new MariaDB();
        String queryTest = "SELECT COUNT(*) FROM clientsunit WHERE ID = '" + clienttest.getId() + "'";
        ResultSet resultat = database.talkToDataBase(queryTest);
        resultat.next();
        Assert.assertTrue(resultat.getInt(1) == 0);
    }

    @Test
    public void isNotEmpty() {
        File file = new File("nodata.txt");
        //assertTrue(file.length() == 0);

        Assert.assertEquals(file.length() == 0, file.length() == file.length());
        System.out.println("Erreur fichier vide");
    }

    @Test
    public void badFormat() {

        File file = new File("client.");
        Optional<String> value1 = Optional.of("");
        getExtensionByStringHandling(file.toString());
        Optional<String> value = getExtensionByStringHandling(file.toString());
        Assert.assertEquals(value, value1);
        System.out.println("ERREUR MAUVAIS FORMAT : ATTENDU - .txt");
    }



    @Test
    public void goodFormat() {

        File file = new File("client.txt");
        Optional<String> value1 = Optional.of("txt");
        getExtensionByStringHandling(file.toString());
        Optional<String> value = getExtensionByStringHandling(file.toString());
        Assert.assertEquals(value, value1);
        System.out.println("ERREUR MAUVAIS FORMAT : ATTENDU - .txt");
    }
}
