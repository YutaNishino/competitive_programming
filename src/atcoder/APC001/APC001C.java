package atcoder.APC001;

import java.util.HashMap;
import java.util.Scanner;

public class APC001C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prevQuery = 0;
        int low = 0;
        int high = n - 1;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            int query;
            if (i == 0) {
                query = low;
            } else if (i == 1) {
                String ret = sc.next();
                if (ret.equals("Vacant")) return;
                map.put(0, ret);
                query = high;
            } else {
                String ret = sc.next();
                if (ret.equals("Vacant")) return;
                map.put(prevQuery, ret);
                if ((prevQuery - low - 1) % 2 == 1) {
                    if (!map.get(low).equals(ret))
                        high = prevQuery;
                    else {
                        low = prevQuery;
                    }
                } else {
                    if (map.get(low).equals(ret)) {
                        high = prevQuery;
                    } else {
                        low = prevQuery;
                    }
                }
                query = (low + high) / 2;
            }
            prevQuery = query;
            System.out.println(query);
        }
    }
 }
