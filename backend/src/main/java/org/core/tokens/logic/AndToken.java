package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class AndToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            if (pop1 instanceof BoolToken && pop2 instanceof BoolToken) {
                IToken result = new BoolToken(((BoolToken) pop2).getValue() && ((BoolToken) pop1).getValue());
                stack.push(result);
            } else {
                throw new RuntimeException("Expected BoolToken, BoolToken and get " + pop2.getClass().getSimpleName() + ", " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new AndToken();
    }

    @Override
    public String toString() {
        return "AND";
    }

    @Override
    public String toJSON() {
        return "AND";
    }
}
