package org.termRewriting.tokens.interfaces;

import java.util.List;

public interface IToken {
    List<Class<? extends IToken>> getAvailableTokenList();
    Object getValue();
    List<IToken> minimalize();
}
