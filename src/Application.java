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
                            gestionFormateurs();
                            break;
                        case 3:
                            gestionClasses();
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
    private static void gestionFormateurs() {
        System.out.println("\n--- Gestion des Formateurs ---");
        System.out.println("1. Ajouter un formateur");
        System.out.println("2. Associer un formateur à une classe");
        System.out.println("3. Modifier un formateur");
        System.out.println("4. Supprimer un formateur");
        System.out.println("5. Afficher les formateurs");
        System.out.print("Votre choix : ");
        try {
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajouterFormateur();
                    break;
                case 2:
                    associerFormateurAClasse();
                    break;
                case 3:
                    modifierFormateur();
                    break;
                case 4:
                    supprimerFormateur();
                    break;
                case 5:
                    afficherFormateurs();
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.nextLine();
        }
    }

    private static void ajouterFormateur() {
        System.out.println("\nAjout d'un nouveau formateur");
        try {
            System.out.print("ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();
            System.out.print("Spécialité : ");
            String specialite = scanner.nextLine();
            System.out.print("Email : ");
            String email = scanner.nextLine();
            System.out.print("Salaire : ");
            double salaire = scanner.nextDouble();

            Formateur formateur = new Formateur(id, nom, prenom, specialite, email, salaire);
            formateurs.add(formateur);
            System.out.println("Formateur ajouté avec succès !");
        } catch (InputMismatchException e) {
            System.out.println("Erreur : ID ou Salaire invalide !");
            scanner.nextLine();
        }
    }

    private static void associerFormateurAClasse() {
        System.out.print("\nEntrez l'ID du formateur : ");
        int idFormateur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez le nom de la classe : ");
        String nomClasse = scanner.nextLine();

        Formateur formateur = chercherFormateurParId(idFormateur);
        Classe classe = chercherClasseParNom(nomClasse);

        if (formateur != null && classe != null) {
            classe.setFormateur(formateur);
            System.out.println("Formateur associé à la classe avec succès !");
        } else {
            System.out.println("Formateur ou classe introuvable !");
        }
    }

    private static void modifierFormateur() {
        System.out.print("\nEntrez l'ID du formateur à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Formateur formateur = chercherFormateurParId(id);
        if (formateur != null) {
            System.out.print("Nouveau Nom : ");
            formateur.setNom(scanner.nextLine());
            System.out.print("Nouveau Prénom : ");
            formateur.setPrenom(scanner.nextLine());
            System.out.print("Nouvelle Spécialité : ");
            formateur.setSpecialite(scanner.nextLine());
            System.out.print("Nouvel Email : ");
            formateur.setEmail(scanner.nextLine());
            System.out.print("Nouveau Salaire : ");
            formateur.setSalaire(scanner.nextDouble());
            System.out.println("Formateur modifié !");
        } else {
            System.out.println("Formateur introuvable !");
        }
    }

    private static void supprimerFormateur() {
        System.out.print("\nEntrez l'ID du formateur à supprimer : ");
        int id = scanner.nextInt();
        if (formateurs.removeIf(f -> f.getId() == id)) {
            System.out.println("Formateur supprimé avec succès !");
        } else {
            System.out.println("Formateur introuvable !");
        }
    }

    private static void afficherFormateurs() {
        System.out.println("\n1. Afficher un formateur spécifique");
        System.out.println("2. Afficher tous les formateurs");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            System.out.print("Entrez l'ID du formateur : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Formateur formateur = chercherFormateurParId(id);
            if (formateur != null) {
                formateur.afficherDetails();
            } else {
                System.out.println("Formateur introuvable !");
            }
        } else if (choix == 2) {
            if (formateurs.isEmpty()) {
                System.out.println("Aucun formateur n'est enregistré.");
            } else {
                for (Formateur f : formateurs) {
                    f.afficherDetails();
                }
            }
        } else {
            System.out.println("Choix invalide !");
        }
    }

    private static Formateur chercherFormateurParId(int id) {
        for (Formateur f : formateurs) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }
    // ===================== GESTION DES CLASSES ===================== //
    private static void gestionClasses() {
        System.out.println("\n--- Gestion des Classes ---");
        System.out.println("1. Créer une classe");
        System.out.println("2. Modifier une classe");
        System.out.println("3. Supprimer une classe");
        System.out.println("4. Afficher les détails d'une classe");
        System.out.print("Votre choix : ");
        try {
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    creerClasse();
                    break;
                case 2:
                    modifierClasse();
                    break;
                case 3:
                    supprimerClasse();
                    break;
                case 4:
                    afficherDetailsClasse();
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.nextLine();
        }
    }

    private static void creerClasse() {
        System.out.println("\nCréation d'une nouvelle classe");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        Classe classe = new Classe(nom);
        classes.add(classe);
        System.out.println("Classe créée avec succès !");
    }

    private static void modifierClasse() {
        System.out.print("\nEntrez le nom de la classe à modifier : ");
        String nom = scanner.nextLine();
        Classe classe = chercherClasseParNom(nom);
        if (classe != null) {
            System.out.println("\n1. Changer le formateur principal");
            System.out.println("2. Ajouter un apprenant");
            System.out.println("3. Supprimer un apprenant");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.print("Entrez l'ID du nouveau formateur : ");
                    int idFormateur = scanner.nextInt();
                    scanner.nextLine();
                    Formateur formateur = chercherFormateurParId(idFormateur);
                    if (formateur != null) {
                        classe.setFormateur(formateur);
                        System.out.println("Formateur principal modifié !");
                    } else {
                        System.out.println("Formateur introuvable !");
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'ID de l'apprenant à ajouter : ");
                    int idApprenant = scanner.nextInt();
                    scanner.nextLine();
                    Apprenant apprenant = chercherApprenantParId(idApprenant);
                    if (apprenant != null) {
                        classe.ajouterApprenant(apprenant);
                        System.out.println("Apprenant ajouté !");
                    } else {
                        System.out.println("Apprenant introuvable !");
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'ID de l'apprenant à supprimer : ");
                    int idASupprimer = scanner.nextInt();
                    scanner.nextLine();
                    if (classe.supprimerApprenant(idASupprimer)) {
                        System.out.println("Apprenant supprimé !");
                    } else {
                        System.out.println("Apprenant introuvable dans cette classe !");
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } else {
            System.out.println("Classe introuvable !");
        }
    }

    private static void supprimerClasse() {
        System.out.print("\nEntrez le nom de la classe à supprimer : ");
        String nom = scanner.nextLine();
        for (Classe classe : classes) {
            if (classe.getNom().equals(nom)) {
                classes.remove(classe);
                System.out.println("Classe supprimée avec succès !");
            } else {
                System.out.println("Classe introuvable !");
                break;
            }
        }
    }

    private static void afficherDetailsClasse() {
        System.out.print("\nEntrez le nom de la classe : ");
        String nom = scanner.nextLine();
        Classe classe = chercherClasseParNom(nom);
        if (classe != null) {
            classe.afficherDetails();
        } else {
            System.out.println("Classe introuvable !");
        }
    }



}


