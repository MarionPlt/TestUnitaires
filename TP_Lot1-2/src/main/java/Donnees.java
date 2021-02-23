import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Donnees extends JFrame implements ActionListener {


    // JButton
    static JButton b;

    // default constructor
    Donnees(){}
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static List<String[]> importFichier(String path) {
        List<String[]> listeLecture = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));     ////Création du FileReader+BufferedReader
            String s;   //Initilisation de l'objet String utilisé pour la lecture
            while ((s = br.readLine()) != null) { //On lit chaque ligne jusqu'à ce qu'il n'y en ait plus
                //Split des chiffres par ";"
                String[] tab = s.split(";", 4);
                listeLecture.add(tab);
                //envoie donne a la bdd
                try {
                    connexion = DriverManager.getConnection("jdbc:mariadb://localhost:3307/testunit", "root", "");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                reparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO noms(ID, first, last, mail) VALUES(?, ?, ?, ?);");
                        preparedStatement.setString(1, z)
                        preparedStatement.setString(2, z)
                        preparedStatement.setString(3, z)
                        preparedStatement.setString(4, z)
            }

        } catch (Exception e) {
            System.out.println(" Erreur détectée : veuillez vérifier le format de votre fichier. ");
            System.exit(1);

        }
        return listeLecture;
    }

    public static void main(String[] args) {
//        System.out.println("Veuillez indiquer le chemin du fichier à importer : ");
//        Scanner sc = new Scanner(System.in);
//        String path = sc.nextLine();
//        String[] tab;
//        List<String[]> listeLecture = new ArrayList(importFichier(path));



        // create a object of the donnees class
        Donnees te = new Donnees();
        // create a new button
        b = new JButton("submit");

        // addActionListener to button
        b.addActionListener(te);

        JFrame text = new JFrame("Nouveau Client");
        JLabel text1 = new JLabel("ID");
        JTextField champID = new JTextField(15);
        JLabel text2 = new JLabel("Prenom");
        JTextField champPrenom = new JTextField(15);
        JLabel text3 = new JLabel("Nom");
        JTextField champNom = new JTextField(15);
        JLabel text4 = new JLabel("Adresse");
        JTextField champMail = new JTextField(15);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
//        p.add(text);
        p.add(text1);
        p.add(champID);
        p.add(text2);
        p.add(champPrenom);
        p.add(text3);
        p.add(champNom);
        p.add(text4);
        p.add(champMail);
        p.add(b);


        // add panel to frame
        text.add(p);

        // set the size of frame
        text.setSize(300, 300);
        text.setLocationRelativeTo(null);


        text.show();

        Client client = new Client (champID.getText(), champPrenom.getText(), champNom.getText(), champMail.getText());
// envoie a la bdd du nouveau client
        try {
            connexion = DriverManager.getConnection("jdbc:mariadb://localhost:3307/testunit", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        reparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO noms(ID, first, Last, Mail) VALUES(?, ?, ?, ?);");
                preparedStatement.setString(1, champID.getText())
                preparedStatement.setString(2, champPrenom.getText())
                preparedStatement.setString(3, champNom.getText())
                preparedStatement.setString(4, champMail.getText())
//todo ranger le bazar, ajouter l'option import d'un fichier à une bdd, ajouter tests unitaires manquants de male, créer le job pour tests indus

    }


}

