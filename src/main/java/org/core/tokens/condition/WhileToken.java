package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IConditionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.QuotationToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WhileToken implements IConditionToken {
    private List<IToken> tokens;
    private IToken condition;
    private IToken body;

    public WhileToken(List<IToken> tokens) {
        this.tokens = tokens;
        if (tokens.size() >= 2) {
            body = tokens.removeLast();
            condition = tokens.removeLast();
        } else {
            throw new RuntimeException("Expected two tokens but don't get it for WhileToken");
        }
    }

    public WhileToken(IToken condition, IToken body) {
        this.tokens = new LinkedList<>();
        this.body = body;
        this.condition = condition;
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(((availableTokensFormToken.getLast() == IArithmeticToken.class && availableTokensFormToken.get(availableTokensFormToken.size()-2) == IArithmeticToken.class) || (availableTokensFormToken.getLast() == ILogicToken.class && availableTokensFormToken.get(availableTokensFormToken.size()-2) == ILogicToken.class)) && availableTokensFormToken.get(tokens.size()-3) == ILogicToken.class) {
            availableTokensFormToken.remove(tokens.size()-3);
            availableTokensFormToken.remove(tokens.size()-2);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected bool and two numerals/boolean but don't get it for WhileToken");
        }   
    }*/

    @Override
    public IToken getValue() {
        if (condition instanceof BoolToken) {
            if (((BoolToken) condition).getValue() == true) {
                return body;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        List<IToken> newTokens = new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for (IToken token : tokens) {
            if (!(token instanceof IntToken) && !(token instanceof BoolToken)) {
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if (onlyPrimitiveTypes) {
            substitutions.add(condition + " " + body + " WHILE -> " + condition + " { " + body + " " + condition + " " + body + " WHILE } WHILE -> ");
            tokens.add(condition.clone());
            tokens.add(new QuotationToken(List.of(body.clone(),this.clone())));
            tokens.add(new QuotationToken(new LinkedList<>()));
            return List.of(new ChooseToken(tokens));
        } else {
            return List.of(this);
        }
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if (!tokens.isEmpty()) {
            List<IToken> result = tokens.removeFirst().stackSolving(stack);
            if (result != null && !result.isEmpty()) {
                tokens.addAll(0, result);
            }
            return List.of(this);
        }
        tokens.add(condition.clone());
        tokens.add(new QuotationToken(List.of(body.clone(),this.clone())));
        tokens.add(new QuotationToken(new LinkedList<>()));
        return List.of(new ChooseToken(tokens));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IToken token : tokens) {
            stringBuilder.append(token).append(" ");
        }
        stringBuilder.append(condition).append(" ");
        stringBuilder.append(body).append(" ");
        return stringBuilder.append("WHILE").toString();
    }

    @Override
    public IConditionToken clone() {
        return new WhileToken(condition.clone(),body.clone());
    }
}
