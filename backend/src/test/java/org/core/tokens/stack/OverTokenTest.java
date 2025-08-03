package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class OverTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new IntToken(5), new OverToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(3, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(5, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(3, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(3, ((IntToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true), new OverToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(3, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(true, ((BoolToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(3, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(3, ((IntToken) stack2.peek()).getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(5), new OverToken()));
        Stack<IToken> stack3 = new Stack<>();
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertInstanceOf(BoolToken.class, stack3.peek());
        assertEquals(false, ((BoolToken) stack3.peek()).getValue());
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertInstanceOf(IntToken.class, stack3.peek());
        assertEquals(5, ((IntToken) stack3.peek()).getValue());
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(3, stack3.size());
        assertInstanceOf(BoolToken.class, stack3.peek());
        assertEquals(false, ((BoolToken) stack3.peek()).getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new OverToken()));
        Stack<IToken> stack4 = new Stack<>();
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(false, ((BoolToken) stack4.peek()).getValue());
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(true, ((BoolToken) stack4.peek()).getValue());
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(3, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(false, ((BoolToken) stack4.peek()).getValue());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2), new OverToken()));
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(2, tokens1.size());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(2, ((IntToken) stack1.peek()).getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> tokens1.removeFirst().stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 2 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new OverToken()));
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(2, tokens2.size());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(true, ((BoolToken) stack2.peek()).getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> tokens2.removeFirst().stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 2 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new IntToken(4), new OverToken()));
        CombinationToken combinationToken1 = new CombinationToken(tokens1);
        assertEquals("1 4 OVER", combinationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(1), new BoolToken(false), new OverToken()));
        CombinationToken combinationToken2 = new CombinationToken(tokens2);
        assertEquals("1 FALSE OVER", combinationToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(4), new OverToken()));
        CombinationToken combinationToken3 = new CombinationToken(tokens3);
        assertEquals("TRUE 4 OVER", combinationToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false), new OverToken()));
        CombinationToken combinationToken4 = new CombinationToken(tokens4);
        assertEquals("TRUE FALSE OVER", combinationToken4.toString());
    }
}
