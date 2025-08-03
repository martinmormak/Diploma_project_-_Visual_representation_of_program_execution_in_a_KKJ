package org.core.tokens.arithmetic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SubTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7), new IntToken(2), new SubToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(7, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(5, ((IntToken) stack1.peek()).getValue());


        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(7), new SubToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(2, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(7, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(-5, ((IntToken) stack2.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(2), new SubToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(true, ((BoolToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(2, ((IntToken) stack1.peek()).getValue());
        assertThrows(RuntimeException.class, () -> tokens1.removeFirst().stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new BoolToken(true), new SubToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(2, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(true, ((BoolToken) stack2.peek()).getValue());
        assertThrows(RuntimeException.class, () -> tokens2.removeFirst().stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2), new SubToken()));
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(2, tokens1.size());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(2, ((IntToken) stack1.peek()).getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> tokens1.removeFirst().stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new SubToken()));
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(2, tokens2.size());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(true, ((BoolToken) stack2.peek()).getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> tokens2.removeFirst().stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2), new SubToken()));
        CombinationToken combinationToken1 = new CombinationToken(tokens1);
        assertEquals("1 2 SUB", combinationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(1), new SubToken()));
        CombinationToken combinationToken2 = new CombinationToken(tokens2);
        assertEquals("2 1 SUB", combinationToken2.toString());
    }
}
