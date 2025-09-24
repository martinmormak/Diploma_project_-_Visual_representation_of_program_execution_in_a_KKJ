package org.core.tokens.stack;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class ClearToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        stack.clear();
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new ClearToken();
    }

    @Override
    public String toString() {
        return "CLEAR";
    }

    @Override
    public String toJSON() {
        return "\"CLEAR\"";
    }
}
