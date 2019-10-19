package com.github.bytemania.java_alg.connectivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UF {

    private List<Set<Integer>> unions;

    public UF(int n) {
        unions = new ArrayList<>();
    }

    public void union(Integer p, Integer q){
        boolean found = false;

        Set<Integer> pSet = null;
        Set<Integer> qSet = null;

        for(int i = 0; i < unions.size() && !found; i++) {
            if (unions.get(i).contains(p)){
                pSet = unions.get(i);
                unions.remove(i);
                found = true;
            }
        }

        if (pSet != null && pSet.contains(q)) {
            qSet = pSet;
        } else {
            found = false;
            for (int i = 0; i < unions.size() && !found; i++) {
                if (unions.get(i).contains(q)) {
                    qSet = unions.get(i);
                    unions.remove(i);
                    found = true;
                }
            }
        }

        if (pSet == null) {
            pSet = new HashSet<>();
            pSet.add(p);
        }

        if (qSet == null) {
            qSet = new HashSet<>();
            qSet.add(q);
        }
        pSet.addAll(qSet);
        unions.add(pSet);
    }

    public boolean connected(Integer p, Integer q) {
        boolean found = false;
        for (int i = 0; i < unions.size() && !found; i++) {
            var s = unions.get(i);
            found = s.contains(p) && s.contains(q);
        }
        return found;
    }

}
