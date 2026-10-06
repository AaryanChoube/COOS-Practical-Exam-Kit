#include <stdio.h>
#include <stdbool.h>

int main() {
    int p, r;
    printf("Enter number of processes: ");
    scanf("%d", &p);
    printf("Enter number of resource types: ");
    scanf("%d", &r);

    int alloc[p][r], max[p][r], need[p][r], avail[r], work[r];
    bool finish[p];
    int safeSeq[p];

    printf("\nEnter Allocation Matrix (%d x %d):\n", p, r);
    for (int i = 0; i < p; i++) {
        for (int j = 0; j < r; j++) {
            scanf("%d", &alloc[i][j]);
        }
    }

    printf("\nEnter Max Matrix (%d x %d):\n", p, r);
    for (int i = 0; i < p; i++) {
        for (int j = 0; j < r; j++) {
            scanf("%d", &max[i][j]);
            need[i][j] = max[i][j] - alloc[i][j];
        }
    }

    printf("\nEnter Available Resources (%d values):\n", r);
    for (int j = 0; j < r; j++) {
        scanf("%d", &avail[j]);
        work[j] = avail[j];
    }

    for (int i = 0; i < p; i++) finish[i] = false;

    int count = 0;
    while (count < p) {
        bool found = false;
        for (int i = 0; i < p; i++) {
            if (!finish[i]) {
                int j;
                for (j = 0; j < r; j++) {
                    if (need[i][j] > work[j]) break;
                }
                if (j == r) {
                    for (int k = 0; k < r; k++) work[k] += alloc[i][k];
                    safeSeq[count++] = i;
                    finish[i] = true;
                    found = true;
                }
            }
        }
        if (!found) {
            printf("\nSystem is NOT in a safe state! (Deadlock detected / Unsafe)\n");
            return 1;
        }
    }

    printf("\n=== System is in a SAFE State! ===\nSafe Sequence: ");
    for (int i = 0; i < p; i++) {
        printf("P%d%s", safeSeq[i], (i == p - 1) ? "\n" : " -> ");
    }

    return 0;
}
