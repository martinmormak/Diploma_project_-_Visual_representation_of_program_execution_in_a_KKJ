package org.core.tokens.quotation;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class QuotationTokenTest {

    @Test
    void testStackSolvingValidTokens() {
        List<IToken> tokens1 = new LinkedList<>(List.of(new IntToken(8)));
        QuotationToken quotationToken1 = new QuotationToken(tokens1);
        Stack<IToken> stack1 = new Stack<>();
        quotationToken1.stackSolving(stack1);
        assertEquals(1, stack1.size());
        assertInstanceOf(CombinationToken.class, stack1.peek());

        List<IToken> tokens2 = new LinkedList<>(List.of(new BoolToken(true)));
        QuotationToken quotationToken2 = new QuotationToken(tokens2);
        Stack<IToken> stack2 = new Stack<>();
        quotationToken2.stackSolving(stack2);
        assertEquals(1, stack2.size());
        assertInstanceOf(CombinationToken.class, stack1.peek());
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
