package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.List;

public class NumberAscOrder<T extends Number> {
    private CustomStack<T> stackRecived;
    private List<T> orderd = new ArrayList<T>();

    public NumberAscOrder(CustomStack<T> stack) {
        stackRecived = stack;
    }

    public List<T> sort() throws StackEmptyException {
        if (stackRecived.isEmpty()) {
            return orderd;
        }
        Integer numberOfMembers = stackRecived.size();

        for (Integer i = 0; i < numberOfMembers; i++) {
            T value = stackRecived.pop();
            orderd.add(value);
        }

        orderd.sort(null);

        return orderd;
    }
}
