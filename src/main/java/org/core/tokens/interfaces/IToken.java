package org.core.tokens.interfaces;

import java.util.List;
import java.util.Stack;

public interface IToken {
    //    List<Class<? extends IToken>> getAvailableTokenList();
    Object getValue();
    List<IToken> termRewritingSolving(List<String> substitutions);
    List<IToken> stackSolving(Stack<IToken> stack);
    IToken clone();
}
