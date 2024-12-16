public abstract class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;

    public Personne(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public abstract void afficherDetails();
}
