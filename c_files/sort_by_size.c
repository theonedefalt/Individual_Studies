/**
 * @file sort_by_size.c
 * @brief This program sorts the words in a sentence by their length.
 * @details The program reads the number of cases and for each case reads a sentence and sorts the words in the sentence by their length.
 * @author Arthur Clemente Machado
 * @date 2024-05-31
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// typedef struct data
typedef struct data
{
    char word[3000];
    int length;
} data;

// function prototypes
void merge(data *arr, int l, int m, int r);
void mergeSort(data *arr, int l, int r);

int main(void)
{
    // variable declarations
    unsigned int N = 0, k = 0;
    char str[3000];
    data words[60];
    char *token;

    scanf("%d", &N);

    // for each test case
    for (size_t i = 0; i < N; i++)
    {
        // reset variables
        memset(words, 0, sizeof(words));
        memset(str, 0, sizeof(str));
        k = 0;

        // read input
        scanf(" %[^\r\n]%*c", str);
        // split input into words
        token = strtok(str, " ");
        while (token != NULL)
        {
            strcpy(words[k++].word, token);
            token = strtok(NULL, " ");
        }

        // sort words by length
        mergeSort(words, 0, k - 1);

        // print output
        for (size_t i = 0; i < k; i++)
        {
            if (i > 0 && i != k)
            {
                printf(" ");
            }
            
            printf("%s", words[i].word);
        }
        printf("\n");
    }

    return 0;
}

void merge(data *arr, int l, int m, int r)
{
    unsigned int i, j, k;
    unsigned int n1 = m - l + 1;
    unsigned int n2 = r - m;

    char **L = (char **)malloc(n1 * sizeof(char *));
    char **R = (char **)malloc(n2 * sizeof(char *));

    for (i = 0; i < n1; i++)
    {
        L[i] = (char *)malloc(51 * sizeof(char));
        strcpy(L[i], arr[l + i].word);
    }
    for (j = 0; j < n2; j++)
    {
        R[j] = (char *)malloc(51 * sizeof(char));
        strcpy(R[j], arr[m + 1 + j].word);
    }
    i = 0;
    j = 0;
    k = l;

    while (i < n1 && j < n2)
    {
        if (strlen(L[i]) >= strlen(R[j]))
        {
            strcpy(arr[k].word, L[i]);
            i++;
        }
        else
        {
            strcpy(arr[k].word, R[j]);
            j++;
        }
        k++;
    }

    while (i < n1)
    {
        strcpy(arr[k].word, L[i]);
        i++;
        k++;
    }

    while (j < n2)
    {
        strcpy(arr[k].word, R[j]);
        j++;
        k++;
    }
    for (i = 0; i < n1; i++)
        free(L[i]);
    for (j = 0; j < n2; j++)
        free(R[j]);
    free(L);
    free(R);
}

void mergeSort(data *arr, int l, int r)
{
    if (l < r)
    {
        int m = l + (r - l) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }
}