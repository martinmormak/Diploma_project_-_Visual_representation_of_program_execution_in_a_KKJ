package org.core.tokens.arithmetic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AddTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new IntToken(5)));
        AddToken addToken1 = new AddToken(tokens1);
        assertEquals(8, addToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(5), new IntToken(3)));
        AddToken addToken2 = new AddToken(tokens2);
        assertEquals(8, addToken2.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true)));
        AddToken addToken1 = new AddToken(tokens1);
        assertNull(addToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3)));
        AddToken addToken2 = new AddToken(tokens2);
        assertNull(addToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(6)));
        AddToken addToken1 = new AddToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = addToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(IntToken.class, result1.getFirst());
        assertEquals(10, ((IntToken) result1.getFirst()).getValue());
        assertEquals("4 6 ADD -> 10", substitutions1.getFirst());


        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(6), new IntToken(4)));
        AddToken addToken2 = new AddToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = addToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(IntToken.class, result2.getFirst());
        assertEquals(10, ((IntToken) result2.getFirst()).getValue());
        assertEquals("6 4 ADD -> 10", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false)));
        AddToken addToken1 = new AddToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> addToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1)));
        AddToken addToken2 = new AddToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> addToken2.termRewritingSolving(substitutions2));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        AddToken addToken1 = new AddToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> addToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        AddToken addToken2 = new AddToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> addToken2.termRewritingSolving(substitutions2));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7), new IntToken(2)));
        AddToken addToken1 = new AddToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        addToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(7, stack1.peek().getValue());
        addToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        addToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(9, ((IntToken) stack1.peek()).getValue());


        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(7)));
        AddToken addToken2 = new AddToken(tokens2);
        Stack<IToken> stack = new Stack<>();
        addToken2.stackSolving(stack);
        assertEquals(1, stack.size());
        assertEquals(2, stack.peek().getValue());
        addToken2.stackSolving(stack);
        assertEquals(2, stack.size());
        assertEquals(7, stack.peek().getValue());
        addToken2.stackSolving(stack);
        assertEquals(1, stack.size());
        assertInstanceOf(IntToken.class, stack.peek());
        assertEquals(9, ((IntToken) stack.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(2)));
        AddToken addToken1 = new AddToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        addToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        addToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> addToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new BoolToken(true)));
        AddToken addToken2 = new AddToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        addToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(2, stack2.peek().getValue());
        addToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        assertThrows(RuntimeException.class, () -> addToken2.stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        AddToken addToken1 = new AddToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        addToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> addToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        AddToken addToken2 = new AddToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(1, tokens2.size());
        addToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> addToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2)));
        AddToken addToken1 = new AddToken(tokens1);
        assertEquals("1 2 ADD", addToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(1)));
        AddToken addToken2 = new AddToken(tokens2);
        assertEquals("2 1 ADD", addToken2.toString());
    }
}
