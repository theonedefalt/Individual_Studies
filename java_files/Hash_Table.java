import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * Cell
 */
class Cell {
    int key;

    public Cell(int key) {
        this.key = key;
    }
}

/**
 * Hash_Table
 */
public class Hash_Table {
    List<HashSet<Cell>> hashTable;

    public Hash_Table(int M) {
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            hashTable.add(new HashSet<>());
        }
    }

    public void insert(int key) {
        int index = key % hashTable.size();
        hashTable.get(index).add(new Cell(key));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, C, key;

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            M = sc.nextInt();
            C = sc.nextInt();
            Hash_Table hashTable = new Hash_Table(M);
            if (M >= 1 && M <= 100 && C >= 1 && C <= 200) {
                for (int j = 0; j < C; j++) {
                    key = sc.nextInt();
                    if (key >= 1 && key <= 200) {
                        hashTable.insert(key);
                    }
                }
                for (int j = 0; j < M; j++) {
                    System.out.print(j + " -> ");
                    for (Cell cell : hashTable.hashTable.get(j)) {
                        System.out.print(cell.key + " -> ");
                    }
                    System.out.println("\\");
                }
                if (i < N - 1) {
                    System.out.println();
                }
            }
        }

        sc.close();
    }
}