import java.util.PriorityQueue;
import java.util.Scanner;

class Dragao implements Comparable<Dragao> {
    int dias, multa;
    double prioridade;

    Dragao(int d, int m) {
        dias = d;
        multa = m;
        prioridade = (double) multa / dias;
    }

    @Override
    public int compareTo(Dragao a) {
        return Double.compare(a.prioridade, prioridade);
    }
}

public class Daenerys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double multadia = 0.0; // Multa paga por dia por todos os dragões
        double multatotal = 0.0; // Resposta
        boolean treinando = false;
        int diasrestantes = 0; // Tempo restante do treinamento
        PriorityQueue<Dragao> fila = new PriorityQueue<>();

        while (scanner.hasNextInt()) {
            int tempo = scanner.nextInt();
            int multa = scanner.nextInt();
            fila.add(new Dragao(tempo, multa));
            
            multadia += multa;

            if (!treinando || diasrestantes == 0) {
                multadia -= fila.peek().multa;
                diasrestantes = fila.peek().dias;
                fila.poll();
                treinando = true;
            }
            multatotal += multadia;
            diasrestantes--;
        }

        if (treinando)
            multatotal += diasrestantes * multadia;

        while (!fila.isEmpty()) {
            multadia -= fila.peek().multa;
            multatotal += multadia * fila.peek().dias;
            fila.poll();
        }

        System.out.printf("%.0f\n", multatotal);
        scanner.close();
    }
}