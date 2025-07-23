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

class AndTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        AndToken andToken1 = new AndToken(tokens1);
        assertEquals(false, andToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true)));
        AndToken andToken2 = new AndToken(tokens2);
        assertEquals(false, andToken2.getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        AndToken andToken3 = new AndToken(tokens3);
        assertEquals(false, andToken3.getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(true)));
        AndToken andToken4 = new AndToken(tokens4);
        assertEquals(true, andToken4.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true)));
        AndToken andToken1 = new AndToken(tokens1);
        assertNull(andToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3)));
        AndToken andToken2 = new AndToken(tokens2);
        assertNull(andToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        AndToken andToken1 = new AndToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = andToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(false, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("FALSE FALSE AND -> FALSE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true)));
        AndToken andToken2 = new AndToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = andToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("FALSE TRUE AND -> FALSE", substitutions2.getFirst());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        AndToken andToken3 = new AndToken(tokens3);
        List<String> substitutions3 = new ArrayList<>();
        List<IToken> result3 = andToken3.termRewritingSolving(substitutions3);
        assertEquals(1, result3.size());
        assertInstanceOf(BoolToken.class, result3.getFirst());
        assertEquals(false, ((BoolToken) result3.getFirst()).getValue());
        assertEquals("TRUE FALSE AND -> FALSE", substitutions3.getFirst());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(true)));
        AndToken andToken4 = new AndToken(tokens4);
        List<String> substitutions4 = new ArrayList<>();
        List<IToken> result4 = andToken4.termRewritingSolving(substitutions4);
        assertEquals(1, result4.size());
        assertInstanceOf(BoolToken.class, result4.getFirst());
        assertEquals(true, ((BoolToken) result4.getFirst()).getValue());
        assertEquals("TRUE TRUE AND -> TRUE", substitutions4.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false)));
        AndToken andToken1 = new AndToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> andToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1)));
        AndToken andToken2 = new AndToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> andToken2.termRewritingSolving(substitutions2));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        AndToken andToken1 = new AndToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> andToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        AndToken andToken2 = new AndToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> andToken2.termRewritingSolving(substitutions2));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        AndToken andToken1 = new AndToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        andToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(false, stack1.peek().getValue());
        andToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(false, stack1.peek().getValue());
        andToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(false, ((BoolToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true)));
        AndToken andToken2 = new AndToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        andToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(false, stack2.peek().getValue());
        andToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        andToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        AndToken andToken3 = new AndToken(tokens3);
        Stack<IToken> stack3 = new Stack<>();
        andToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertEquals(true, stack3.peek().getValue());
        andToken3.stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertEquals(false, stack3.peek().getValue());
        andToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertInstanceOf(BoolToken.class, stack3.peek());
        assertEquals(false, ((BoolToken) stack3.peek()).getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(true)));
        AndToken andToken4 = new AndToken(tokens4);
        Stack<IToken> stack4 = new Stack<>();
        andToken4.stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertEquals(true, stack4.peek().getValue());
        andToken4.stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertEquals(true, stack4.peek().getValue());
        andToken4.stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(true, ((BoolToken) stack4.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(2)));
        AndToken andToken1 = new AndToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        andToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        andToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> andToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(2), new BoolToken(true)));
        AndToken andToken2 = new AndToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        andToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(2, stack2.peek().getValue());
        andToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        assertThrows(RuntimeException.class, () -> andToken2.stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        AndToken andToken1 = new AndToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        andToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> andToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        AndToken andToken2 = new AndToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(1, tokens2.size());
        andToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> andToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        AndToken andToken1 = new AndToken(tokens1);
        assertEquals("FALSE FALSE AND", andToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true)));
        AndToken andToken2 = new AndToken(tokens2);
        assertEquals("FALSE TRUE AND", andToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        AndToken andToken3 = new AndToken(tokens3);
        assertEquals("TRUE FALSE AND", andToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(true)));
        AndToken andToken4 = new AndToken(tokens4);
        assertEquals("TRUE TRUE AND", andToken4.toString());
    }
}
