import java.util.Scanner;

public class BankersAlgorithm {

    static int n;
    static int m;
    static int[][] allocation;
    static int[][] max;
    static int[][] need;
    static int[] available;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        System.out.print("Enter number of resource types: ");
        m = sc.nextInt();

        allocation = new int[n][m];
        max = new int[n][m];
        need = new int[n][m];
        available = new int[m];

        System.out.println("\nEnter Allocation matrix (" + n + " x " + m + "):");

        for (int i = 0; i < n; i++) {
            System.out.println("Process P" + i + ":");

            for (int j = 0; j < m; j++) {
                System.out.print(" Allocation[R" + j + "]: ");
                allocation[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter Max matrix (" + n + " x " + m + "):");

        for (int i = 0; i < n; i++) {
            System.out.println("Process P" + i + ":");

            for (int j = 0; j < m; j++) {
                System.out.print(" Max[R" + j + "]: ");
                max[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                need[i][j] = max[i][j] - allocation[i][j];

                if (need[i][j] < 0) {
                    System.out.println(
                        "Error: Allocation exceeds Max for P" + i + ", R" + j
                    );
                    sc.close();
                    return;
                }
            }
        }

        System.out.println("\nEnter Available resources vector (" + m + "):");

        for (int j = 0; j < m; j++) {
            System.out.print(" Available[R" + j + "]: ");
            available[j] = sc.nextInt();
        }

        System.out.println("\n--- Need Matrix (Max - Allocation) ---");
        printMatrix(need);

        int[] safeSequence = new int[n];

        if (isSafeState(available.clone(), safeSequence)) {

            System.out.println("\nSystem is in a SAFE state.");
            System.out.print("Safe sequence: ");

            for (int i = 0; i < n; i++) {
                System.out.print("P" + safeSequence[i]);

                if (i != n - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();

        } else {
            System.out.println(
                "\nSystem is in an UNSAFE state (deadlock may occur)."
            );
        }

        System.out.print(
            "\nDo you want to test a resource request? (y/n): "
        );

        String choice = sc.next();

        if (choice.equalsIgnoreCase("y")) {

            System.out.print(
                "Enter process number requesting resources (0 to "
                + (n - 1) + "): "
            );

            int pid = sc.nextInt();

            int[] request = new int[m];

            System.out.println("Enter request vector (" + m + "):");

            for (int j = 0; j < m; j++) {
                System.out.print(" Request[R" + j + "]: ");
                request[j] = sc.nextInt();
            }

            requestResources(pid, request);
        }

        sc.close();
    }

    static boolean isSafeState(int[] work, int[] safeSequence) {

        boolean[] finish = new boolean[n];
        int count = 0;

        while (count < n) {

            boolean found = false;

            for (int i = 0; i < n; i++) {

                if (!finish[i]) {

                    boolean canProceed = true;

                    for (int j = 0; j < m; j++) {

                        if (need[i][j] > work[j]) {
                            canProceed = false;
                            break;
                        }
                    }

                    if (canProceed) {

                        for (int j = 0; j < m; j++) {
                            work[j] += allocation[i][j];
                        }

                        safeSequence[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    static void requestResources(int pid, int[] request) {

        for (int j = 0; j < m; j++) {

            if (request[j] > need[pid][j]) {
                System.out.println(
                    "Error: Process has exceeded its maximum claim."
                );
                return;
            }

            if (request[j] > available[j]) {
                System.out.println(
                    "Request cannot be granted: resources not available. "
                    + "Process must wait."
                );
                return;
            }
        }

        int[] tempAvailable = available.clone();
        int[][] tempAllocation = copy(allocation);
        int[][] tempNeed = copy(need);

        for (int j = 0; j < m; j++) {

            tempAvailable[j] -= request[j];
            tempAllocation[pid][j] += request[j];
            tempNeed[pid][j] -= request[j];
        }

        int[][] origAlloc = allocation;
        int[][] origNeed = need;
        int[] origAvail = available;

        allocation = tempAllocation;
        need = tempNeed;

        int[] safeSequence = new int[n];

        boolean safe = isSafeState(
            tempAvailable.clone(),
            safeSequence
        );

        if (safe) {

            available = tempAvailable;

            System.out.println(
                "Request can be granted immediately. New state is SAFE."
            );

            System.out.print("Safe sequence: ");

            for (int i = 0; i < n; i++) {

                System.out.print("P" + safeSequence[i]);

                if (i != n - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();

        } else {

            allocation = origAlloc;
            need = origNeed;
            available = origAvail;

            System.out.println(
                "Request cannot be granted: would lead to an "
                + "UNSAFE state. Process must wait."
            );
        }
    }

    static int[][] copy(int[][] src) {

        int[][] dst = new int[src.length][];

        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i].clone();
        }

        return dst;
    }

    static void printMatrix(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {

            System.out.print("P" + i + ": ");

            for (int val : mat[i]) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }
}