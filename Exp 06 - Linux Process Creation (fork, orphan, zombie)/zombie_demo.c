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
        // Child process terminates immediately
        printf("Child process (PID=%d) terminating.\n", getpid());
        exit(0);
    } else {
        // Parent sleeps without calling wait()
        printf("Parent (PID=%d) sleeping for 15 seconds without calling wait()...\n", getpid());
        printf("During this time, child is in ZOMBIE state. Check with: ps aux | grep 'Z'\n");
        sleep(15);
        printf("Parent waking up and exiting.\n");
    }
    return 0;
}
