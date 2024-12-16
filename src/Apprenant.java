import java.util.*;

public class Apprenant extends Personne {
    private Classe classe;
    private ArrayList<Double> notes = new ArrayList<>();

    public Apprenant(int id, String nom, String prenom, String email, Classe classe) {
        super(id, nom, prenom, email);
        this.classe = classe;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public ArrayList<Double> getNotes() {
        return notes;
    }
    public void setNotes(ArrayList<Double> notes) {
        this.notes = notes;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Apprenant: " + nom + " " + prenom + " - Classe: " + (classe != null ? classe.getNom() : "Non assignée"));
    }

}

