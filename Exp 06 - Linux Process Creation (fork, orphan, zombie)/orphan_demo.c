#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        return 1;
    } else if (pid == 0) {
        // Child process
        printf("Child initially has PPID = %d\n", getppid());
        printf("Child sleeping for 5 seconds waiting for parent to exit...\n");
        sleep(5);
        // Parent has exited, child is now an orphan adopted by init/systemd (PID 1)
        printf("Child woke up! New adopted PPID = %d (Adopted by systemd/init)\n", getppid());
        exit(0);
    } else {
        // Parent process terminates immediately
        printf("Parent (PID=%d) exiting now, leaving child orphaned.\n", getpid());
        exit(0);
    }
    return 0;
}
