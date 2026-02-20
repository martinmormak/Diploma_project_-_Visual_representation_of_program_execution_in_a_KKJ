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

class ClearTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false), new ClearToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(false, ((BoolToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertInstanceOf(BoolToken.class, stack1.peek());
        assertEquals(false, ((BoolToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(8), new IntToken(4), new ClearToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(8, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(4, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(0, stack2.size());
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false), new ClearToken()));
        CombinationToken combinationToken1 = new CombinationToken(tokens1);
        assertEquals("( FALSE FALSE CLEAR )", combinationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new ClearToken()));
        CombinationToken combinationToken2 = new CombinationToken(tokens2);
        assertEquals("( FALSE TRUE CLEAR )", combinationToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false), new ClearToken()));
        CombinationToken combinationToken3 = new CombinationToken(tokens3);
        assertEquals("( TRUE FALSE CLEAR )", combinationToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(true), new ClearToken()));
        CombinationToken combinationToken4 = new CombinationToken(tokens4);
        assertEquals("( TRUE TRUE CLEAR )", combinationToken4.toString());
    }
}
