public class Client {
    private String id;
    private String prenom;
    private String nom;
    private String adresse;


    public Client(String id, String prenom, String nom, String adresse) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
