import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Data
 */
class Data {
    String word;

    public Data() {
        word = "";
    }

    public Data(String word) {
        this.word = word;
    }
}

public class Sort_by_Size {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() {
        int i = -1;
        try {
            i = Integer.parseInt(readString().trim());
        } catch (Exception e) {
        }
        return i;
    }

    public static String readString() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != ' ' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n' && tmp != ' ');
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static String readLine() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n');
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static void main(String[] args) {
        int N = 0, j;
        String input;
        String[] token;
        Data[] words = new Data[60];

        N = readInt();

        for (int i = 0; i < N; i++) {
            Arrays.fill(words, new Data());
            input = "";
            token = null;

            input = readLine();

            token = input.split(" ");
            j = 0;
            for (; j < token.length; j++) {
                words[j] = new Data(token[j]);
            }

            mergeSort(words, 0, j);

            for (int k = 0; k < j; k++) {
                if (k > 0 && k != j) {
                    System.out.print(" ");
                }
                System.out.print(words[k].word);
            }
            System.out.println();
        }
    }

    static void mergeSort(Data[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(Data[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Data[] L = new Data[n1];
        Data[] R = new Data[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i].word.length() >= R[j].word.length()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
