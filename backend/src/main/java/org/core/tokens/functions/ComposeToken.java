package org.core.tokens.functions;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CompositionToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ComposeToken implements IToken {
    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size() >= 2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            if(pop1 instanceof IFunctionToken && pop2 instanceof IFunctionToken) {
                List<IToken> tokens = new LinkedList<>();
                tokens.add(pop2);
                tokens.add(pop1);
                stack.push(new CompositionToken(tokens));
                return null;
            } else {
                throw new RuntimeException("Expected IFunctionToken, IFunctionToken and get " + pop2.getClass().getSimpleName() + ", " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
    }

    @Override
    public IToken clone() {
        return new ComposeToken();
    }

    @Override
    public String toString() {
        return "COMPOSE";
    }

    @Override
    public String toJSON() {
        return "\"COMPOSE\"";
    }
}
