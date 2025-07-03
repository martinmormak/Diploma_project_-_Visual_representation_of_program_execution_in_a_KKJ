package org.termRewriting.tokens.condition;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IArithmeticToken;
import org.termRewriting.tokens.interfaces.IConditionToken;
import org.termRewriting.tokens.interfaces.ILogicToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ChooseToken implements IConditionToken {
    private List<IToken> tokens;

    public ChooseToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(((availableTokensFormToken.getLast() == IArithmeticToken.class && availableTokensFormToken.get(tokens.size()-2) == IArithmeticToken.class) || (availableTokensFormToken.getLast() == ILogicToken.class && availableTokensFormToken.get(tokens.size()-2) == ILogicToken.class)) && availableTokensFormToken.get(tokens.size()-3) == ILogicToken.class) {
            availableTokensFormToken.remove(tokens.size()-3);
            availableTokensFormToken.remove(tokens.size()-2);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected bool and two numerals/boolean but dont get it for ChooseToken");
        }
    }

    @Override
    public IToken getValue() {
        if(tokens.get(tokens.size()-3) instanceof BoolToken) {
            if(((BoolToken)tokens.get(tokens.size()-3)).getValue() == true) {
                return tokens.get(tokens.size() - 2);
            } else {
                return tokens.getLast();
            }
        }
        return null;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(token instanceof IntToken) && !(token instanceof BoolToken)) {
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            IToken result = getValue();
            substitutions.add(this + " -> " + result.getValue());
            tokens.removeLast();
            tokens.removeLast();
            tokens.removeLast();
            tokens.add(result);
            return tokens;
        }else {
            return List.of(this);
        }
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!tokens.isEmpty()) {
            if(tokens.getFirst().stackSolving(stack) == null) {
                tokens.removeFirst();
            }
            return List.of(this);
        }
        if(stack.size()>=3) {
            IToken secound = stack.pop();
            IToken first = stack.pop();
            BoolToken condition = (BoolToken) stack.pop();
            if (condition.getValue() == true) {
                stack.push(first);
            } else {
                stack.push(secound);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("CHOOSE").toString();
    }
}
