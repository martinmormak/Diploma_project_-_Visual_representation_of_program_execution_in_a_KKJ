package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DupTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4)));
        DupToken dupToken1 = new DupToken(tokens1);
        assertNull(dupToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        DupToken dupToken2 = new DupToken(tokens2);
        assertNull(dupToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7)));
        DupToken dupToken1 = new DupToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = dupToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("7 DUP -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-7)));
        DupToken dupToken2 = new DupToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = dupToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("-7 DUP -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new BoolToken(false)));
        DupToken dupToken = new DupToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> dupToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        DupToken dupToken = new DupToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> dupToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3)));
        DupToken dupToken1 = new DupToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        dupToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(3, stack1.peek().getValue());
        dupToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(3, ((IntToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        DupToken dupToken2 = new DupToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        dupToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(false, stack2.peek().getValue());
        dupToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        DupToken dupToken = new DupToken(tokens);
        Stack<IToken> stack = new Stack<>();
        Exception exception1 = assertThrows(RuntimeException.class, () -> dupToken.stackSolving(stack));
        assertTrue(exception1.getMessage().contains("In stack must be >= 1 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1)));
        DupToken dupToken1 = new DupToken(tokens1);
        assertEquals("1 DUP", dupToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        DupToken dupToken2 = new DupToken(tokens2);
        assertEquals("TRUE DUP", dupToken2.toString());
    }
}
