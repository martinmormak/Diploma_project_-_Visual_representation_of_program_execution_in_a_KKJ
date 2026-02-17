package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class IDToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new IDToken();
    }

    @Override
    public String toString() {
        return "ID";
    }

    @Override
    public String toJSON() {
        return "ID";
    }
}

