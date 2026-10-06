import java.util.Scanner;
import java.lang.Math;

public class DiskScheduling {

    static void fcfs(int[] requests, int head) {
        int totalSeekTime = 0;
        int currentHead = head;

        System.out.println("\n--- FCFS Disk Scheduling ---");
        System.out.print("Path: " + currentHead);

        for (int request : requests) {
            System.out.print(" -> " + request);
            totalSeekTime += Math.abs(request - currentHead);
            currentHead = request;
        }

        System.out.println("\nTotal Seek Time (FCFS): " + totalSeekTime);
    }

    static void sstf(int[] requests, int head, int n) {
        int totalSeekTime = 0;
        int currentHead = head;
        boolean[] visited = new boolean[n];

        System.out.println("\n--- SSTF Disk Scheduling ---");
        System.out.print("Path: " + currentHead);

        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            int nextTrackIndex = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int distance = Math.abs(requests[j] - currentHead);

                    if (distance < minDistance) {
                        minDistance = distance;
                        nextTrackIndex = j;
                    }
                }
            }

            visited[nextTrackIndex] = true;
            totalSeekTime += minDistance;
            currentHead = requests[nextTrackIndex];

            System.out.print(" -> " + currentHead);
        }

        System.out.println("\nTotal Seek Time (SSTF): " + totalSeekTime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        System.out.println("Enter the requested tracks:");

        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        fcfs(requests, head);
        sstf(requests, head, n);

        sc.close();
    }
}