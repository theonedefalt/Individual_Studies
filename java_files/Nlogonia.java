/**
 * @file Nlogonia.java
 * @brief This program determines the quadrant of a point in a Cartesian plane.
 * @details The program reads the number of cases and for each case reads the coordinates of a point and determines in which quadrant the point is located.
 * @author Arthur Clemente Machado
 * @date 2024-05-31
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nlogonia {
    // readInt, readString
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static int readInt() {
        int i = -1;
        try {
            i = Integer.parseInt(readString().trim());
        } catch (Exception e) {
        }
        return i;
    }

    static String readString() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != ' ' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n' && tmp != ' ');
        } catch (Exception e) {
        }
        return s;
    }

    public static void main(String[] args) {
        // variables
        int K = 0, N = 0, M = 0, X = 0, Y = 0;

        // read K
        K = readInt();

        // continue while K is not 0
        while (K != 0) {
            if (K > 0 && K <= 1000) {
                // read N and M
                N = readInt();
                M = readInt();

                if (N > -10000 && N <= 10000 && M > -10000 && M <= 10000) {
                    // loop for each query
                    for (int j = 0; j < K; j++) {
                        // read X and Y
                        X = readInt();
                        Y = readInt();

                        if (X >= -10000 && X <= 10000 && Y >= -10000 && Y <= 10000) {
                            // print the result
                            if (X == N || Y == M) {
                                System.out.println("divisa");
                            } else if (X > N && Y > M) {
                                System.out.println("NE");
                            } else if (X < N && Y > M) {
                                System.out.println("NO");
                            } else if (X < N && Y < M) {
                                System.out.println("SO");
                            } else if (X > N && Y < M) {
                                System.out.println("SE");
                            }
                        }
                    }
                }
                // read K
                K = readInt();
            }
        }
    }
}
