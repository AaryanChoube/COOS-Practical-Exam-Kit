import java.util.Scanner;

public class BoothsAlgorithm {
    public static String toBinary(int num, int bits) {
        int mask = (1 << bits) - 1;
        int val = num & mask;
        String s = Integer.toBinaryString(val);
        while (s.length() < bits) {
            s = "0" + s;
        }
        if (s.length() > bits) {
            s = s.substring(s.length() - bits);
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("    Booth's Multiplication Algorithm");
        System.out.println("========================================");
        System.out.println("1. Use default sample: Multiplicand (M) = 7, Multiplier (Q) = 3");
        System.out.println("2. Enter custom numbers");
        System.out.print("Enter choice (1/2): ");

        int choice = 1;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        }

        int M, Q;
        if (choice == 1) {
            M = 7;
            Q = 3;
        } else {
            System.out.print("Enter Multiplicand (M): ");
            M = sc.nextInt();
            System.out.print("Enter Multiplier (Q): ");
            Q = sc.nextInt();
        }

        int bits = 5;
        int A = 0;
        int Q_val = Q;
        int Q_neg1 = 0;
        int count = bits;

        System.out.println("\nM = " + M + " (" + toBinary(M, bits) + "), -M = " + (-M) + " (" + toBinary(-M, bits) + ")");
        System.out.println("Q = " + Q + " (" + toBinary(Q, bits) + ")");
        System.out.println("\nCycle\tOperation\t\tA\tQ\tQ-1\tCount");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Init\tInitial State\t\t" + toBinary(A, bits) + "\t" + toBinary(Q_val, bits) + "\t" + Q_neg1 + "\t" + count);

        while (count > 0) {
            int q0 = Q_val & 1;
            String op = "";

            if (q0 == 1 && Q_neg1 == 0) {
                A = A - M;
                op = "A = A - M";
                System.out.println(count + "\t" + op + "\t\t" + toBinary(A, bits) + "\t" + toBinary(Q_val, bits) + "\t" + Q_neg1 + "\t" + count);
            } else if (q0 == 0 && Q_neg1 == 1) {
                A = A + M;
                op = "A = A + M";
                System.out.println(count + "\t" + op + "\t\t" + toBinary(A, bits) + "\t" + toBinary(Q_val, bits) + "\t" + Q_neg1 + "\t" + count);
            }

            // Arithmetic Right Shift
            Q_neg1 = Q_val & 1;
            int a_lsb = A & 1;
            Q_val = (Q_val >> 1) & ((1 << (bits - 1)) - 1);
            if (a_lsb == 1) {
                Q_val |= (1 << (bits - 1));
            }
            A = A >> 1;

            count--;
            System.out.println(count + "\tASR\t\t\t" + toBinary(A, bits) + "\t" + toBinary(Q_val, bits) + "\t" + Q_neg1 + "\t" + count);
        }

        int product = M * Q;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Final Binary [A Q]: " + toBinary(A, bits) + " " + toBinary(Q_val, bits));
        System.out.println("Final Product (Decimal): " + product);
        System.out.println("========================================");
    }
}
