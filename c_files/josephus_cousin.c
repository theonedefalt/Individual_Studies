#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// Função para verificar se um número é primo de forma eficiente
bool is_prime(int num) {
    if (num <= 1) return false;
    if (num <= 3) return true;
    if (num % 2 == 0 || num % 3 == 0) return false;
    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) return false;
    }
    return true;
}

// Função para gerar uma lista de números primos até um limite
void generate_primes(int limit, int *primes, int *prime_count) {
    *prime_count = 0;
    for (int i = 2; i <= limit; i++) {
        if (is_prime(i)) {
            primes[(*prime_count)++] = i;
        }
    }
}

int main(void) {
    int input = 0;
    scanf("%d", &input);
    int MAX_TAM = 32520;
    int* primes = (int*)malloc(MAX_TAM*sizeof(int));
    int num_primes = 0;
    generate_primes(MAX_TAM, primes, &num_primes);

    while (input != 0) {
        int *people = (int*)malloc(input * sizeof(int));
        size_t i;

        // preencher pessoas
        for (i = 0; i < input; i++) {
            people[i] = i + 1;
        }

        int pos = -1;
        int prime_index = 0;
        size_t remaining = input; // tamanho atual da lista de pessoas

        while (remaining > 1) {
            // encontrar o próximo número primo
            int prime = primes[prime_index++];

            // mover pos pela quantidade do número primo
            for (size_t j = 0; j < prime; ) {
                pos = (pos + 1) % input; // incrementar pos e voltar ao início se ultrapassar o limite
                if (people[pos] != 0) { // contar apenas posições vivas
                    j++;
                }
            }

            people[pos] = 0; // eliminar a pessoa na posição atual
            remaining--;
        }
        for (size_t k = 0; k < input; k++) {
            if (people[k] != 0)
            {
                printf("%d ", people[k]);
            }
        }
        printf("\n");

        free(people);
        scanf("%d", &input);
    }
    free(primes);
    return 0;
}
