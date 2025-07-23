package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class WhileTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        assertInstanceOf(IntToken.class, whileToken1.getValue());
        assertEquals(3, whileToken1.getValue().getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(true)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        assertNull(whileToken1.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(4), new IntToken(6)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = whileToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(IntToken.class, result1.getFirst());
        assertEquals(4, ((IntToken) result1.getFirst()).getValue());
        assertEquals("TRUE 4 6 WHILE -> 4", substitutions1.getFirst());


        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(4), new IntToken(6)));
        WhileToken whileToken2 = new WhileToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = whileToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(IntToken.class, result2.getFirst());
        assertEquals(6, ((IntToken) result2.getFirst()).getValue());
        assertEquals("FALSE 4 6 WHILE -> 6", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(3), new BoolToken(false)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> whileToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false), new IntToken(3)));
        WhileToken whileToken2 = new WhileToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> whileToken2.termRewritingSolving(substitutions2));
    }*/

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        assertThrows(RuntimeException.class, () -> new WhileToken(tokens1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        assertThrows(RuntimeException.class, () -> new WhileToken(tokens2));
    }

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(7)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        whileToken1.stackSolving(stack1);
        IToken iToken1 = whileToken1.stackSolving(stack1).getFirst();
        assertInstanceOf(ChooseToken.class, iToken1);
        assertEquals(0, stack1.size());
        iToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        iToken1.stackSolving(stack1);
        assertEquals(0, stack1.size());
        iToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(7, ((IntToken) stack1.peek()).getValue());


        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(7)));
        WhileToken whileToken2 = new WhileToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        IToken iToken2 = whileToken2.stackSolving(stack2).getFirst();
        assertInstanceOf(ChooseToken.class, iToken2);
        assertEquals(0, stack2.size());
        iToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(false, stack2.peek().getValue());
        iToken2.stackSolving(stack2);
        assertEquals(0, stack2.size());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        whileToken1.stackSolving(stack1);
        IToken iToken1 = whileToken1.stackSolving(stack1).getFirst();
        assertInstanceOf(ChooseToken.class, iToken1);
        iToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(1, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> iToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(true)));
        WhileToken whileToken2 = new WhileToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        whileToken2.stackSolving(stack2);
        IToken iToken2 = whileToken2.stackSolving(stack2).getFirst();
        assertInstanceOf(ChooseToken.class, iToken1);
        iToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(1, stack2.peek().getValue());
        assertThrows(RuntimeException.class, () -> iToken1.stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        Exception exception1 = assertThrows(RuntimeException.class, () -> new WhileToken(tokens1));
        assertTrue(exception1.getMessage().contains("Expected two tokens but don't get it for WhileToken"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        Exception exception2 = assertThrows(RuntimeException.class, () -> new WhileToken(tokens2));
        assertTrue(exception2.getMessage().contains("Expected two tokens but don't get it for WhileToken"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(1), new IntToken(2)));
        WhileToken whileToken1 = new WhileToken(tokens1);
        assertEquals("TRUE 1 2 WHILE", whileToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1), new IntToken(2)));
        WhileToken whileToken2 = new WhileToken(tokens2);
        assertEquals("FALSE 1 2 WHILE", whileToken2.toString());
    }
}
