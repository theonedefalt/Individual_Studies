/**
 * @file frequency.c
 * @brief This program reads a string and prints the frequency of each character in the string.
 * @details The program reads a string and counts the frequency of each character in the string. The program then prints the character and its frequency in ascending order of the character.
 * @author Arthur Clemente Machado
 * @date 2024-05-30
*/
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// structure to store the character and its frequency
typedef struct data
{
    char c;
    int frequency;
}data;

// function prototypes
void quicksort(data* output, int n);
void quicksort_private(data* output, int esq, int dir);
void insertion(data*output, int n);

/**
 * @brief 
 * 
 * @return int
*/
int main(void){
    int k, frequency;

    data output[1001];
    bool check[1001];
    char input[1001];
    // assume there is a next case before the loop
    bool is_next_case = (scanf(" %[^\r\n]%*c", input) != EOF);

    do
    {    
        k = 0;
        // reset the check array
        memset(check, false, sizeof(check));

        // loop for each character in the input
        for (size_t i = 0; input[i]; i++)
        {
            frequency = 0;
            // check if the character is already counted
            if (!check[i])
            {
                // count the frequency of the character
                for (size_t j = 0; input[j]; j++)
                {
                    if (input[i] == input[j])
                    {
                        check[j] = true;
                        frequency++;
                    }
                    
                }
                // store the character and its frequency
                output[k].c = input[i];
                output[k++].frequency = frequency;
            }
        }
        
        // sort the output array
        quicksort(output, k);
        insertion(output, k);

        // print the output
        for (size_t i = 0; i < k; i++)
        {
            printf("%d %d\n", (int)output[i].c, output[i].frequency);
        }

        // check if there is a next case
        is_next_case = (scanf(" %[^\r\n]%*c", input) != EOF);

        // print a new line if there is a next case
        if (is_next_case)
        {
            printf("\n");
        }
    }while(is_next_case);
    
    return 0;
}

void quicksort(data* output, int n){
    quicksort_private(output, 0, n-1);
}

void quicksort_private(data*output, int esq, int dir){
    int i = esq;
    int j = dir;
    data pivo = output[(esq+dir)/2];

    while (i <= j)
    {
        while (output[i].c > pivo.c)
        {
            i++;
        }
        while (output[j].c < pivo.c)
        {
            j--;
        }
        if (i <= j)
        {
            data tmp = output[i];
            output[i] = output[j];
            output[j] = tmp;
            i++; j--;
        }
    }
    if (i < dir)
    {
        quicksort_private(output, i, dir);
    }
    if (esq < j)
    {
        quicksort_private(output, esq, j);
    }
}

void insertion(data*output, int n){
    for (size_t i = 0; i < n; i++)
    {
        data tmp = output[i];
        int j = i-1;
        while (j >= 0 && output[j].frequency > tmp.frequency)
        {
            output[j+1] = output[j];
            j--;
        }
        output[j+1] = tmp;
    }
}