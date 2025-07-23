package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ClearTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        ClearToken clearToken1 = new ClearToken(tokens1);
        assertNull(clearToken1.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(3), new BoolToken(true)));
        ClearToken clearToken1 = new ClearToken(tokens1);
        assertNull(clearToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true), new IntToken(3)));
        ClearToken clearToken2 = new ClearToken(tokens2);
        assertNull(clearToken2.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        ClearToken clearToken1 = new ClearToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = clearToken1.termRewritingSolving(substitutions1);
        assertEquals(0, result1.size());
        assertEquals("FALSE FALSE CLEAR -> \"\"", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(5), new IntToken(7)));
        ClearToken clearToken2 = new ClearToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = clearToken2.termRewritingSolving(substitutions2);
        assertEquals(0, result2.size());
        assertEquals("5 7 CLEAR -> \"\"", substitutions2.getFirst());
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        ClearToken clearToken1 = new ClearToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        clearToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(false, stack1.peek().getValue());
        clearToken1.stackSolving(stack1);
        assertEquals(2, stack1.size());
        assertEquals(false, stack1.peek().getValue());
        clearToken1.stackSolving(stack1);
        assertEquals(0, stack1.size());

        List<IToken> tokens2 = new LinkedList<>(List.of(new IntToken(8), new IntToken(4)));
        ClearToken clearToken2 = new ClearToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        clearToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(8, stack2.peek().getValue());
        clearToken2.stackSolving(stack2);
        assertEquals(2, stack2.size());
        assertEquals(4, stack2.peek().getValue());
        clearToken2.stackSolving(stack2);
        assertEquals(0, stack2.size());
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(false)));
        ClearToken clearToken1 = new ClearToken(tokens1);
        assertEquals("FALSE FALSE CLEAR", clearToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(false), new BoolToken(true)));
        ClearToken clearToken2 = new ClearToken(tokens2);
        assertEquals("FALSE TRUE CLEAR", clearToken2.toString());

        List<IToken> tokens3 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(false)));
        ClearToken clearToken3 = new ClearToken(tokens3);
        assertEquals("TRUE FALSE CLEAR", clearToken3.toString());

        List<IToken> tokens4 = new LinkedList<>(List.of(new BoolToken(true), new BoolToken(true)));
        ClearToken clearToken4 = new ClearToken(tokens4);
        assertEquals("TRUE TRUE CLEAR", clearToken4.toString());
    }
}
