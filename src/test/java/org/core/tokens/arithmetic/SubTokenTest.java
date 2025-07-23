package org.core.tokens.arithmetic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SubTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new IntToken(5)));
        SubToken subToken1 = new SubToken(tokens1);
        assertEquals(-2, subToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(5), new IntToken(3)));
        SubToken subToken2 = new SubToken(tokens2);
        assertEquals(2, subToken2.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true)));
        SubToken subToken1 = new SubToken(tokens1);
        assertNull(subToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3)));
        SubToken subToken2 = new SubToken(tokens2);
        assertNull(subToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidSubition() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(6)));
        SubToken subToken1 = new SubToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = subToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(IntToken.class, result1.getFirst());
        assertEquals(-2, ((IntToken) result1.getFirst()).getValue());
        assertEquals("4 6 SUB -> -2", substitutions1.getFirst());


        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(6), new IntToken(4)));
        SubToken subToken2 = new SubToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = subToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(IntToken.class, result2.getFirst());
        assertEquals(2, ((IntToken) result2.getFirst()).getValue());
        assertEquals("6 4 SUB -> 2", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false)));
        SubToken subToken1 = new SubToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> subToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1)));
        SubToken subToken2 = new SubToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> subToken2.termRewritingSolving(substitutions2));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        SubToken subToken1 = new SubToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> subToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        SubToken subToken2 = new SubToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> subToken2.termRewritingSolving(substitutions2));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7), new IntToken(2)));
        SubToken subToken1 = new SubToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        subToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(7, stack1.peek().getValue());
        subToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        subToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(5, ((IntToken) stack1.peek()).getValue());


        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(7)));
        SubToken subToken2 = new SubToken(tokens2);
        Stack<IToken> stack = new Stack<>();
        subToken2.stackSolving(stack);
        assertEquals(1, stack.size());
        assertEquals(2, stack.peek().getValue());
        subToken2.stackSolving(stack);
        assertEquals(2, stack.size());
        assertEquals(7, stack.peek().getValue());
        subToken2.stackSolving(stack);
        assertEquals(1, stack.size());
        assertInstanceOf(IntToken.class, stack.peek());
        assertEquals(-5, ((IntToken) stack.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(2)));
        SubToken subToken1 = new SubToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        subToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        subToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> subToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new BoolToken(true)));
        SubToken subToken2 = new SubToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        subToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(2, stack2.peek().getValue());
        subToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        assertThrows(RuntimeException.class, () -> subToken2.stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        SubToken subToken1 = new SubToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        subToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> subToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        SubToken subToken2 = new SubToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(1, tokens2.size());
        subToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> subToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2)));
        SubToken subToken1 = new SubToken(tokens1);
        assertEquals("1 2 SUB", subToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(1)));
        SubToken subToken2 = new SubToken(tokens2);
        assertEquals("2 1 SUB", subToken2.toString());
    }
}
