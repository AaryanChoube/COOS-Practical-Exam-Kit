import java.util.Scanner;

public class PageReplacement {

    static void fifo(int[] referenceString, int n, int frames) {
        int[] frameArray = new int[frames];

        for (int i = 0; i < frames; i++)
            frameArray[i] = -1;

        int pageFaults = 0;
        int pointer = 0;

        System.out.println("\n--- FIFO Page Replacement ---");

        for (int i = 0; i < n; i++) {
            int page = referenceString[i];
            boolean hit = false;

            for (int j = 0; j < frames; j++) {
                if (frameArray[j] == page) {
                    hit = true;
                    break;
                }
            }

            if (!hit) {
                frameArray[pointer] = page;
                pointer = (pointer + 1) % frames;
                pageFaults++;
            }

            printFrames(page, frameArray, hit);
        }

        System.out.println("Total FIFO Page Faults: " + pageFaults);
    }

    static void lru(int[] referenceString, int n, int frames) {
        int[] frameArray = new int[frames];
        int[] counter = new int[frames];

        for (int i = 0; i < frames; i++)
            frameArray[i] = -1;

        int pageFaults = 0;
        int time = 0;

        System.out.println("\n--- LRU Page Replacement ---");

        for (int i = 0; i < n; i++) {
            int page = referenceString[i];
            boolean hit = false;
            time++;

            for (int j = 0; j < frames; j++) {
                if (frameArray[j] == page) {
                    hit = true;
                    counter[j] = time;
                    break;
                }
            }

            if (!hit) {
                int lruIndex = 0;
                int minTime = Integer.MAX_VALUE;

                for (int j = 0; j < frames; j++) {
                    if (frameArray[j] == -1) {
                        lruIndex = j;
                        break;
                    }

                    if (counter[j] < minTime) {
                        minTime = counter[j];
                        lruIndex = j;
                    }
                }

                frameArray[lruIndex] = page;
                counter[lruIndex] = time;
                pageFaults++;
            }

            printFrames(page, frameArray, hit);
        }

        System.out.println("Total LRU Page Faults: " + pageFaults);
    }

    static void optimal(int[] referenceString, int n, int frames) {
        int[] frameArray = new int[frames];

        for (int i = 0; i < frames; i++)
            frameArray[i] = -1;

        int pageFaults = 0;

        System.out.println("\n--- Optimal Page Replacement ---");

        for (int i = 0; i < n; i++) {
            int page = referenceString[i];
            boolean hit = false;

            for (int j = 0; j < frames; j++) {
                if (frameArray[j] == page) {
                    hit = true;
                    break;
                }
            }

            if (!hit) {
                int replaceIndex = -1;
                int farthest = -1;

                for (int j = 0; j < frames; j++) {
                    if (frameArray[j] == -1) {
                        replaceIndex = j;
                        break;
                    }

                    int nextUse = Integer.MAX_VALUE;

                    for (int k = i + 1; k < n; k++) {
                        if (frameArray[j] == referenceString[k]) {
                            nextUse = k;
                            break;
                        }
                    }

                    if (nextUse > farthest) {
                        farthest = nextUse;
                        replaceIndex = j;
                    }
                }

                frameArray[replaceIndex] = page;
                pageFaults++;
            }

            printFrames(page, frameArray, hit);
        }

        System.out.println("Total Optimal Page Faults: " + pageFaults);
    }
    static void printFrames(int page, int[] frameArray, boolean hit) {
        System.out.print("Page " + page + " -> Frames: [ ");

        for (int f : frameArray) {
            System.out.print((f == -1 ? "-" : f) + " ");
        }

        System.out.println("] " + (hit ? "(Hit)" : "(Fault)"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int frames = sc.nextInt();

        System.out.print("Enter length of reference string: ");
        int n = sc.nextInt();

        int[] referenceString = new int[n];

        System.out.println("Enter the sequence of pages:");

        for (int i = 0; i < n; i++) {
            referenceString[i] = sc.nextInt();
        }

        fifo(referenceString, n, frames);
        lru(referenceString, n, frames);
        optimal(referenceString, n, frames);

        sc.close();
    }
}