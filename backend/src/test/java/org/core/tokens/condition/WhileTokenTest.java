package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class WhileTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        /*List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(7), new WhileToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        IToken iToken1 = tokens1.removeFirst().stackSolving(stack1).removeFirst();
        assertInstanceOf(ChooseToken.class, iToken1);
        assertEquals(0, stack1.size());
        iToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(true, ((BoolToken) stack1.peek()).getValue());
        iToken1.stackSolving(stack1);
        assertEquals(0, stack1.size());
        iToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(7, ((IntToken) stack1.peek()).getValue());


        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(7), new WhileToken()));
        Stack<IToken> stack2 = new Stack<>();
        IToken iToken2 = tokens2.removeFirst().stackSolving(stack2).removeFirst();
        assertInstanceOf(ChooseToken.class, iToken2);
        assertEquals(0, stack2.size());
        iToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());
        iToken2.stackSolving(stack2);
        assertEquals(0, stack2.size());*/
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        /*List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2), new WhileToken()));
        Stack<IToken> stack1 = new Stack<>();
        IToken iToken1 = tokens1.removeFirst().stackSolving(stack1).removeFirst();
        assertInstanceOf(ChooseToken.class, iToken1);
        iToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(1, ((IntToken) stack1.peek()).getValue());
        assertThrows(RuntimeException.class, () -> iToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(true), new WhileToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        IToken iToken2 = tokens2.removeFirst().stackSolving(stack2).removeFirst();
        assertInstanceOf(ChooseToken.class, iToken1);
        iToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(1, ((IntToken) stack2.peek()).getValue());
        assertThrows(RuntimeException.class, () -> iToken1.stackSolving(stack2));*/
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2), new WhileToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        Exception exception1 = assertThrows(RuntimeException.class, () -> tokens1.removeFirst().stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items and is 1"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new WhileToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        Exception exception2 = assertThrows(RuntimeException.class, () -> tokens2.removeFirst().stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items and is 1"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(1), new IntToken(2), new WhileToken()));
        CombinationToken combinationToken1 = new CombinationToken(tokens1);
        assertEquals("TRUE 1 2 WHILE", combinationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1), new IntToken(2), new WhileToken()));
        CombinationToken combinationToken2 = new CombinationToken(tokens2);
        assertEquals("FALSE 1 2 WHILE", combinationToken2.toString());
    }
}
