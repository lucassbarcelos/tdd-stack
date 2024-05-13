package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    private NumberAscOrder<Integer> orderStack;

    Integer[] loteryNumbers = { 55, 10, 20, 40, 34, 63 };
    List<Integer> loteryList = Arrays.asList(loteryNumbers);
    Integer[] ordnatedLoteryNumbers = { 10, 20, 34, 40, 55, 63 };
    List<Integer> ordanatedLoteryList = Arrays.asList(ordnatedLoteryNumbers);
    List<Integer> emptyList = new ArrayList<Integer>();
    Integer i = 0;
    @Mock
    CustomStack<Integer> stack;

    @BeforeEach
    public void setup() {
        orderStack = new NumberAscOrder<Integer>(stack);
        i = 0;
    }

    @Test
    public void validateSort() throws StackEmptyException {
        Mockito.when(stack.pop()).thenAnswer(invocations -> {
            Integer item = loteryNumbers[i];
            i++;
            return item;
        });
        Mockito.when(stack.size()).thenReturn(6);
        assertEquals(orderStack.sort(), ordanatedLoteryList);
    }

    @Test
    public void validateEmptyStack() throws StackEmptyException {
        Mockito.when(stack.isEmpty()).thenReturn(true);
        assertEquals(orderStack.sort(), emptyList);
    }
}
