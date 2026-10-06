#include <stdio.h>
#include <stdbool.h>

void fifo(int pages[], int n, int frames) {
    int frame[10];
    for (int i = 0; i < frames; i++) frame[i] = -1;
    int faults = 0, index = 0;

    for (int i = 0; i < n; i++) {
        bool hit = false;
        for (int j = 0; j < frames; j++) {
            if (frame[j] == pages[i]) { hit = true; break; }
        }
        if (!hit) {
            frame[index] = pages[i];
            index = (index + 1) % frames;
            faults++;
        }
    }
    printf("FIFO Total Page Faults: %d\n", faults);
}

void lru(int pages[], int n, int frames) {
    int frame[10], time[10];
    for (int i = 0; i < frames; i++) { frame[i] = -1; time[i] = 0; }
    int faults = 0;

    for (int i = 0; i < n; i++) {
        bool hit = false;
        for (int j = 0; j < frames; j++) {
            if (frame[j] == pages[i]) {
                hit = true;
                time[j] = i + 1;
                break;
            }
        }
        if (!hit) {
            int lruIdx = 0;
            for (int j = 1; j < frames; j++) {
                if (frame[j] == -1) { lruIdx = j; break; }
                if (time[j] < time[lruIdx]) lruIdx = j;
            }
            frame[lruIdx] = pages[i];
            time[lruIdx] = i + 1;
            faults++;
        }
    }
    printf("LRU  Total Page Faults: %d\n", faults);
}

int main() {
    int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
    int n = 20, frames = 3;

    printf("=== Page Replacement Algorithms (Frames = 3) ===\n");
    fifo(pages, n, frames);
    lru(pages, n, frames);
    return 0;
}
