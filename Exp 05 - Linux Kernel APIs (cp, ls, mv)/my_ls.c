#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>

int main(int argc, char *argv[]) {
    const char *dir_path = (argc > 1) ? argv[1] : ".";

    // Open directory stream using opendir() API
    DIR *dir = opendir(dir_path);
    if (dir == NULL) {
        perror("Cannot open directory");
        return 1;
    }

    printf("Contents of '%s':\n", dir_path);
    struct dirent *entry;

    // Read entries sequentially using readdir() API
    while ((entry = readdir(dir)) != NULL) {
        // Skip current (.) and parent (..) directory entries
        if (entry->d_name[0] != '.') {
            printf("  %s\n", entry->d_name);
        }
    }

    // Close directory stream
    closedir(dir);
    return 0;
}
