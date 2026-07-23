import java.util.ArrayList;
import java.util.List;
class Solution {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        boolean[] isComposite = new boolean[n];
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i < n; i++){
            if(!isComposite[i]){
                primes.add(i);
            }
            for(int p : primes){
                if(i * p >= n){
                    break;
                }
                isComposite[i * p] = true;

                if(i % p == 0){
                    break;
                }
            }
        }
        return primes.size();
    }
}