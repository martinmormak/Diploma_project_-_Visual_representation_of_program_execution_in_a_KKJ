package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.slang.KKJException;

import java.util.List;
import java.util.Stack;

public class NotToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if (!stack.isEmpty()) {
            IToken pop = stack.pop();
            if (pop instanceof BoolToken) {
                IToken result = new BoolToken(!((BoolToken) pop).getValue());
                stack.push(result);
            } else {
                throw new KKJException("Expected BoolToken and get " + pop.getClass().getSimpleName());
            }
        } else {
            throw new KKJException("In stack must be >= 1 items and is empty");
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new NotToken();
    }

    @Override
    public String toString() {
        return "NOT";
    }

    @Override
    public String toJSON() {
        return "NOT";
    }
}
