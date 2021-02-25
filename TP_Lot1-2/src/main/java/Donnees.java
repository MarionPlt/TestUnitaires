import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Donnees extends JFrame implements ActionListener {


    // JButton
    static JButton b;

    // default constructor
    Donnees() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void actionPerformed(ActionEvent e, List<JTextField> textes) {

        for (JTextField texte : textes) {
            texte.getText();
        }

        System.out.println("OK");
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
            }

        } catch (Exception e) {
            System.out.println(" Erreur détectée : veuillez vérifier le format de votre fichier. ");
            System.exit(1);

        }
        return listeLecture;
    }

    public static void main(String[] args) {

        //create a new database
        MariaDB maria = new MariaDB();
        Scanner sc = new Scanner(System.in);
        boolean retry = true;
        while (retry) {

            System.out.println("Souhaitez_vous importer des données (1) ou créer un nouveau client(2)?");
            int reply = sc.nextInt();
            sc.nextLine();


            if (reply == 1) {
                System.out.println("Veuillez indiquer le chemin du fichier à importer : ");

                String path = sc.nextLine();
                List<String[]> listeClients = importFichier(path);
                for (String[] client : listeClients) {
                    Client clientAjoute = new Client(client[0], client[1], client[2], client[3]);
                    // envoie à la BDD
                    String query = maria.defineQuery(clientAjoute);
                    maria.talkToDataBase(query);


                }
            } else if (reply == 2) {


                System.out.println("Nouveau Client");
                System.out.println("ID client : ");
                String champID = sc.nextLine();
                System.out.println("Prenom : ");
                String champPrenom = sc.nextLine();
                System.out.println("Nom : ");
                String champNom = sc.nextLine();
                System.out.println("Adresse mail : ");
                String champMail = sc.nextLine();


                Client client = new Client(champID, champPrenom, champNom, champMail);
                System.out.println("Nouveau client : " + client.getNom() + " " + client.getPrenom());

                // envoie à la BDD
                String query = maria.defineQuery(client);
                maria.talkToDataBase(query);
            }
            System.out.println("Souhaitez vous ajouter un autre client? (O/N)");
            String souhait = sc.nextLine();
            if (souhait.toUpperCase().equals("N")){
                retry = false;
            }
        }

//todo ranger le bazar, ajouter l'option import d'un fichier à une bdd, ajouter tests unitaires manquants de male, créer le job pour tests indus

    }



}

