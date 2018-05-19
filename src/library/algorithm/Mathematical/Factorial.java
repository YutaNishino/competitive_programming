package library.algorithm.Mathematical;

class Factorial {
    long[] fillFactorial(int max, int mod) {
        long[] facts = new long[max + 1];
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++) {
            facts[i] = facts[i - 1] * i % mod;
        }
        return facts;
    }

    long[] fillFactorial(int max) {
        long[] facts = new long[max + 1];
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++) {
            facts[i] = facts[i - 1] * i;
        }
        return facts;
    }
}
