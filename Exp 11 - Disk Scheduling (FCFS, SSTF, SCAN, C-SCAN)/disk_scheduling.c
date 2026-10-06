#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void fcfs(int req[], int n, int head) {
    int seek = 0, cur = head;
    printf("\nFCFS Order: %d", cur);
    for (int i = 0; i < n; i++) {
        seek += abs(req[i] - cur);
        cur = req[i];
        printf(" -> %d", cur);
    }
    printf("\nTotal Seek Time: %d\n", seek);
}

void scan(int req[], int n, int head, int disk_size) {
    int seek = 0, cur = head;
    int sorted[20];
    for (int i = 0; i < n; i++) sorted[i] = req[i];
    
    // Sort
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (sorted[j] > sorted[j + 1]) {
                int t = sorted[j]; sorted[j] = sorted[j + 1]; sorted[j + 1] = t;
            }
        }
    }

    printf("\nSCAN Order: %d", cur);
    // Move towards higher cylinders
    int idx = 0;
    while (idx < n && sorted[idx] < head) idx++;

    for (int i = idx; i < n; i++) {
        seek += abs(sorted[i] - cur);
        cur = sorted[i];
        printf(" -> %d", cur);
    }
    seek += abs((disk_size - 1) - cur);
    cur = disk_size - 1;
    printf(" -> %d", cur);

    for (int i = idx - 1; i >= 0; i--) {
        seek += abs(sorted[i] - cur);
        cur = sorted[i];
        printf(" -> %d", cur);
    }
    printf("\nTotal Seek Time: %d\n", seek);
}

int main() {
    int req[] = {82, 170, 43, 140, 24, 16, 190};
    int n = 7, head = 50, disk_size = 200;

    printf("=== Disk Scheduling Algorithms (Head = 50) ===\n");
    fcfs(req, n, head);
    scan(req, n, head, disk_size);
    return 0;
}
