package org.core.tokens.quotation;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class QuotationTokenTest {

    @Test
    void testGetValueWithValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new BoolToken(false)));
        QuotationToken quotationToken1 = new QuotationToken(tokens1);
        assertNull(quotationToken1.getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        QuotationToken quotationToken2 = new QuotationToken(tokens2);
        assertNull(quotationToken2.getValue());
    }

    @Test
    void testGetValueWithInvalidTokens() {
        List<IToken> tokens = new LinkedList<>(List.of(new IntToken(1)));
        QuotationToken quotationToken = new QuotationToken(tokens);
        assertNull(quotationToken.getValue());
    }

    /*@Test
    void testTermRewritingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(5)));
        QuotationToken quotationToken1 = new QuotationToken(tokens1);
        List<String> substitutions1 = new ArrayList<>();
        List<IToken> result1 = quotationToken1.termRewritingSolving(substitutions1);
        assertEquals(1, result1.size());
        assertInstanceOf(IntToken.class, result1.getFirst());
        assertEquals(5, ((IntToken) result1.getFirst()).getValue());
        assertEquals("{ 5 } -> 5", substitutions1.getFirst());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        QuotationToken quotationToken2 = new QuotationToken(tokens2);
        List<String> substitutions2 = new ArrayList<>();
        List<IToken> result2 = quotationToken2.termRewritingSolving(substitutions2);
        assertEquals(1, result2.size());
        assertInstanceOf(BoolToken.class, result2.getFirst());
        assertEquals(true, ((BoolToken) result2.getFirst()).getValue());
        assertEquals("{ TRUE } -> TRUE", substitutions2.getFirst());
    }*/

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(8)));
        QuotationToken quotationToken1 = new QuotationToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        quotationToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertEquals(8, stack1.peek().getValue());
        quotationToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(IntToken.class, stack1.peek());
        assertEquals(8, ((IntToken) stack1.peek()).getValue());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        QuotationToken quotationToken2 = new QuotationToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        quotationToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertEquals(true, stack2.peek().getValue());
        quotationToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(BoolToken.class, stack2.peek());
        assertEquals(true, ((BoolToken) stack2.peek()).getValue());
    }

    @Test
    void testToStringOutput() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(1)));
        QuotationToken quotationToken1 = new QuotationToken(tokens1);
        assertEquals("{ 1 }", quotationToken1.toString());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        QuotationToken quotationToken2 = new QuotationToken(tokens2);
        assertEquals("{ TRUE }", quotationToken2.toString());
    }
}
