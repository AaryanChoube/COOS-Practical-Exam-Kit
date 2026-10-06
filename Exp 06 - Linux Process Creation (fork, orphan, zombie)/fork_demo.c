#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    printf("Before fork: Main Parent Process PID = %d\n\n", getpid());

    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        return 1;
    } else if (pid == 0) {
        // Child Process branch
        printf("[CHILD PROCESS]\n");
        printf("  Child PID        = %d\n", getpid());
        printf("  Parent PID (PPID)= %d\n", getppid());
        printf("  Child executing task...\n");
        sleep(1);
        printf("  Child finished.\n");
        exit(0);
    } else {
        // Parent Process branch
        printf("[PARENT PROCESS]\n");
        printf("  Parent PID       = %d\n", getpid());
        printf("  Created Child PID= %d\n", pid);
        printf("  Parent waiting for child to complete...\n");
        wait(NULL); // Reap child process
        printf("  Child reaped. Parent exiting.\n");
    }
    return 0;
}
