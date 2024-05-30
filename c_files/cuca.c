#include <stdio.h>
#include <string.h>

int main() {
    int N;
    scanf("%d", &N);

    char rooms[50000][9];
    char ages[50000][9];
    int position[50000];
    char result[50000][9]; 

    // ler o nome das criancas
    for (int i = 0; i < N; i++) {
        scanf("%s", rooms[i]);
    }

    // mapear as posicoes de quartos de que cada crianca esta com base na ordem de idade
    for (int i = 0; i < N; i++) {
        // ler o nome das criancas em ordem crescente de idade
        scanf("%s", ages[i]);
        for (int j = 0; j < N; j++) {
            if (strcmp(ages[i], rooms[j]) == 0) {
                position[i] = j;
                break;
            }
        }
    }

    // achar a crianca mais desgracenta
    int max_pos = -1;
    for (int i = 0; i < N; i++) {
        if (position[i] > max_pos) {
            max_pos = position[i];
        }
        printf("%s", rooms[max_pos]);
        if (i < N - 1) {
            printf(" ");
        }
    }
    printf("\n");

    return 0;
}
