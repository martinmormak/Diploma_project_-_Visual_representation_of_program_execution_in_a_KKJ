package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class IsPosToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            IToken pop = stack.pop();
            if (pop instanceof IntToken) {
                IToken result = new BoolToken(((IntToken) pop).getValue() > 0);
                stack.push(result);
            } else {
                throw new RuntimeException("Expected IntToken and get " + pop.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 1 items and is empty");
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new IsPosToken();
    }

    @Override
    public String toString() {
        return "ISPOS";
    }

    @Override
    public String toJSON() {
        return "\"ISPOS\"";
    }
}
