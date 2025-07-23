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

class CmpTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new IntToken(5)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        assertEquals(-1, cmpToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(5), new IntToken(3)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        assertEquals(1, cmpToken2.getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(5), new IntToken(5)));
        CmpToken cmpToken3 = new CmpToken(tokens3);
        assertEquals(0, cmpToken3.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        assertNull(cmpToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        assertNull(cmpToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(6)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = cmpToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(IntToken.class, result1.getFirst());
        assertEquals(-1, ((IntToken) result1.getFirst()).getValue());
        assertEquals("4 6 CMP -> -1", substitutions1.getFirst());


        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(6), new IntToken(4)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = cmpToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(IntToken.class, result2.getFirst());
        assertEquals(1, ((IntToken) result2.getFirst()).getValue());
        assertEquals("6 4 CMP -> 1", substitutions2.getFirst());


        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(6), new IntToken(6)));
        CmpToken cmpToken3 = new CmpToken(tokens3);
        List<String> substitutions3 = new ArrayList<>();
        List<IToken> result3 = cmpToken3.termRewritingSolving(substitutions3);
        assertEquals(1, result3.size());
        assertInstanceOf(IntToken.class, result3.getFirst());
        assertEquals(0, ((IntToken) result3.getFirst()).getValue());
        assertEquals("6 6 CMP -> 0", substitutions3.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> cmpToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> cmpToken2.termRewritingSolving(substitutions2));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> cmpToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> cmpToken2.termRewritingSolving(substitutions2));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7), new IntToken(2)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        cmpToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(7, stack1.peek().getValue());
        cmpToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        cmpToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(1, ((IntToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(7)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        cmpToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(2, stack2.peek().getValue());
        cmpToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(7, stack2.peek().getValue());
        cmpToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(-1, ((IntToken) stack2.peek()).getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(2), new IntToken(2)));
        CmpToken cmpToken3 = new CmpToken(tokens3);
        Stack<IToken> stack3 = new Stack<>();
        cmpToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertEquals(2, stack3.peek().getValue());
        cmpToken3.stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertEquals(2, stack3.peek().getValue());
        cmpToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertInstanceOf(IntToken.class, stack3.peek());
        assertEquals(0, ((IntToken) stack3.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(2)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        cmpToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        cmpToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> cmpToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new BoolToken(true)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        cmpToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(2, stack2.peek().getValue());
        cmpToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        assertThrows(RuntimeException.class, () -> cmpToken2.stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        cmpToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> cmpToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        cmpToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> cmpToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2)));
        CmpToken cmpToken1 = new CmpToken(tokens1);
        assertEquals("1 2 CMP", cmpToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new IntToken(1)));
        CmpToken cmpToken2 = new CmpToken(tokens2);
        assertEquals("2 1 CMP", cmpToken2.toString());
    }
}
