import java.util.Arrays;
import java.util.Scanner;

/**
 * Char_frequency
 */
class Char_frequency {
    char c;
    int frequency;

    public Char_frequency(){
        this.c = '\0';
        this.frequency = 0;
    }
}

public class Frequency {
    public static void insertion(int n, Char_frequency[] list){
        for (int i = 1; i < n; i++) {
            Char_frequency tmp = list[i];
            int j = i - 1;
            while (j >= 0 && tmp.frequency < list[j].frequency) {
                list[j + 1] = list[j];
                j--;
            }
            list[j+1] = tmp;
        }
    }

    public static void quicksort(Char_frequency[]list, int n){
        quicksort(list, 0, n-1);
    }

    private static void quicksort(Char_frequency[]list, int esq, int dir){
        int i = esq;
        int j = dir;
        Char_frequency pivo = list[(esq+dir)/2];
        while (i <= j) {
            while (list[i].c > pivo.c) {
                i++;
            }
            while (list[j].c < pivo.c) {
                j--;
            }
            if (i <= j) {
                Char_frequency tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
                i++; j--;
            }
        }
        if (esq < j) {
            quicksort(list, esq, j);
        }
        if (i < dir) {
            quicksort(list, i, dir);
        }
    }

    public static void main(String[] args) {
        int k, frequency, break_line;
        String input;
        Scanner scanner = new Scanner(System.in);
        Char_frequency[] list = new Char_frequency[1001];
        Boolean[] check = new Boolean[1001];
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            k = 0;
            
            Arrays.fill(check, false);
            for (int i = 0; i < input.length(); i++) {
                frequency = 0;
                if (!check[i]) {
                    
                    for (int j = 0; j < input.length(); j++) {
                        if (input.charAt(i) == input.charAt(j)) {
                            check[j] = true;
                            frequency++;
                        }
                    }
                    list[k] = new Char_frequency();
                    list[k].c = input.charAt(i);
                    list[k].frequency = frequency;
                    k++;
                }

            }

            quicksort(list, k);
            insertion(k, list);

            for (int i = 0; i < k; i++) {
                System.out.println((int)list[i].c + " " + list[i].frequency);
            }
            if (scanner.hasNextLine()) {
                System.out.println();

            }
        }
        scanner.close();
    }
}
