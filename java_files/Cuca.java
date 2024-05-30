import java.util.Scanner;

public class Cuca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após o número inteiro

        String[] rooms = new String[50000];
        String[] ages = new String[50000];
        int[] position = new int[50000];
        String input;
        // ler o nome das crianças
        input = scanner.nextLine();
        rooms = input.split(" ");

        // ler o nome das crianças em ordem crescente de idade
        input = scanner.nextLine();
        ages = input.split(" ");
        
        // mapear as posições de quartos de que cada criança está com base na ordem de idade
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ages[i].equals(rooms[j])) {
                    position[i] = j;
                    break;
                }
            }
        }

        // achar a criança mais desgraçada
        int maxPos = -1;
        for (int i = 0; i < N; i++) {
            if (position[i] > maxPos) {
                maxPos = position[i];
            }
            System.out.print(rooms[maxPos]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
