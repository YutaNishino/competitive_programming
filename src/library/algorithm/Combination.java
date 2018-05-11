package library.algorithm;

public class Combination {
    long mod;
    int[] facts;
    int[] invs;
    int[] invFacts;

    public Combination(int max, int mod) {
        this.mod = mod;
        facts = new int[max + 2];
        invs = new int[max + 2];
        invFacts = new int[max + 2];
        invs[1] = 1;
        for (int i = 2; i <= max + 1; i++) {
            invs[i] = (int)((long)invs[mod % i] * (mod - mod / i) % mod);
        }
        facts[0] = 1;
        invFacts[0] = 1;
        for (int i = 1; i <= max + 1; i++) {
            facts[i] = (int)(facts[i - 1] * (long)i % mod);
            invFacts[i] = (int)(invFacts[i - 1] * (long)invs[i] % mod);
        }
    }

    long comb (int n, int k) {
        if (k < 0 || k > n) return 0;
        return facts[n] * (long)invFacts[k] % mod * (long)invFacts[n - k] % mod;
    }

    long combRep(int n, int k) {
        return comb(n + k - 1, k);

    }
}
