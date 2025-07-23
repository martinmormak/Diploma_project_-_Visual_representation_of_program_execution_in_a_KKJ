package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class OverTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8)));
        OverToken overToken1 = new OverToken(tokens1);
        assertNull(overToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(false)));
        OverToken overToken2 = new OverToken(tokens2);
        assertNull(overToken2.getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(8)));
        OverToken overToken3 = new OverToken(tokens3);
        assertNull(overToken3.getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        OverToken overToken4 = new OverToken(tokens4);
        assertNull(overToken4.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7)));
        OverToken overToken1 = new OverToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = overToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("7 OVER -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-7)));
        OverToken overToken2 = new OverToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = overToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("-7 OVER -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new BoolToken(false)));
        OverToken overToken = new OverToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> overToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        OverToken overToken = new OverToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> overToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new IntToken(5)));
        OverToken overToken1 = new OverToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        overToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(3, stack1.peek().getValue());
        overToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(5, stack1.peek().getValue());
        overToken1.stackSolving(stack1);
        assertEquals(3, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(3, ((IntToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true)));
        OverToken overToken2 = new OverToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        overToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(3, stack2.peek().getValue());
        overToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        overToken2.stackSolving(stack2);
        assertEquals(3, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(3, ((IntToken) stack2.peek()).getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(5)));
        OverToken overToken3 = new OverToken(tokens3);
        Stack<IToken> stack3 = new Stack<>();
        overToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertEquals(false, stack3.peek().getValue());
        overToken3.stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertEquals(5, stack3.peek().getValue());
        overToken3.stackSolving(stack3);
        assertEquals(3, stack3.size());
        assertInstanceOf(BoolToken.class, stack3.peek());
        assertEquals(false, ((BoolToken) stack3.peek()).getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true)));
        OverToken overToken4 = new OverToken(tokens4);
        Stack<IToken> stack4 = new Stack<>();
        overToken4.stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertEquals(false, stack4.peek().getValue());
        overToken4.stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertEquals(true, stack4.peek().getValue());
        overToken4.stackSolving(stack4);
        assertEquals(3, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(false, ((BoolToken) stack4.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        OverToken overToken1 = new OverToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        overToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> overToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        OverToken overToken2 = new OverToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(1, tokens2.size());
        overToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> overToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(4)));
        OverToken overToken1 = new OverToken(tokens1);
        assertEquals("1 4 OVER", overToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false)));
        OverToken overToken2 = new OverToken(tokens2);
        assertEquals("1 FALSE OVER", overToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(4)));
        OverToken overToken3 = new OverToken(tokens3);
        assertEquals("TRUE 4 OVER", overToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        OverToken overToken4 = new OverToken(tokens4);
        assertEquals("TRUE FALSE OVER", overToken4.toString());
    }
}
