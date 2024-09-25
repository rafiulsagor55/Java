//package opps.map;
//
//import java.util.*;
//
//public class map_map
//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        long a, b, c;
//
//        // Using a nested map to mimic the C++ map of maps
//        Map<Pair<Long, Long>, Map<Long, Long>> ab2 = new HashMap<>();
//
//        for (int i = 0; i < n; ++i)
//        {
//            a = scanner.nextLong();
//            b = scanner.nextLong();
//            c = scanner.nextLong();
//
//            // Creating the key pair
//            Pair<Long, Long> key = new Pair<>(a, b);
//
//            // Getting or creating the inner map
//            ab2.putIfAbsent(key, new HashMap<>());
//            ab2.get(key).put(c, ab2.get(key).getOrDefault(c, 0L) + 1);
//        }
//
//        // Read p, q, r values
//        long p = scanner.nextLong();
//        long q = scanner.nextLong();
//        long r = scanner.nextLong();
//
//        // Creating the key pair for querying
//        Pair<Long, Long> queryKey = new Pair<>(p, q);
//
//        // Output the result
//        System.out.println(ab2.getOrDefault(queryKey, Collections.emptyMap()).getOrDefault(r, 0L));
//
//        scanner.close();
//    }
//
//    // Simple Pair class to use as keys
//
//}
//class Pair<K, V>
//{
//    K key;
//    V value;
//
//    Pair(K key, V value)
//    {
//        this.key = key;
//        this.value = value;
//    }
//
//
//}



package opps.map;

import java.util.*;

public class map_map {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();  // Number of inputs
        long a, b, c;

        // Using a nested map structure
        Map<Long, Map<Long, Map<Long, Long>>> ab2 = new HashMap<>();

        // Reading n inputs and populating the map
        for (int i = 0; i < n; ++i) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            c = scanner.nextLong();

            // If the outer key (a) doesn't exist, add it
            ab2.putIfAbsent(a, new HashMap<>());

            // If the inner key (b) doesn't exist for the current outer key (a), add it
            ab2.get(a).putIfAbsent(b, new HashMap<>());

            // Increment the count for the innermost key (c)
            ab2.get(a).get(b).put(c, ab2.get(a).get(b).getOrDefault(c, 0L) + 1);
        }

        // Read p, q, r for the query
        long p = scanner.nextLong();
        long q = scanner.nextLong();
        long r = scanner.nextLong();

        // Safely get the result from the nested map structure
        System.out.println(
                ab2.getOrDefault(p, Collections.emptyMap())
                        .getOrDefault(q, Collections.emptyMap())
                        .getOrDefault(r, 0L)
        );

        scanner.close();
    }
}


