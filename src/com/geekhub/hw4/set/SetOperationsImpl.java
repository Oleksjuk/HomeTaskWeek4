package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsImpl implements SetOperations {
    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        return union(subtract(a,b),subtract(b,a));
    }
}
