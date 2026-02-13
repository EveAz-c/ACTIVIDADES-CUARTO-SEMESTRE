/*Se requiere calcular el porcentaje de votos que están en una urna.
Cada que se saca un boto de la urna, se
ingresa el número del candidato. Cuando se terminan los votos
se ingresa un cero*/
import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los votos (0 para terminar):");
        Map<Integer, Integer> votos = new HashMap<>();
        int total = 0;
        int voto = sc.nextInt();
        while (voto != 0) {
            try {
                voto = sc.nextInt();
                if (voto != 0) {
                    votos.put(voto, votos.getOrDefault(voto, 0) + 1);
                    total++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error");
                sc.next();
            }
        }
        sc.close();
        for (Map.Entry<Integer, Integer> entry : votos.entrySet()) {
            int candidato = entry.getKey();
            int cantidadVotos = entry.getValue();
            double porcentaje = (double) cantidadVotos / total * 100;
            System.out.printf("Candidato %d: %.2f%%\n", candidato, porcentaje);
        }
    }
}

