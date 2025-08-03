package org.core.tokens.interfaces;

public interface IArithmeticToken extends IToken {
    Integer getValue();
    IArithmeticToken clone();
}
