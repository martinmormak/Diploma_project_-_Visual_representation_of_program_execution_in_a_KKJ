package org.core.tokens.arithmetic;

import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class SubToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if (stack.size() >= 2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            if (pop1 instanceof IntToken && pop2 instanceof IntToken) {
                IToken result = new IntToken(((IntToken) pop2).getValue() - ((IntToken) pop1).getValue());
                stack.push(result);
            } else {
                throw new RuntimeException("Expected IntToken, IntToken and get " + pop2.getClass().getSimpleName() + ", " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
        return null;
    }

    @Override
    public String toString() {
        return "SUB";
    }

    @Override
    public IFunctionToken clone() {
        return new SubToken();
    }
}
