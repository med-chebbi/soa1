package tp1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class ExecuterCommande {

    public static void executerCommande(String commande) {
        try {
            Process process = Runtime.getRuntime().exec(commande);

            if (!process.waitFor(5, TimeUnit.SECONDS)) {
                process.destroy();
                System.out.println("Le processus a été détruit car il a dépassé le temps d'exécution.");
            } else {
                System.out.println("Code de sortie du processus : " + process.exitValue());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.print("Veuillez saisir une commande système : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String commande = reader.readLine();

            executerCommande(commande);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

