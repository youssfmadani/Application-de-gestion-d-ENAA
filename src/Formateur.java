public class Formateur extends Personne {
    private String specialite;
    private double salaire;
    private Classe classe;

    public Formateur(int id, String nom, String prenom, String email, String specialite, double salaire) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
        this.salaire = salaire;
    }

    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Formateur: " + nom + " " + prenom + " - Spécialité: " + specialite);
    }
}
