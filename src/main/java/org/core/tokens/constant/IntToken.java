package org.core.tokens.constant;

import org.core.tokens.interfaces.IArithmeticToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class IntToken implements IArithmeticToken {
    private Integer value;

    public IntToken(Integer value) {
        this.value = value;
    }

    public IntToken(String value) {
        this.value = Integer.valueOf(value);
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = Integer.valueOf(value);
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        return List.of(IArithmeticToken.class);
    }*/

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        return List.of(this);
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        stack.push(this);
        return null;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public IArithmeticToken clone() {
        return new IntToken(value);
    }
}
