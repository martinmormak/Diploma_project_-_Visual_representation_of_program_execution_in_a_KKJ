package org.core.tokens.constant;

import org.core.tokens.interfaces.ILogicToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class BoolToken implements ILogicToken {
    private Boolean value;

    public BoolToken(Boolean value) {
        this.value = value;
    }

    public BoolToken(String value) {
        if (value == null) {
            System.err.println("Value cannot be null!");
        } else if (value.equalsIgnoreCase("true")) {
            this.value = true;
        } else if (value.equalsIgnoreCase("false")) {
            this.value = false;
        } else {
            System.err.println("Value must be either 'true' or 'false'!");
        }
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public void setValue(String value) {
        if (value == null) {
            System.err.println("Value cannot be null!");
        } else if (value.equalsIgnoreCase("true")) {
            this.value = true;
        } else if (value.equalsIgnoreCase("false")) {
            this.value = false;
        } else {
            System.err.println("Value must be either 'true' or 'false'!");
        }
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        stack.push(this);
        return null;
    }

    @Override
    public String toString() {
        return value.toString().toUpperCase();
    }

    @Override
    public ILogicToken clone() {
        return new BoolToken(value);
    }
}
