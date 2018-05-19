package library.algorithm.Mathematical;

class Primes {
    boolean[] isPrimes;

    Primes(int n) {
        isPrimes = new boolean[n + 1];
    }

    boolean[] primeSieve(int n) {
        for (int i = 2; i <= n; i++) {
            isPrimes[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrimes[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrimes[factor*j] = false;
                }
            }
        }
        return isPrimes;
    }
}
