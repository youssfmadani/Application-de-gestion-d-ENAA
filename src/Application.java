import java.util.*;
public class Application {

        private static ArrayList<Apprenant> apprenants = new ArrayList<>();
        private static ArrayList<Formateur> formateurs = new ArrayList<>();
        private static ArrayList<Classe> classes = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int choix;
            do {
                System.out.println("=== MENU PRINCIPAL ===");
                System.out.println("1. Gestion des Apprenants");
                System.out.println("2. Gestion des Formateurs");
                System.out.println("3. Gestion des Classes");
                System.out.println("4. Quitter");
                System.out.print("Votre choix : ");
                try {
                    choix = scanner.nextInt();
                    scanner.nextLine(); // nettoyer le buffer

                    switch (choix) {
                        case 1:
                            gestionApprenants();
                            break;
                        case 2:
                            //gestionFormateurs();
                            break;
                        case 3:
                            //gestionClasses();
                            break;
                        case 4:
                            System.out.println("Merci et à bientôt !");
                            break;
                        default:
                            System.out.println("Choix invalide !");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : Veuillez entrer un nombre entier !");
                    scanner.nextLine();
                    choix = 0; // réinitialise la boucle
                }
            } while (choix != 4);
        }
    private static void gestionApprenants() {
        System.out.println("--- Gestion des Apprenants ---");
        System.out.println("1. Ajouter un apprenant");
        System.out.println("2. Associer un apprenant à une classe");
        System.out.println("3. Modifier un apprenant");
        System.out.println("4. Supprimer un apprenant");
        System.out.println("5. Afficher les apprenants");
        System.out.print("Votre choix : ");
        try {
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterApprenant();
                    break;
                case 2:
                    associerApprenantAClasse();
                    break;
                case 3:
                    modifierApprenant();
                    break;
                case 4:
                    supprimerApprenant();
                    break;
                case 5:
                    afficherApprenants();
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.nextLine();
        }
    }

    private static void ajouterApprenant() {
        try {
            System.out.println("Ajout d'un nouvel apprenant");
            System.out.print("ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();
            System.out.print("Email : ");
            String email = scanner.nextLine();

            Apprenant apprenant = new Apprenant(id, nom, prenom, email, null);
            apprenants.add(apprenant);
            System.out.println("Apprenant ajouté avec succès !");
        } catch (InputMismatchException e) {
            System.out.println("Erreur : ID invalide !");
            scanner.nextLine();
        }
    }
    private static void associerApprenantAClasse() {
        System.out.print("\nEntrez l'ID de l'apprenant à associer : ");
        int idApprenant = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez le nom de la classe : ");
        String nomClasse = scanner.nextLine();

        Apprenant apprenant = chercherApprenantParId(idApprenant);
        Classe classe = chercherClasseParNom(nomClasse);

        if (apprenant != null && classe != null) {
            classe.ajouterApprenant(apprenant);
            System.out.println("Apprenant associé à la classe avec succès !");
        } else {
            System.out.println("Apprenant ou classe introuvable !");
        }
    }

    private static void modifierApprenant() {
        System.out.print("Entrez l'ID de l'apprenant à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Apprenant a : apprenants) {
            if (a.getId() == id) {
                System.out.print("Nouveau Nom : ");
                a.setNom(scanner.nextLine());
                System.out.print("Nouveau Prénom : ");
                a.setPrenom(scanner.nextLine());
                System.out.print("Nouvel Email : ");
                a.setEmail(scanner.nextLine());
                System.out.println("Apprenant modifié !");
                return;
            }
        }
        System.out.println("Apprenant introuvable !");
    }

    private static void supprimerApprenant() {
        System.out.print("Entrez l'ID de l'apprenant à supprimer : ");
        int id = scanner.nextInt();

        for (Apprenant a : apprenants) {
            if (a.getId() == id) {
                apprenants.remove(a);
                System.out.println("Apprenant supprimé avec succès !");
            } else {
                System.out.println("Apprenant introuvable !");
            }
        }
    }
    private static void afficherApprenants() {
        if (apprenants.isEmpty()) {
            System.out.println("Aucun apprenant à afficher.");
        } else {
            for (Apprenant a : apprenants) {
                a.afficherDetails();
            }
        }
    }
    private static Apprenant chercherApprenantParId(int id) {
        for (Apprenant a : apprenants) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    private static Classe chercherClasseParNom(String nom) {
        for (Classe c : classes) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                return c;
            }
        }
        return null;
    }


}


