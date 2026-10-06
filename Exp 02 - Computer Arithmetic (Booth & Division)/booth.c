#include <stdio.h>

void add(int ac[], int m[], int qn) {
    int carry = 0;
    for (int i = qn - 1; i >= 0; i--) {
        int sum = ac[i] + m[i] + carry;
        ac[i] = sum % 2;
        carry = sum / 2;
    }
}

void twoComplement(int m[], int comp[], int qn) {
    int one[16] = {0};
    one[qn - 1] = 1;
    for (int i = 0; i < qn; i++) comp[i] = 1 - m[i];
    int carry = 0;
    for (int i = qn - 1; i >= 0; i--) {
        int sum = comp[i] + one[i] + carry;
        comp[i] = sum % 2;
        carry = sum / 2;
    }
}

void asr(int ac[], int q[], int *q_minus, int qn) {
    *q_minus = q[qn - 1];
    for (int i = qn - 1; i > 0; i--) q[i] = q[i - 1];
    q[0] = ac[qn - 1];
    int msb = ac[0];
    for (int i = qn - 1; i > 0; i--) ac[i] = ac[i - 1];
    ac[0] = msb;
}

int main() {
    int n = 4;
    int m[4] = {0, 1, 1, 1};    // +7
    int q[4] = {0, 0, 1, 1};    // +3
    int ac[4] = {0, 0, 0, 0};
    int q_minus = 0;
    int m_neg[4];
    twoComplement(m, m_neg, n);

    printf("=== Booth's Multiplication Algorithm ===\n");
    printf("Multiplicand M = 7, Multiplier Q = 3\n\n");

    for (int step = 1; step <= n; step++) {
        if (q[n - 1] == 1 && q_minus == 0) {
            add(ac, m_neg, n); // A = A - M
        } else if (q[n - 1] == 0 && q_minus == 1) {
            add(ac, m, n);     // A = A + M
        }
        asr(ac, q, &q_minus, n);
    }

    printf("Product (A Q) = ");
    for (int i = 0; i < n; i++) printf("%d", ac[i]);
    printf(" ");
    for (int i = 0; i < n; i++) printf("%d", q[i]);
    printf(" (Decimal: 21)\n");
    return 0;
}
