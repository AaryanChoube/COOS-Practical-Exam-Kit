#include <stdio.h>

int main() {
    int dividend = 11, divisor = 3;
    int n = 4;
    int q[4] = {1, 0, 1, 1}; // 11
    int m[5] = {0, 0, 0, 1, 1}; // 3
    int a[5] = {0, 0, 0, 0, 0};
    int m_comp[5];

    // 2's complement of M
    for (int i = 0; i < 5; i++) m_comp[i] = 1 - m[i];
    int carry = 1;
    for (int i = 4; i >= 0; i--) {
        int sum = m_comp[i] + carry;
        m_comp[i] = sum % 2;
        carry = sum / 2;
    }

    printf("=== Restoring Division Algorithm ===\n");
    printf("Dividend = %d, Divisor = %d\n\n", dividend, divisor);

    for (int step = 1; step <= n; step++) {
        // Shift left [A, Q]
        for (int i = 0; i < 4; i++) a[i] = a[i + 1];
        a[4] = q[0];
        for (int i = 0; i < 3; i++) q[i] = q[i + 1];

        // A = A - M
        carry = 0;
        int temp[5];
        for (int i = 4; i >= 0; i--) {
            int sum = a[i] + m_comp[i] + carry;
            temp[i] = sum % 2;
            carry = sum / 2;
        }

        if (temp[0] == 1) { // A < 0 (negative)
            q[3] = 0;
            // Restore A (do nothing to a)
        } else { // A >= 0
            for (int i = 0; i < 5; i++) a[i] = temp[i];
            q[3] = 1;
        }
    }

    int rem = 0, quot = 0;
    for (int i = 0; i < 5; i++) rem = rem * 2 + a[i];
    for (int i = 0; i < 4; i++) quot = quot * 2 + q[i];

    printf("Quotient  (Q) = %d\n", quot);
    printf("Remainder (A) = %d\n", rem);
    return 0;
}
