import java.util.Scanner;

public class NonRestoringDivision {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Dividend: ");
        int dividend = sc.nextInt();
        
        System.out.print("Enter Divisor: ");
        int divisor = sc.nextInt();
        
        if (divisor == 0) {
            System.out.println("Division by zero not possible.");
            sc.close();
            return;
        }

        int n = Integer.toBinaryString(dividend).length();

        int A = 0;
        int Q = dividend;
        int M = divisor;

        System.out.printf("\n%-6s\t%-12s\t%-12s\t%s\n", "Step", "A (Binary)", "Q (Binary)", "Operation");
  
        System.out.printf("%-6s\t%-12s\t%-12s\t%s\n", "Init", toBinaryString(A, n + 1), toBinaryString(Q, n), "Initial Values");

        for (int i = 0; i < n; i++) {
            String stepStr = String.valueOf(i + 1);

            A = (A << 1) | ((Q >> (n - 1)) & 1);
            Q = (Q << 1) & ((1 << n) - 1);
            
            System.out.printf("%-6s\t%-12s\t%-12s\t%s\n", stepStr + " (S)", toBinaryString(A, n + 1), toBinaryString(Q, n), "Shift Left A, Q");

            String op = "";
            if (A >= 0) {
                A = A - M;
                op = "A = A - M";
            } else {
                A = A + M;
                op = "A = A + M";
            }

            if (A >= 0) {
                Q = Q | 1;
                op += " -> A >= 0 (Q[0]=1)";
            } else {
                Q = Q & (~1);
                op += " -> A < 0 (Q[0]=0)";
            }

            System.out.printf("%-6s\t%-12s\t%-12s\t%s\n", stepStr + " (A)", toBinaryString(A, n + 1), toBinaryString(Q, n), op);
            
        }

        
        if (A < 0) {
            A = A + M;
            System.out.printf("%-6s\t%-12s\t%-12s\t%s\n", "Corr", toBinaryString(A, n + 1), toBinaryString(Q, n), "A < 0 -> Correction Step (A = A + M)");
           
        }

        System.out.println("\nFinal Quotient = " + Q);
        System.out.println("Final Remainder = " + A);

        sc.close();    
    }

    private static String toBinaryString(int val, int bits) {
        String binary = Integer.toBinaryString(val & ((1 << bits) - 1));
        while (binary.length() < bits) {
            binary = "0" + binary;
        }
        return binary;
    }
}
