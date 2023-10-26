package org.example.mathservice;

import java.util.ArrayList;
import java.util.List;

public class LucasSequence {

    private static final int n0 = 2;
    private static final int n1 = 1;

    public static List<Integer> getFirstN(int n){
        List<Integer> firstN = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            firstN.add(getN(i));
        }
        return firstN;
    }

    private static int getN(int n){
        if (n == 0) return n0;
        if (n == 1) return n1;
        return getN(n - 1) + getN(n - 2);
    }
}
