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
                            //gestionApprenants();
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
}


