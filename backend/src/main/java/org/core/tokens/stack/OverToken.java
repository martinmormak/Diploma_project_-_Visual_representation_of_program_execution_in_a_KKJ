package org.core.tokens.stack;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class OverToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.peek();
            stack.push(pop1);
            stack.push(pop2);
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new OverToken();
    }

    @Override
    public String toString() {
        return "OVER";
    }

    @Override
    public String toJSON() {
        return "\"OVER\"";
    }
}
