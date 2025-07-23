package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SwapTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(5)));
        SwapToken swapToken1 = new SwapToken(tokens1);
        assertNull(swapToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(false)));
        SwapToken swapToken2 = new SwapToken(tokens2);
        assertNull(swapToken2.getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(5)));
        SwapToken swapToken3 = new SwapToken(tokens3);
        assertNull(swapToken3.getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        SwapToken swapToken4 = new SwapToken(tokens4);
        assertNull(swapToken4.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7)));
        SwapToken swapToken1 = new SwapToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = swapToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("7 SWAP -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-7)));
        SwapToken swapToken2 = new SwapToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = swapToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("-7 SWAP -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new BoolToken(false)));
        SwapToken swapToken = new SwapToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> swapToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        SwapToken swapToken = new SwapToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> swapToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4),new IntToken(5)));
        SwapToken swapToken1 = new SwapToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        swapToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(4, stack1.peek().getValue());
        swapToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        swapToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(4, stack1.pop().getValue());
        assertEquals(1, stack1.size());
        assertEquals(5, stack1.pop().getValue());
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4),new BoolToken(false)));
        SwapToken swapToken2 = new SwapToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        swapToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(4, stack2.peek().getValue());
        swapToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(false, stack2.peek().getValue());
        swapToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(4, stack2.pop().getValue());
        assertEquals(1, stack2.size());
        assertEquals(false, stack2.pop().getValue());
        assertEquals(0, stack2.size());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(5)));
        SwapToken swapToken3 = new SwapToken(tokens3);
        Stack<IToken> stack3 = new Stack<>();
        swapToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertEquals(true, stack3.peek().getValue());
        swapToken3.stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertEquals(5, stack3.peek().getValue());
        swapToken3.stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertEquals(true, stack3.pop().getValue());
        assertEquals(1, stack3.size());
        assertEquals(5, stack3.pop().getValue());
        assertEquals(0, stack3.size());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        SwapToken swapToken4 = new SwapToken(tokens4);
        Stack<IToken> stack4 = new Stack<>();
        swapToken4.stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertEquals(true, stack4.peek().getValue());
        swapToken4.stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertEquals(false, stack4.peek().getValue());
        swapToken4.stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertEquals(true, stack4.pop().getValue());
        assertEquals(1, stack4.size());
        assertEquals(false, stack4.pop().getValue());
        assertEquals(0, stack4.size());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        SwapToken swapToken1 = new SwapToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        swapToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> swapToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        SwapToken swapToken2 = new SwapToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(1, tokens2.size());
        swapToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> swapToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4),new IntToken(5)));
        SwapToken swapToken1 = new SwapToken(tokens1);
        assertEquals("4 5 SWAP", swapToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4),new BoolToken(false)));
        SwapToken swapToken2 = new SwapToken(tokens2);
        assertEquals("4 FALSE SWAP", swapToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of( new BoolToken(true), new IntToken(5)));
        SwapToken swapToken3 = new SwapToken(tokens3);
        assertEquals("TRUE 5 SWAP", swapToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        SwapToken swapToken4 = new SwapToken(tokens4);
        assertEquals("TRUE FALSE SWAP", swapToken4.toString());
    }
}
