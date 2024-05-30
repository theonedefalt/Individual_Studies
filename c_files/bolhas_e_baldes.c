#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool Marcelo = true;
bool Carlos = false;

void swap(int i, int j, int*arr){
    if (i != j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        Marcelo = !Marcelo;
        Carlos = !Carlos;
    }
}

void quicksort(int*arr, int esq, int dir){
    int i = esq, j = dir;
    int pivo = arr[(esq+dir)/2];
    while (i <= j)
    {
        while (arr[i] < pivo)
        {
            i++;
        }
        while (arr[j] > pivo)
        {
            j--;
        }
        if (i <= j)
        {
            swap(i, j, arr);
            i++;
            j--;
        }
    }
    if (esq < j)
    {
        quicksort(arr, esq, j);
    }
    if (i < dir)
    {
        quicksort(arr, i, dir);
    }
}

int main(void)
{
    int nums;

    scanf("%d", &nums);

    while (nums != 0)
    {
        int *arr = (int *)malloc(nums * sizeof(int));
        int *arr_AUX = (int *)malloc(nums * sizeof(int));

        for (size_t i = 0; i < nums; i++)
        {
            int AUX = 0;
            scanf("%d", &AUX);
            arr[i] = AUX;
            arr_AUX[i] = AUX;
        }

        Marcelo = true;
        Carlos = false;    

        quicksort(arr, 0, nums-1);

        if (Carlos)
        {
            printf("Marcelo");
        }
        else
        {
            printf("Carlos");
        }

        printf("\n");

        scanf("%d", &nums);
        free(arr);
        free(arr_AUX);
    }

    return 0;
}
