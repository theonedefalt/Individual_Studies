/**
 * @file hash_table.c
 * @brief This program creates a hash table and inserts keys in it.
 * @details The program reads the number of cases, the size of the hash table and the number of keys to be inserted in the hash table. The program then reads the keys and inserts them in the hash table. The program prints the hash table.
 * @author Arthur Clemente Machado
 * @date 2024-05-30
*/
#include <stdio.h>
#include <stdlib.h>

// structure to store the key
typedef struct Cell
{
    int key;
    struct Cell *next;
} Cell;

// structure to store the hash table
typedef struct hash_table
{
    Cell *first;
    Cell *last;
    int value;
} hash_table;

// function prototypes
void start_hash_table(hash_table *ht);
void insert_hash_table(hash_table *ht, int key);
void free_hash_table(hash_table *ht);

int main(void)
{
    int N = 0, M = 0, C = 0, key = 0, value = 0, k = 0;

    scanf("%d", &N);

    // loop for each case
    for (size_t i = 0; i < N; i++)
    {
        // read the values of M and C
        scanf("%d %d", &M, &C);
        hash_table ht[M];
        // loop to start the hash table
        for (size_t j = 0; j < M; j++)
        {
            start_hash_table(&ht[j]);
        }
        if (M >= 1 && M <= 100 && C >= 1 && C <= 200)
        {
            // loop to insert the keys in the hash table
            for (size_t j = 0; j < C; j++)
            {
                k = 0;
                scanf("%d", &key);
                if (key >= 1 && key <= 200)
                {
                    value = key % M;
                    // insert the key in the hash table
                    insert_hash_table(&ht[value], key);
                }
            }
            // print the hash table
            for (size_t j = 0; j < M; j++)
            {
                printf("%d -> ", j);
                Cell *aux = ht[j].first;
                while (aux != NULL)
                {
                    printf("%d -> ", aux->key);
                    aux = aux->next;
                }
                printf("\\\n");
            }
            // print a new line if there is a next case
            if (i < N - 1)
            {
                printf("\n");
            }
        }
        // free the hash table
        for (size_t j = 0; j < M; j++)
        {
            free_hash_table(&ht[j]);
        }
    }

    return 0;
}

void start_hash_table(hash_table *ht)
{
    ht->first = NULL;
    ht->last = NULL;
    ht->value = 0;
}

void insert_hash_table(hash_table *ht, int key)
{
    Cell *new_cell = (Cell *)malloc(sizeof(Cell));
    new_cell->key = key;
    new_cell->next = NULL;

    if (ht->first == NULL)
    {
        ht->first = new_cell;
        ht->last = new_cell;
    }
    else
    {
        ht->last->next = new_cell;
        ht->last = new_cell;
    }
}

void free_hash_table(hash_table *ht)
{
    Cell *current = ht->first;
    Cell *next;

    while (current != NULL)
    {
        next = current->next;
        free(current);
        current = next;
    }

    ht->first = NULL;
    ht->last = NULL;
}