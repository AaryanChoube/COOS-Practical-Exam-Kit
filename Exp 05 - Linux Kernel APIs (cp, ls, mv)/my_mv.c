#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <source_file> <dest_file>\n", argv[0]);
        return 1;
    }

    // Use rename() system call to move or rename file
    if (rename(argv[1], argv[2]) != 0) {
        perror("Error moving file");
        return 1;
    }

    printf("Moved '%s' to '%s' successfully.\n", argv[1], argv[2]);
    return 0;
}
