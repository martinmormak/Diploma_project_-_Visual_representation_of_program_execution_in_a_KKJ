package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.slang.KKJException;

import java.util.List;
import java.util.Stack;

public class IsNegToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            IToken pop = stack.pop();
            if (pop instanceof IntToken) {
                IToken result = new BoolToken(((IntToken) pop).getValue() < 0);
                stack.push(result);
            } else {
                throw new KKJException("Expected IntToken and get " + pop.getClass().getSimpleName());
            }
        } else {
            throw new KKJException("In stack must be >= 1 items and is empty");
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new IsNegToken();
    }

    @Override
    public String toString() {
        return "ISNEG";
    }

    @Override
    public String toJSON() {
        return "ISNEG";
    }
}
