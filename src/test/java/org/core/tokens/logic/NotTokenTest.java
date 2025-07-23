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

class NotTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false)));
        NotToken notToken1 = new NotToken(tokens1);
        assertEquals(true, notToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        NotToken notToken2 = new NotToken(tokens2);
        assertEquals(false, notToken2.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1)));
        NotToken notToken1 = new NotToken(tokens1);
        assertNull(notToken1.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false)));
        NotToken notToken1 = new NotToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = notToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("FALSE NOT -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        NotToken notToken2 = new NotToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = notToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("TRUE NOT -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new IntToken(1)));
        NotToken notToken = new NotToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> notToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        NotToken notToken = new NotToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> notToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false)));
        NotToken notToken1 = new NotToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        notToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(false, stack1.peek().getValue());
        notToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(true, ((BoolToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        NotToken notToken2 = new NotToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        notToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        notToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        NotToken notToken1 = new NotToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        notToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(5, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> notToken1.stackSolving(stack1));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of());
        NotToken notToken1 = new NotToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        Exception exception1 = assertThrows(RuntimeException.class, () -> notToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 1 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false)));
        NotToken notToken1 = new NotToken(tokens1);
        assertEquals("FALSE NOT", notToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        NotToken notToken2 = new NotToken(tokens2);
        assertEquals("TRUE NOT", notToken2.toString());
    }
}
