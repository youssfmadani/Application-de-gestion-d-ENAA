import java.util.*;
public class Classe {
    private String nom;
    private Formateur formateur;
    private ArrayList<Apprenant> apprenants = new ArrayList<>();

    public Classe(String nom, Formateur formateur) {
        this.nom = nom;
        this.formateur = formateur;
    }

    public void ajouterApprenant(Apprenant apprenant) {
        apprenants.add(apprenant);
    }

    public void afficherDetails() {
        System.out.println("Class: " + nom + " - Formateur: " + (formateur != null ? formateur.getNom() : "Non assigné"));
        System.out.println("Apprenants: ");
        for (Apprenant a : apprenants) {
            System.out.println("- " + a.getNom() + " " + a.getPrenom());
        }
    }

    public Formateur getFormateur() {
        return formateur;
    }
    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public ArrayList<Apprenant> getApprenants() {
        return apprenants;
    }
    public void setApprenants(ArrayList<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }

}
