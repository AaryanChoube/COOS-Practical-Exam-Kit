#include <stdio.h>
#include <stdbool.h>

#define P 5
#define R 3

int main() {
    int allocation[P][R] = {
        {0, 1, 0},
        {2, 0, 0},
        {3, 0, 2},
        {2, 1, 1},
        {0, 0, 2}
    };

    int max[P][R] = {
        {7, 5, 3},
        {3, 2, 2},
        {9, 0, 2},
        {2, 2, 2},
        {4, 3, 3}
    };

    int available[R] = {3, 3, 2};

    int need[P][R];
    for (int i = 0; i < P; i++)
        for (int j = 0; j < R; j++)
            need[i][j] = max[i][j] - allocation[i][j];

    bool finish[P] = {false};
    int safeSequence[P];
    int work[R];
    for (int i = 0; i < R; i++) work[i] = available[i];

    int count = 0;
    while (count < P) {
        bool found = false;
        for (int p = 0; p < P; p++) {
            if (!finish[p]) {
                int j;
                for (j = 0; j < R; j++)
                    if (need[p][j] > work[j]) break;

                if (j == R) {
                    for (int k = 0; k < R; k++) work[k] += allocation[p][k];
                    safeSequence[count++] = p;
                    finish[p] = true;
                    found = true;
                }
            }
        }
        if (!found) {
            printf("System is NOT in a safe state (Deadlock detected!)\n");
            return 1;
        }
    }

    printf("=== Banker's Deadlock Avoidance Algorithm ===\n");
    printf("System is in a SAFE state!\nSafe Sequence: ");
    for (int i = 0; i < P; i++) {
        printf("P%d%s", safeSequence[i], (i < P - 1) ? " -> " : "\n");
    }
    return 0;
}
