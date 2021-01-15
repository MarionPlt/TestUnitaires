import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Donnees {

    public static List<String[]> importFichier(String path) {
        List<String[]> listeLecture = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));     ////Création du FileReader+BufferedReader
            String s;   //Initilisation de l'objet String utilisé pour la lecture
            while ((s = br.readLine()) != null) { //On lit chaque ligne jusqu'à ce qu'il n'y en ait plus
                //Split des chiffres par ";"
                String[] tab = s.split(";", 4);
                listeLecture.add(tab);
            }

        } catch (Exception e) {
            System.out.println(" Erreur détectée : veuillez vérifier le format de votre fichier. ");
            System.exit(1);

        }
        return listeLecture;
    }

    public static void main(String[] args) {
        System.out.println("Veuillez indiquer le chemin du fichier à importer : ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String[] tab;
        List<String[]> listeLecture = new ArrayList(importFichier(path));

        for (int i = 0; i < listeLecture.size(); i++) {
            tab = listeLecture.get(i);
            for (int j = 0; j < 4; j++) {
                System.out.print(tab[j] + "\t");
            }
            System.out.println();
        }
    }
}


