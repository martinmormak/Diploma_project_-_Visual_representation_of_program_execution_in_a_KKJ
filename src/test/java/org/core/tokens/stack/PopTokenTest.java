package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PopTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4)));
        PopToken popToken1 = new PopToken(tokens1);
        assertNull(popToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        PopToken popToken2 = new PopToken(tokens2);
        assertNull(popToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7)));
        PopToken popToken1 = new PopToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = popToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("7 POP -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-7)));
        PopToken popToken2 = new PopToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = popToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("-7 POP -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new BoolToken(false)));
        PopToken popToken = new PopToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> popToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        PopToken popToken = new PopToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> popToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3)));
        PopToken popToken1 = new PopToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        popToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(3, stack1.peek().getValue());
        popToken1.stackSolving(stack1);
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        PopToken popToken2 = new PopToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        popToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(false, stack2.peek().getValue());
        popToken2.stackSolving(stack2);
        assertEquals(0, stack2.size());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        PopToken popToken = new PopToken(tokens);
        Stack<IToken> stack = new Stack<>();
        Exception exception1 = assertThrows(RuntimeException.class, () -> popToken.stackSolving(stack));
        assertTrue(exception1.getMessage().contains("In stack must be >= 1 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1)));
        PopToken popToken1 = new PopToken(tokens1);
        assertEquals("1 POP", popToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        PopToken popToken2 = new PopToken(tokens2);
        assertEquals("TRUE POP", popToken2.toString());
    }
}
