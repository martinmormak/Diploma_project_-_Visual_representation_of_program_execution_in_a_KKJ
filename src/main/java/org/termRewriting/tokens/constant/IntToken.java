package org.termRewriting.tokens.constant;

import org.termRewriting.tokens.interfaces.IArithmeticToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.List;

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

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        return List.of(IArithmeticToken.class);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public List<IToken> minimalize() {
        return List.of(this);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
