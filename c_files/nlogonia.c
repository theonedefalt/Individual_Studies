/**
 * @file nlogonia.c
 * @brief This file is the implementation of the Nlogonia problem.
 * @details The program reads the number of queries and the coordinates of the division point. The program then reads the coordinates of the points and prints the position of the point in relation to the division point.
 * @author Arthur Clemente Machado
 * @date 2024-05-31
*/

#include <stdio.h>

int main(void)
{
    // variables to store the input
    int K, N, M, X, Y;
    // get the number of queries
    scanf("%d", &K);

    // loop until the number of queries is 0
    while (K != 0)
    {
        if (K > 0 && K <= 1000)
        {
            // get the coordinates of the division point
            scanf("%d %d", &N, &M);
            if (N > -10000 && N < 10000 && M > -10000 && M < 10000)
            {
                // loop for each query
                for (size_t i = 0; i < K; i++)
                {
                    // get the coordinates of the point
                    scanf("%d %d", &X, &Y);

                    // check the position of the point
                    if (X < N && Y > M)
                    {
                        printf("NO\n");
                    }
                    else if (X > N && Y > M)
                    {
                        printf("NE\n");
                    }
                    else if (X > N && Y < M)
                    {
                        printf("SE\n");
                    }
                    else if (X < N && Y < M)
                    {
                        printf("SO\n");
                    }
                    else if (X == N || Y == M)
                    {
                        printf("divisa\n");
                    }
                }
            }
        }
        // get the number of queries
        scanf("%d", &K);
    }

    return 0;
}