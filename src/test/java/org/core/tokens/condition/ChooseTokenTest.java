package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ChooseTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3), new IntToken(5)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        assertInstanceOf(IntToken.class, chooseToken1.getValue());
        assertEquals(3, chooseToken1.getValue().getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(5), new BoolToken(true)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        assertInstanceOf(BoolToken.class, chooseToken2.getValue());
        assertEquals(true, chooseToken2.getValue().getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(3), new BoolToken(true)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        assertNull(chooseToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(true), new IntToken(3)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        assertNull(chooseToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(4), new IntToken(6)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = chooseToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(IntToken.class, result1.getFirst());
        assertEquals(4, ((IntToken) result1.getFirst()).getValue());
        assertEquals("TRUE 4 6 CHOOSE -> 4", substitutions1.getFirst());


        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(4), new IntToken(6)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = chooseToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(IntToken.class, result2.getFirst());
        assertEquals(6, ((IntToken) result2.getFirst()).getValue());
        assertEquals("FALSE 4 6 CHOOSE -> 6", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(3), new BoolToken(false)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> chooseToken1.termRewritingSolving(substitutions1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false), new IntToken(3)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> chooseToken2.termRewritingSolving(substitutions2));
    }*/

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        assertThrows(RuntimeException.class, () -> new ChooseToken(tokens1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false)));
        assertThrows(RuntimeException.class, () -> new ChooseToken(tokens2));
    }

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(7), new IntToken(2)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        chooseToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(true, stack1.peek().getValue());
        chooseToken1.stackSolving(stack1);
        assertEquals(0, stack1.size());
        chooseToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(7, ((IntToken) stack1.peek()).getValue());


        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(7), new IntToken(2)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        Stack<IToken> stack = new Stack<>();
        chooseToken2.stackSolving(stack);
        assertEquals(1, stack.size());
        assertEquals(false, stack.peek().getValue());
        chooseToken2.stackSolving(stack);
        assertEquals(0, stack.size());
        chooseToken2.stackSolving(stack);
        assertEquals(1, stack.size());
        assertInstanceOf(IntToken.class, stack.peek());
        assertEquals(2, ((IntToken) stack.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(true), new IntToken(2)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        chooseToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(1, stack1.peek().getValue());
        assertThrows(RuntimeException.class, () -> chooseToken1.stackSolving(stack1));

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new IntToken(2), new BoolToken(true)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        chooseToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(1, stack2.peek().getValue());
        assertThrows(RuntimeException.class, () -> chooseToken2.stackSolving(stack2));
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        Exception exception1 = assertThrows(RuntimeException.class, () -> new ChooseToken(tokens1));
        assertTrue(exception1.getMessage().contains("Expected three tokens but don't get it for WhileToken"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        Exception exception2 = assertThrows(RuntimeException.class, () -> new ChooseToken(tokens2));
        assertTrue(exception2.getMessage().contains("Expected three tokens but don't get it for WhileToken"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(1), new IntToken(2)));
        ChooseToken chooseToken1 = new ChooseToken(tokens1);
        assertEquals("TRUE 1 2 CHOOSE", chooseToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(1), new IntToken(2)));
        ChooseToken chooseToken2 = new ChooseToken(tokens2);
        assertEquals("FALSE 1 2 CHOOSE", chooseToken2.toString());
    }
}
