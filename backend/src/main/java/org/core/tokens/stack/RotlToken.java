package org.core.tokens.stack;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class RotlToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=3) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            IToken pop3 = stack.pop();
            stack.push(pop2);
            stack.push(pop1);
            stack.push(pop3);
        } else {
            throw new RuntimeException("In stack must be >= 3 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
        return null;
    }

    @Override
    public String toString() {
        return "ROTL";
    }

    @Override
    public IFunctionToken clone() {
        return new RotlToken();
    }
}
