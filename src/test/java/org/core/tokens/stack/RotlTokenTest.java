package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class RotlTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new IntToken(5)));
        RotlToken rotlToken1 = new RotlToken(tokens1);
        assertNull(rotlToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new BoolToken(false)));
        RotlToken rotlToken2 = new RotlToken(tokens2);
        assertNull(rotlToken2.getValue());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new IntToken(5)));
        RotlToken rotlToken3 = new RotlToken(tokens3);
        assertNull(rotlToken3.getValue());

        List<IToken> tokens4 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new BoolToken(false)));
        RotlToken rotlToken4 = new RotlToken(tokens4);
        assertNull(rotlToken4.getValue());

        List<IToken> tokens5 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new IntToken(5)));
        RotlToken rotlToken5 = new RotlToken(tokens5);
        assertNull(rotlToken5.getValue());

        List<IToken> tokens6 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new BoolToken(false)));
        RotlToken rotlToken6 = new RotlToken(tokens6);
        assertNull(rotlToken6.getValue());

        List<IToken> tokens7 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new IntToken(5)));
        RotlToken rotlToken7 = new RotlToken(tokens7);
        assertNull(rotlToken7.getValue());

        List<IToken> tokens8 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new BoolToken(false)));
        RotlToken rotlToken8 = new RotlToken(tokens8);
        assertNull(rotlToken8.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(7)));
        RotlToken rotlToken1 = new RotlToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = rotlToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(BoolToken.class, result1.getFirst());
        assertEquals(true, ((BoolToken) result1.getFirst()).getValue());
        assertEquals("7 ROTL -> TRUE", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(-7)));
        RotlToken rotlToken2 = new RotlToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = rotlToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(false, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("-7 ROTL -> FALSE", substitutions2.getFirst());
    }

    @Test
    void testTermRewritingInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new BoolToken(false)));
        RotlToken rotlToken = new RotlToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> rotlToken.termRewritingSolving(substitutions));
    }

    @Test
    void testTermRewritingWithInsufficientTokens() {
        List<IToken> tokens = new LinkedList<>(List.of());
        RotlToken rotlToken = new RotlToken(tokens);
        List<String> substitutions = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> rotlToken.termRewritingSolving(substitutions));
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new IntToken(5)));
        RotlToken rotlToken1 = new RotlToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        rotlToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(4, stack1.peek().getValue());
        rotlToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(8, stack1.peek().getValue());
        rotlToken1.stackSolving(stack1);
        assertEquals(3, stack1.size());
        assertEquals(5, stack1.peek().getValue());
        assertEquals(5, stack1.peek().getValue());
        rotlToken1.stackSolving(stack1);
        assertEquals(3, stack1.size());
        assertEquals(4, stack1.pop().getValue());
        assertEquals(2, stack1.size());
        assertEquals(5, stack1.pop().getValue());
        assertEquals(1, stack1.size());
        assertEquals(8, stack1.pop().getValue());
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new BoolToken(false)));
        RotlToken rotlToken2 = new RotlToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        rotlToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(4, stack2.peek().getValue());
        rotlToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(8, stack2.peek().getValue());
        rotlToken2.stackSolving(stack2);
        assertEquals(3, stack2.size());
        assertEquals(false, stack2.peek().getValue());
        rotlToken2.stackSolving(stack2);
        assertEquals(3, stack2.size());
        assertEquals(4, stack2.pop().getValue());
        assertEquals(2, stack2.size());
        assertEquals(false, stack2.pop().getValue());
        assertEquals(1, stack2.size());
        assertEquals(8, stack2.pop().getValue());
        assertEquals(0, stack2.size());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new IntToken(5)));
        RotlToken rotlToken3 = new RotlToken(tokens3);
        Stack<IToken> stack3 = new Stack<>();
        rotlToken3.stackSolving(stack3);
        assertEquals(1, stack3.size());
        assertEquals(4, stack3.peek().getValue());
        rotlToken3.stackSolving(stack3);
        assertEquals(2, stack3.size());
        assertEquals(true, stack3.peek().getValue());
        rotlToken3.stackSolving(stack3);
        assertEquals(3, stack3.size());
        assertEquals(5, stack3.peek().getValue());
        rotlToken3.stackSolving(stack3);
        assertEquals(3, stack3.size());
        assertEquals(4, stack3.pop().getValue());
        assertEquals(2, stack3.size());
        assertEquals(5, stack3.pop().getValue());
        assertEquals(1, stack3.size());
        assertEquals(true, stack3.pop().getValue());
        assertEquals(0, stack3.size());

        List<IToken> tokens4 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new BoolToken(false)));
        RotlToken rotlToken4 = new RotlToken(tokens4);
        Stack<IToken> stack4 = new Stack<>();
        rotlToken4.stackSolving(stack4);
        assertEquals(1, stack4.size());
        assertEquals(4, stack4.peek().getValue());
        rotlToken4.stackSolving(stack4);
        assertEquals(2, stack4.size());
        assertEquals(true, stack4.peek().getValue());
        rotlToken4.stackSolving(stack4);
        assertEquals(3, stack4.size());
        assertEquals(false, stack4.peek().getValue());
        rotlToken4.stackSolving(stack4);
        assertEquals(3, stack4.size());
        assertEquals(4, stack4.pop().getValue());
        assertEquals(2, stack4.size());
        assertEquals(false, stack4.pop().getValue());
        assertEquals(1, stack4.size());
        assertEquals(true, stack4.pop().getValue());
        assertEquals(0, stack4.size());

        List<IToken> tokens5 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new IntToken(5)));
        RotlToken rotlToken5 = new RotlToken(tokens5);
        Stack<IToken> stack5 = new Stack<>();
        rotlToken5.stackSolving(stack5);
        assertEquals(1, stack5.size());
        assertEquals(false, stack5.peek().getValue());
        rotlToken5.stackSolving(stack5);
        assertEquals(2, stack5.size());
        assertEquals(8, stack5.peek().getValue());
        rotlToken5.stackSolving(stack5);
        assertEquals(3, stack5.size());
        assertEquals(5, stack5.peek().getValue());
        rotlToken5.stackSolving(stack5);
        assertEquals(3, stack5.size());
        assertEquals(false, stack5.pop().getValue());
        assertEquals(2, stack5.size());
        assertEquals(5, stack5.pop().getValue());
        assertEquals(1, stack5.size());
        assertEquals(8, stack5.pop().getValue());
        assertEquals(0, stack5.size());

        List<IToken> tokens6 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new BoolToken(false)));
        RotlToken rotlToken6 = new RotlToken(tokens6);
        Stack<IToken> stack6 = new Stack<>();
        rotlToken6.stackSolving(stack6);
        assertEquals(1, stack6.size());
        assertEquals(false, stack6.peek().getValue());
        rotlToken6.stackSolving(stack6);
        assertEquals(2, stack6.size());
        assertEquals(8, stack6.peek().getValue());
        rotlToken6.stackSolving(stack6);
        assertEquals(3, stack6.size());
        assertEquals(false, stack6.peek().getValue());
        rotlToken6.stackSolving(stack6);
        assertEquals(3, stack6.size());
        assertEquals(false, stack6.pop().getValue());
        assertEquals(2, stack6.size());
        assertEquals(false, stack6.pop().getValue());
        assertEquals(1, stack6.size());
        assertEquals(8, stack6.pop().getValue());
        assertEquals(0, stack6.size());

        List<IToken> tokens7 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new IntToken(5)));
        RotlToken rotlToken7 = new RotlToken(tokens7);
        Stack<IToken> stack7 = new Stack<>();
        rotlToken7.stackSolving(stack7);
        assertEquals(1, stack7.size());
        assertEquals(false, stack7.peek().getValue());
        rotlToken7.stackSolving(stack7);
        assertEquals(2, stack7.size());
        assertEquals(true, stack7.peek().getValue());
        rotlToken7.stackSolving(stack7);
        assertEquals(3, stack7.size());
        assertEquals(5, stack7.peek().getValue());
        rotlToken7.stackSolving(stack7);
        assertEquals(3, stack7.size());
        assertEquals(false, stack7.pop().getValue());
        assertEquals(2, stack7.size());
        assertEquals(5, stack7.pop().getValue());
        assertEquals(1, stack7.size());
        assertEquals(true, stack7.pop().getValue());
        assertEquals(0, stack7.size());

        List<IToken> tokens8 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new BoolToken(false)));
        RotlToken rotlToken8 = new RotlToken(tokens8);
        Stack<IToken> stack8 = new Stack<>();
        rotlToken8.stackSolving(stack8);
        assertEquals(1, stack8.size());
        assertEquals(false, stack8.peek().getValue());
        rotlToken8.stackSolving(stack8);
        assertEquals(2, stack8.size());
        assertEquals(true, stack8.peek().getValue());
        rotlToken8.stackSolving(stack8);
        assertEquals(3, stack8.size());
        assertEquals(false, stack8.peek().getValue());
        rotlToken8.stackSolving(stack8);
        assertEquals(3, stack8.size());
        assertEquals(false, stack8.pop().getValue());
        assertEquals(2, stack8.size());
        assertEquals(false, stack8.pop().getValue());
        assertEquals(1, stack8.size());
        assertEquals(true, stack8.pop().getValue());
        assertEquals(0, stack8.size());
    }

    @Test
    void testStackSolvingWithInsufficientTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of( new IntToken(2)));
        RotlToken rotlToken1 = new RotlToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        assertEquals(1, tokens1.size());
        rotlToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(2, stack1.peek().getValue());
        Exception exception1 = assertThrows(RuntimeException.class, () -> rotlToken1.stackSolving(stack1));
        assertTrue(exception1.getMessage().contains("In stack must be >= 3 items"));

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        RotlToken rotlToken2 = new RotlToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        assertEquals(1, tokens2.size());
        rotlToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        Exception exception2 = assertThrows(RuntimeException.class, () -> rotlToken2.stackSolving(stack2));
        assertTrue(exception2.getMessage().contains("In stack must be >= 3 items"));
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new IntToken(5)));
        RotlToken rotlToken1 = new RotlToken(tokens1);
        assertEquals("4 8 5 ROTL", rotlToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(4), new IntToken(8), new BoolToken(false)));
        RotlToken rotlToken2 = new RotlToken(tokens2);
        assertEquals("4 8 FALSE ROTL", rotlToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new IntToken(5)));
        RotlToken rotlToken3 = new RotlToken(tokens3);
        assertEquals("4 TRUE 5 ROTL", rotlToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new IntToken(4), new BoolToken(true), new BoolToken(false)));
        RotlToken rotlToken4 = new RotlToken(tokens4);
        assertEquals("4 TRUE FALSE ROTL", rotlToken4.toString());

        List<IToken> tokens5 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new IntToken(5)));
        RotlToken rotlToken5 = new RotlToken(tokens5);
        assertEquals("FALSE 8 5 ROTL", rotlToken5.toString());
        List<IToken> tokens6 = new LinkedList<>(List.of(new BoolToken(false), new IntToken(8), new BoolToken(false)));
        RotlToken rotlToken6 = new RotlToken(tokens6);
        assertEquals("FALSE 8 FALSE ROTL", rotlToken6.toString());

        List<IToken> tokens7 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new IntToken(5)));
        RotlToken rotlToken7 = new RotlToken(tokens7);
        assertEquals("FALSE TRUE 5 ROTL", rotlToken7.toString());

        List<IToken> tokens8 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true), new BoolToken(false)));
        RotlToken rotlToken8 = new RotlToken(tokens8);
        assertEquals("FALSE TRUE FALSE ROTL", rotlToken8.toString());
    }
}
