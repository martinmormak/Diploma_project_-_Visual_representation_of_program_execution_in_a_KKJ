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

class PopTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new PopToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(3, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new PopToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(0, stack2.size());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new PopToken()));
        Stack<IToken> stack1 = new Stack<>();
        Exception exception1 = assertThrows(RuntimeException.class, () -> tokens1.removeFirst().stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 1 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1), new PopToken()));
        CombinationToken combinationToken1 = new CombinationToken(tokens1);
        assertEquals("( 1 POP )", combinationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new PopToken()));
        CombinationToken combinationToken2 = new CombinationToken(tokens2);
        assertEquals("( TRUE POP )", combinationToken2.toString());
    }
}
