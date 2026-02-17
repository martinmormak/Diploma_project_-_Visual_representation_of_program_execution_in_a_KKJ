package org.core.tokens.stack;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class PopToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            stack.pop();
        } else {
            throw new RuntimeException("In stack must be >= 1 itemsand is empty");
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new PopToken();
    }

    @Override
    public String toString() {
        return "POP";
    }

    @Override
    public String toJSON() {
        return "POP";
    }
}

