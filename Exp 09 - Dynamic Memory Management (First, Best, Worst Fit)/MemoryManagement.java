import java.util.Scanner; 
 
public class MemoryManagement { 

    static void firstFit(int[] s_orig, int n, int[] sp, int p) { 
        int[] flag = new int[10]; 
        int[] s = s_orig.clone(); 
 
        System.out.println("\n--- First Fit Allocation ---"); 
        System.out.println("Process\tProcess Size\tBlock Size"); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < p; j++) { 
                if ((s[i] >= sp[j]) && (flag[j] == 0)) { 
                    flag[j] = 1; 
                    System.out.println("P" + j + "\t" + sp[j] + "\t\t" + s[i]); 
                    break; 
                } 
            } 
        } 
    } 

    static void bestFit(int[] s_orig, int n, int[] sp, int p) { 
        int[] flag = new int[10]; 
        int[] s = s_orig.clone(); 
        int temp; 
        for (int i = 0; i < n; i++) { 
            for (int j = i + 1; j < n; j++) { 
                if (s[i] >= s[j]) { 
                    temp = s[i]; 
                    s[i] = s[j]; 
                    s[j] = temp; 
                } 
            } 
        } 
 
        System.out.println("\n--- Best Fit Allocation ---"); 
		    System.out.println("Process\tProcess Size\tBlock Size"); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < p; j++) { 
                if ((s[i] >= sp[j]) && (flag[j] == 0)) { 
                    flag[j] = 1; 
                    System.out.println("P" + j + "\t" + sp[j] + "\t\t" + s[i]); 
                    break; 
                } 
            } 
        } 
    } 
    static void worstFit(int[] s_orig, int n, int[] sp, int p) { 
        int[] flag = new int[10]; 
        int[] s = s_orig.clone(); 
        int temp; 

        for (int i = 0; i < n; i++) { 
            for (int j = i + 1; j < n; j++) { 
                if (s[i] <= s[j]) { 
                    temp = s[i]; 
                    s[i] = s[j]; 
                    s[j] = temp; 
                } 
            } 
        } 
 
        System.out.println("\n--- Worst Fit Allocation ---"); 
        System.out.println("Process\tProcess Size\tBlock Size"); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < p; j++) { 
                if ((s[i] >= sp[j]) && (flag[j] == 0)) { 
                    flag[j] = 1; 
                    System.out.println("P" + j + "\t" + sp[j] + "\t\t" + s[i]); 
                    break; 
                } 
            } 
        } 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter number of partitions: "); 
        int n = sc.nextInt(); 
        int[] s = new int[10]; 
        System.out.println("Enter size of each partition:"); 
        for (int i = 0; i < n; i++) { 
            s[i] = sc.nextInt(); 
        } 
 
        System.out.print("Enter number of processes: "); 
        int p = sc.nextInt(); 
        int[] sp = new int[10]; 
        System.out.println("Enter size of each process:"); 
        for (int i = 0; i < p; i++) { 
            sp[i] = sc.nextInt(); 
        } 
 
        firstFit(s, n, sp, p); 
        bestFit(s, n, sp, p); 
        worstFit(s, n, sp, p); 
 
        sc.close(); 
    } 
} 
 

