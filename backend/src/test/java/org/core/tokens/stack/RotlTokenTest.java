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

class RotlTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new IntToken(5), new RotlToken()));
        Stack<IToken> stack1 = new Stack<>();
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(4, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(8, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(3, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(5, ((IntToken) stack1.peek()).getValue());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(3, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(4, ((IntToken) stack1.pop()).getValue());
        assertEquals(2, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(5, ((IntToken) stack1.pop()).getValue());
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(8, ((IntToken) stack1.pop()).getValue());
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new BoolToken(false), new RotlToken()));
        Stack<IToken> stack2 = new Stack<>();
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(4, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(8, ((IntToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(3, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.peek()).getValue());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(3, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(4, ((IntToken) stack2.pop()).getValue());
        assertEquals(2, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(false, ((BoolToken) stack2.pop()).getValue());
        assertEquals(1, stack2.size());
        assertInstanceOf(IntToken.class, stack2.peek());
        assertEquals(8, ((IntToken) stack2.pop()).getValue());
        assertEquals(0, stack2.size());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new IntToken(5), new RotlToken()));
        Stack<IToken> stack3 = new Stack<>();
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertInstanceOf(IntToken.class, stack3.peek());
        assertEquals(4, ((IntToken) stack3.peek()).getValue());
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertInstanceOf(BoolToken.class, stack3.peek());
        assertEquals(true, ((BoolToken) stack3.peek()).getValue());
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(3, stack3.size());
        assertInstanceOf(IntToken.class, stack3.peek());
        assertEquals(5, ((IntToken) stack3.peek()).getValue());
        tokens3.removeFirst().stackSolving(stack3);
        assertEquals(3, stack3.size());
        assertInstanceOf(IntToken.class, stack3.peek());
        assertEquals(4, ((IntToken) stack3.pop()).getValue());
        assertEquals(2, stack3.size());
        assertInstanceOf(IntToken.class, stack3.peek());
        assertEquals(5, ((IntToken) stack3.pop()).getValue());
        assertEquals(1, stack3.size());
        assertInstanceOf(BoolToken.class, stack3.peek());
        assertEquals(true, ((BoolToken) stack3.pop()).getValue());
        assertEquals(0, stack3.size());

        List<IToken> tokens4 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new BoolToken(false), new RotlToken()));
        Stack<IToken> stack4 = new Stack<>();
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertInstanceOf(IntToken.class, stack4.peek());
        assertEquals(4, ((IntToken) stack4.peek()).getValue());
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(true, ((BoolToken) stack4.peek()).getValue());
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(3, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(false, ((BoolToken) stack4.peek()).getValue());
        tokens4.removeFirst().stackSolving(stack4);
        assertEquals(3, stack4.size());
        assertInstanceOf(IntToken.class, stack4.peek());
        assertEquals(4, ((IntToken) stack4.pop()).getValue());
        assertEquals(2, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(false, ((BoolToken) stack4.pop()).getValue());
        assertEquals(1, stack4.size());
        assertInstanceOf(BoolToken.class, stack4.peek());
        assertEquals(true, ((BoolToken) stack4.pop()).getValue());
        assertEquals(0, stack4.size());

        List<IToken> tokens5 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new IntToken(5), new RotlToken()));
        Stack<IToken> stack5 = new Stack<>();
        tokens5.removeFirst().stackSolving(stack5);
        assertEquals(1, stack5.size());
        assertInstanceOf(BoolToken.class, stack5.peek());
        assertEquals(false, ((BoolToken) stack5.peek()).getValue());
        tokens5.removeFirst().stackSolving(stack5);
        assertEquals(2, stack5.size());
        assertInstanceOf(IntToken.class, stack5.peek());
        assertEquals(8, ((IntToken) stack5.peek()).getValue());
        tokens5.removeFirst().stackSolving(stack5);
        assertEquals(3, stack5.size());
        assertInstanceOf(IntToken.class, stack5.peek());
        assertEquals(5, ((IntToken) stack5.peek()).getValue());
        tokens5.removeFirst().stackSolving(stack5);
        assertEquals(3, stack5.size());
        assertInstanceOf(BoolToken.class, stack5.peek());
        assertEquals(false, ((BoolToken) stack5.pop()).getValue());
        assertEquals(2, stack5.size());
        assertInstanceOf(IntToken.class, stack5.peek());
        assertEquals(5, ((IntToken) stack5.pop()).getValue());
        assertEquals(1, stack5.size());
        assertInstanceOf(IntToken.class, stack5.peek());
        assertEquals(8, ((IntToken) stack5.pop()).getValue());
        assertEquals(0, stack5.size());

        List<IToken> tokens6 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new BoolToken(false), new RotlToken()));
        Stack<IToken> stack6 = new Stack<>();
        tokens6.removeFirst().stackSolving(stack6);
        assertEquals(1, stack6.size());
        assertInstanceOf(BoolToken.class, stack6.peek());
        assertEquals(false, ((BoolToken) stack6.peek()).getValue());
        tokens6.removeFirst().stackSolving(stack6);
        assertEquals(2, stack6.size());
        assertInstanceOf(IntToken.class, stack6.peek());
        assertEquals(8, ((IntToken) stack6.peek()).getValue());
        tokens6.removeFirst().stackSolving(stack6);
        assertEquals(3, stack6.size());
        assertInstanceOf(BoolToken.class, stack6.peek());
        assertEquals(false, ((BoolToken) stack6.peek()).getValue());
        tokens6.removeFirst().stackSolving(stack6);
        assertEquals(3, stack6.size());
        assertInstanceOf(BoolToken.class, stack6.peek());
        assertEquals(false, ((BoolToken) stack6.pop()).getValue());
        assertEquals(2, stack6.size());
        assertInstanceOf(BoolToken.class, stack6.peek());
        assertEquals(false, ((BoolToken) stack6.pop()).getValue());
        assertEquals(1, stack6.size());
        assertInstanceOf(IntToken.class, stack6.peek());
        assertEquals(8, ((IntToken) stack6.pop()).getValue());
        assertEquals(0, stack6.size());

        List<IToken> tokens7 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new IntToken(5), new RotlToken()));
        Stack<IToken> stack7 = new Stack<>();
        tokens7.removeFirst().stackSolving(stack7);
        assertEquals(1, stack7.size());
        assertInstanceOf(BoolToken.class, stack7.peek());
        assertEquals(false, ((BoolToken) stack7.peek()).getValue());
        tokens7.removeFirst().stackSolving(stack7);
        assertEquals(2, stack7.size());
        assertInstanceOf(BoolToken.class, stack7.peek());
        assertEquals(true, ((BoolToken) stack7.peek()).getValue());
        tokens7.removeFirst().stackSolving(stack7);
        assertEquals(3, stack7.size());
        assertInstanceOf(IntToken.class, stack7.peek());
        assertEquals(5, ((IntToken) stack7.peek()).getValue());
        tokens7.removeFirst().stackSolving(stack7);
        assertEquals(3, stack7.size());
        assertInstanceOf(BoolToken.class, stack7.peek());
        assertEquals(false, ((BoolToken) stack7.pop()).getValue());
        assertEquals(2, stack7.size());
        assertInstanceOf(IntToken.class, stack7.peek());
        assertEquals(5, ((IntToken) stack7.pop()).getValue());
        assertEquals(1, stack7.size());
        assertInstanceOf(BoolToken.class, stack7.peek());
        assertEquals(true, ((BoolToken) stack7.pop()).getValue());
        assertEquals(0, stack7.size());

        List<IToken> tokens8 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new BoolToken(false), new RotlToken()));
        Stack<IToken> stack8 = new Stack<>();
        tokens8.removeFirst().stackSolving(stack8);
        assertEquals(1, stack8.size());
        assertInstanceOf(BoolToken.class, stack8.peek());
        assertEquals(false, ((BoolToken) stack8.peek()).getValue());
        tokens8.removeFirst().stackSolving(stack8);
        assertEquals(2, stack8.size());
        assertInstanceOf(BoolToken.class, stack8.peek());
        assertEquals(true, ((BoolToken) stack8.peek()).getValue());
        tokens8.removeFirst().stackSolving(stack8);
        assertEquals(3, stack8.size());
        assertInstanceOf(BoolToken.class, stack8.peek());
        assertEquals(false, ((BoolToken) stack8.peek()).getValue());
        tokens8.removeFirst().stackSolving(stack8);
        assertEquals(3, stack8.size());
        assertInstanceOf(BoolToken.class, stack8.peek());
        assertEquals(false, ((BoolToken) stack8.pop()).getValue());
        assertEquals(2, stack8.size());
        assertInstanceOf(BoolToken.class, stack8.peek());
        assertEquals(false, ((BoolToken) stack8.pop()).getValue());
        assertEquals(1, stack8.size());
        assertInstanceOf(BoolToken.class, stack8.peek());
        assertEquals(true, ((BoolToken) stack8.pop()).getValue());
        assertEquals(0, stack8.size());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2), new RotlToken()));
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(2, tokens1.size());
        tokens1.removeFirst().stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(2, ((IntToken) stack1.peek()).getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> tokens1.removeFirst().stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 3 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new RotlToken()));
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(2, tokens2.size());
        tokens2.removeFirst().stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(true, ((BoolToken) stack2.peek()).getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> tokens2.removeFirst().stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 3 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new IntToken(5), new RotlToken()));
        CombinationToken combinationToken1 = new CombinationToken(tokens1);
        assertEquals("( 4 8 5 ROTL )", combinationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new BoolToken(false), new RotlToken()));
        CombinationToken combinationToken2 = new CombinationToken(tokens2);
        assertEquals("( 4 8 FALSE ROTL )", combinationToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new IntToken(5), new RotlToken()));
        CombinationToken combinationToken3 = new CombinationToken(tokens3);
        assertEquals("( 4 TRUE 5 ROTL )", combinationToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new BoolToken(false), new RotlToken()));
        CombinationToken combinationToken4 = new CombinationToken(tokens4);
        assertEquals("( 4 TRUE FALSE ROTL )", combinationToken4.toString());

        List<IToken> tokens5 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new IntToken(5), new RotlToken()));
        CombinationToken combinationToken5 = new CombinationToken(tokens5);
        assertEquals("( FALSE 8 5 ROTL )", combinationToken5.toString());

        List<IToken> tokens6 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new BoolToken(false), new RotlToken()));
        CombinationToken combinationToken6 = new CombinationToken(tokens6);
        assertEquals("( FALSE 8 FALSE ROTL )", combinationToken6.toString());

        List<IToken> tokens7 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new IntToken(5), new RotlToken()));
        CombinationToken combinationToken7 = new CombinationToken(tokens7);
        assertEquals("( FALSE TRUE 5 ROTL )", combinationToken7.toString());

        List<IToken> tokens8 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new BoolToken(false), new RotlToken()));
        CombinationToken combinationToken8 = new CombinationToken(tokens8);
        assertEquals("( FALSE TRUE FALSE ROTL )", combinationToken8.toString());
    }
}
