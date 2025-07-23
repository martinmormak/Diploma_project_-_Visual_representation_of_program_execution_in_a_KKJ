package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class IsPosTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4)));
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        assertEquals(true, isPosToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-4)));
        IsPosToken isPosToken2 = new IsPosToken(tokens2);
        assertEquals(false, isPosToken2.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true)));
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        assertNull(isPosToken1.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7)));
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = isPosToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("7 ISPOS -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-7)));
        IsPosToken isPosToken2 = new IsPosToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = isPosToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("-7 ISPOS -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new BoolToken(false)));
        IsPosToken isPosToken = new IsPosToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> isPosToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        IsPosToken isPosToken = new IsPosToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> isPosToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3)));
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        isPosToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(3, stack1.peek().getValue());
        isPosToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(true, ((BoolToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-3)));
        IsPosToken isPosToken2 = new IsPosToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        isPosToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(-3, stack2.peek().getValue());
        isPosToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true)));
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        isPosToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> isPosToken1.stackSolving(stack1));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of());
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        Exception exception1 = assertThrows(RuntimeException.class, () -> isPosToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 1 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1)));
        IsPosToken isPosToken1 = new IsPosToken(tokens1);
        assertEquals("1 ISPOS", isPosToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-1)));
        IsPosToken isPosToken2 = new IsPosToken(tokens2);
        assertEquals("-1 ISPOS", isPosToken2.toString());
    }
}
