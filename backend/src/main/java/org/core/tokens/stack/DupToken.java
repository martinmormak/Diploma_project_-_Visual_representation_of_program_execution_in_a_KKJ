package org.core.tokens.stack;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.slang.KKJException;

import java.util.List;
import java.util.Stack;

public class DupToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            stack.push(stack.peek());
        } else {
            throw new KKJException("In stack must be >= 1 itemsand is empty");
        }
        return null;
    }

    @Override
    public IFunctionToken clone() {
        return new DupToken();
    }

    @Override
    public String toString() {
        return "DUP";
    }

    @Override
    public String toJSON() {
        return "DUP";
    }
}
