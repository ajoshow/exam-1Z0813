package com.ajoshow.exam1z0813;


import java.util.Arrays;
import java.util.List;

interface Carnivore {
    default int calories(List<String> food) {
        return 100;
    }

    int eat(List<String> foods);
}

class Tiger implements Carnivore {
    public int eat(List<String> foods) {
        return 100;
    }
}

public class MethodReferenceMain {
    public static int size(List<String> names) {
        return 100;
    }

    public static void process(List<String> names, Carnivore c) {
        c.eat(names);
    }

    public static void main(String[] args) {
        List<String> fnames = Arrays.asList("a", "b", "c");
        Tiger t = new Tiger();

        process(fnames, t);
        process(fnames, t::eat);
        process(fnames, t::calories);
        process(fnames, MethodReferenceMain::size);

        // Carnivore is interface. It does not refer to any object upon which calories method can be invoked
//        process(fnames, Carnivore::calories);

        // eat must be static method since it references to Tiger class not Tiger instance.
//        process(fnames, Tiger::eat);
    }
}


