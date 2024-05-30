import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Cidade {
        int atual;
        ArrayList<Cidade> proximas;
    
        public Cidade(int atual) {
            this.atual = atual;
            this.proximas = new ArrayList<Cidade>();
        }
    }
    
    static class Caminhos {
        public int c1, c2, horas;
    
        public Caminhos() {
            this.c1 = 0;
            this.c2 = 0;
            this.horas = 0;
        }
    }

    static int criarArvore(ArrayList<Caminhos> caminho, Cidade main, int[] passados, int K) throws Exception {
        if (main == null) {
            throw new Exception("Erro ao criar arvore");
        }
        int ret = 1;
        OUTER_LOOP: for (int i = 0; i < caminho.size(); i++) {
            if (caminho.get(i).c1 == main.atual) {
                for (int j = 0; j < passados.length; j++) {
                    if (caminho.get(i).c2 == passados[j]) {
                        continue OUTER_LOOP;
                    }
                }
                passados[i] = main.atual;
                for (int m = 0; m < main.proximas.size(); m++) {
                    if (main.proximas.get(m).atual == caminho.get(i).c2) {
                        ret += criarArvore(caminho, main.proximas.get(m), passados, K-ret);
                        if (ret >= K) {
                            return K;
                        }
                        m = main.proximas.size();
                        continue OUTER_LOOP;
                    }
                }
                main.proximas.add(new Cidade(caminho.get(i).c2));
                ret += criarArvore(caminho, main.proximas.get(main.proximas.size() - 1), passados, K-ret);
                if (ret >= K) {
                    return K;
                }
            } else if (caminho.get(i).c2 == main.atual) {
                for (int k = 0; k < passados.length; k++) {
                    if (caminho.get(i).c1 == passados[k]) {
                        continue OUTER_LOOP;
                    }
                }
                passados[i] = main.atual;
                for (int m = 0; m < main.proximas.size(); m++) {
                    if (main.proximas.get(m).atual == caminho.get(i).c1) {
                        ret += criarArvore(caminho, main.proximas.get(m), passados, K-ret);
                        if (ret >= K) {
                            return K;
                        }
                        m = main.proximas.size();
                        continue OUTER_LOOP;
                    }
                }
                main.proximas.add(new Cidade(caminho.get(i).c1));
                ret += criarArvore(caminho, main.proximas.get(main.proximas.size() - 1), passados, K-ret);
                if (ret >= K) {
                    return K;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N, M, K;
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        ArrayList<Caminhos> caminhos = new ArrayList<Caminhos>();
        for (int i = 0; i < M; i++) {
            Caminhos caminho = new Caminhos();
            caminho.c1 = scanner.nextInt();
            caminho.c2 = scanner.nextInt();
            caminho.horas = scanner.nextInt();
            caminhos.add(caminho);
        }
        ArrayList<Caminhos> liberados = new ArrayList<Caminhos>();
        int h = -1;
        Cidade no = new Cidade(1);
        do {
            h++;
            for (int i = 0; i < caminhos.size(); i++) {
                if (caminhos.get(i).horas <= h) {
                    liberados.add(caminhos.remove(i));
                }
            }
        } while (criarArvore(liberados, no, new int[M], K) < K);
        System.out.println(h);
        scanner.close();
    }
}
