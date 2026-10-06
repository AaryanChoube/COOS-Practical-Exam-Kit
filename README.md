# COOS Practical & Viva Exam Kit (5th Semester)

> **Official Notice:**  
> *"For COOS there will be both practical and oral exam. All experiments except experiments on Virtual lab and OS simulator will be in exam. Prepare experiment no. 2, 4, 5, 6, 8, 9, 10, and 11."*  
> **Prepared for:** Aaryan Choube (24CE1045) • Batch A / A1

---

## ⚡ 1-Click Access Links (Zero-Login TinyURLs)
- 📱 **DAA-Style Ultra-Compact Pocket Print (1-Page PDF):** [**`tinyurl.com/coos-pocket`**](https://tinyurl.com/coos-pocket) *(Same Consolas 4.5pt, 3-column format as DAA pocket print, includes Viva)*
- 🌐 **Live Web Portal (1-Click Copy Buttons):** [**`tinyurl.com/coos-exam`**](https://tinyurl.com/coos-exam) *(Alt: `tinyurl.com/coos-portal`)*
- 📦 **Download Entire Kit as ZIP:** [**`tinyurl.com/coos-zip`**](https://tinyurl.com/coos-zip)
- 📄 **Readable Macro Sheet (7.0 pt, 2-Page PDF):** [**`tinyurl.com/coos-macro`**](https://tinyurl.com/coos-macro) *(Large, comfortable font, 2 columns)*
- 🌟 **Master Viva & Oral Exam Guide (25 Q&A):** [**`tinyurl.com/coos-viva`**](https://tinyurl.com/coos-viva)

---

## 📂 Target Experiments & Code Index

| Exp # | Experiment Title | Languages Available | Core Files |
| **02** | Computer Arithmetic (Booth's & Division) | **Java (Manual)** & C | **☕ Java (College Manual):** [BoothsAlgorithm.java](./Exp%2002%20-%20Computer%20Arithmetic%20(Booth%20%26%20Division)/BoothsAlgorithm.java), [RestoringDivision.java](./Exp%2002%20-%20Computer%20Arithmetic%20(Booth%20%26%20Division)/RestoringDivision.java), [NonRestoringDivision.java](./Exp%2002%20-%20Computer%20Arithmetic%20(Booth%20%26%20Division)/NonRestoringDivision.java)<br>**⚙️ C Alternative:** [booth.c](./Exp%2002%20-%20Computer%20Arithmetic%20(Booth%20%26%20Division)/booth.c), [restoring_division.c](./Exp%2002%20-%20Computer%20Arithmetic%20(Booth%20%26%20Division)/restoring_division.c), [non_restoring_division.c](./Exp%2002%20-%20Computer%20Arithmetic%20(Booth%20%26%20Division)/non_restoring_division.c) |
| **04** | Linux Commands & Shell Scripting | Bash Script | [system_info.sh](./Exp%2004%20-%20Linux%20Commands%20%26%20Shell%20Scripting/system_info.sh), [Linux_Commands_Quick_Reference.txt](./Exp%2004%20-%20Linux%20Commands%20%26%20Shell%20Scripting/Linux_Commands_Quick_Reference.txt) |
| **05** | Linux Kernel APIs (`cp`, `ls`, `mv`) | C (POSIX APIs) | [my_cp.c](./Exp%2005%20-%20Linux%20Kernel%20APIs%20(cp%2C%20ls%2C%20mv)/my_cp.c), [my_ls.c](./Exp%2005%20-%20Linux%20Kernel%20APIs%20(cp%2C%20ls%2C%20mv)/my_ls.c), [my_mv.c](./Exp%2005%20-%20Linux%20Kernel%20APIs%20(cp%2C%20ls%2C%20mv)/my_mv.c) |
| **06** | Process Creation (`fork`, `orphan`, `zombie`) | C (POSIX) | [fork_demo.c](./Exp%2006%20-%20Linux%20Process%20Creation%20(fork%2C%20orphan%2C%20zombie)/fork_demo.c), [orphan_demo.c](./Exp%2006%20-%20Linux%20Process%20Creation%20(fork%2C%20orphan%2C%20zombie)/orphan_demo.c), [zombie_demo.c](./Exp%2006%20-%20Linux%20Process%20Creation%20(fork%2C%20orphan%2C%20zombie)/zombie_demo.c) |
| **08** | Banker's Deadlock Avoidance Algorithm | C & Java | [bankers_algorithm.c](./Exp%2008%20-%20Deadlock%20Avoidance%20(Bankers%20Algorithm)/bankers_algorithm.c), [BankersAlgorithm.java](./Exp%2008%20-%20Deadlock%20Avoidance%20(Bankers%20Algorithm)/BankersAlgorithm.java) |
| **09** | Dynamic Memory Management (First, Best, Worst Fit) | C & Java | [memory_management.c](./Exp%2009%20-%20Dynamic%20Memory%20Management%20(First%2C%20Best%2C%20Worst%20Fit)/memory_management.c), [MemoryManagement.java](./Exp%2009%20-%20Dynamic%20Memory%20Management%20(First%2C%20Best%2C%20Worst%20Fit)/MemoryManagement.java) |
| **10** | Virtual Memory Page Replacement (FIFO, LRU, Optimal) | C & Java | [page_replacement.c](./Exp%2010%20-%20Virtual%20Memory%20Page%20Replacement%20(FIFO%2C%20LRU%2C%20Optimal)/page_replacement.c), [PageReplacement.java](./Exp%2010%20-%20Virtual%20Memory%20Page%20Replacement%20(FIFO%2C%20LRU%2C%20Optimal)/PageReplacement.java) |
| **11** | Disk Scheduling (FCFS, SSTF, SCAN, C-SCAN) | C & Java | [disk_scheduling.c](./Exp%2011%20-%20Disk%20Scheduling%20(FCFS%2C%20SSTF%2C%20SCAN%2C%20C-SCAN)/disk_scheduling.c), [DiskScheduling.java](./Exp%2011%20-%20Disk%20Scheduling%20(FCFS%2C%20SSTF%2C%20SCAN%2C%20C-SCAN)/DiskScheduling.java) |

---

## 🚀 Quick Execution Guide on College Lab PCs

### 1. If running C programs:
```bash
gcc filename.c -o out
./out
```

### 2. If running Java programs:
```bash
javac ClassName.java
java ClassName
```

### 3. If running Linux Shell Script (Exp 4):
```bash
chmod +x system_info.sh
./system_info.sh
```

### 4. Linux Kernel APIs (Exp 5):
```bash
gcc my_cp.c -o my_cp && ./my_cp source.txt dest.txt
gcc my_ls.c -o my_ls && ./my_ls
gcc my_mv.c -o my_mv && ./my_mv old.txt new.txt
```

---

## 🎯 High-Yield Viva Formulae & Definitions
- **Booth's Algorithm:** Check $Q_0 Q_{-1}$. If `10` -> $A = A - M$; if `01` -> $A = A + M$; if `00` or `11` -> no arithmetic. Always arithmetic right shift $[A, Q, Q_{-1}]$.
- **Restoring Division:** Shift left $[A, Q]$, $A = A - M$. If $A < 0$, restore $A = A + M$ and $Q_0 = 0$; else $Q_0 = 1$.
- **Non-Restoring Division:** If $A \ge 0$, shift left and $A = A - M$. If $A < 0$, shift left and $A = A + M$. If $A \ge 0 \implies Q_0=1$, else $Q_0=0$. At the end, if $A < 0$, restore $A = A + M$.
- **Banker's Algorithm:** $\text{Need}[i][j] = \text{Max}[i][j] - \text{Allocation}[i][j]$. A state is safe if there exists an execution sequence where $\text{Need}_i \le \text{Work}$.
- **Belady's Anomaly:** Anomaly where increasing the number of page frames results in an *increase* in the number of page faults. It occurs in FIFO, but never in Stack algorithms (LRU, Optimal).
- **Disk Scheduling:** FCFS (simple queue order), SSTF (closest track first, causes starvation), SCAN (elevator to edge, then reverse), C-SCAN (unidirectional scan, jumps back to start without serving requests on return).
