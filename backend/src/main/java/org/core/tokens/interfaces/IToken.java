package org.core.tokens.interfaces;

import java.util.List;
import java.util.Stack;

public interface IToken {
    List<IToken> stackSolving(Stack<IToken> stack);
    IToken clone();
}
