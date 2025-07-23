package org.core.tokens.condition;

import org.core.tokens.arithmetic.CmpToken;
import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IConditionToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.QuotationToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ChooseToken implements IConditionToken {
    private List<IToken> tokens;
    private IToken condition;
    private IToken trueBranch;
    private IToken falseBranch;

    public ChooseToken(List<IToken> tokens) {
        this.tokens = tokens;

        if (tokens.size() >= 3) {
            falseBranch = tokens.removeLast();
            trueBranch = tokens.removeLast();
            condition = tokens.removeLast();
        } else {
            throw new RuntimeException("Expected three tokens but don't get it for WhileToken");
        }
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
            throw new RuntimeException("Expected bool and two numerals/boolean but don't get it for ChooseToken");
        }
    }*/

    @Override
    public IToken getValue() {
        if (condition instanceof BoolToken && ((BoolToken) condition).getValue() == true) {
            if(trueBranch.getValue() instanceof IToken) {
                return (IToken) trueBranch.getValue();
            } else if(trueBranch instanceof IntToken ||  trueBranch instanceof BoolToken) {
                return trueBranch;
            }
        } else if(condition instanceof BoolToken && ((BoolToken) condition).getValue() == false) {
            if(falseBranch.getValue() instanceof IToken) {
                return (IToken) falseBranch.getValue();
            } else if(falseBranch instanceof IntToken ||  falseBranch instanceof BoolToken) {
                return falseBranch;
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
            if(condition!=null) {
                tokens.add(condition.clone());
                condition = null;
                return termRewritingSolving(substitutions);
            }
            if(trueBranch!=null && falseBranch!=null) {
                if(tokens.getLast() instanceof BoolToken) {
                    BoolToken condition = (BoolToken) tokens.removeLast();
                    if (condition.getValue() == true) {
                        tokens.add(trueBranch.clone());
                        trueBranch = null;
                        return tokens;
                    } else {
                        tokens.add(falseBranch.clone());
                        falseBranch = null;
                        return tokens;
                    }
                } else {
                    throw new RuntimeException("Expected BoolToken and get " + tokens.getLast().getClass().getSimpleName());
                }
            }
        } else {
            return List.of(this);
        }
        return null;
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
        if(condition!=null) {
            tokens.add(condition.clone());
            condition = null;
            return stackSolving(stack);
        }
        if(trueBranch!=null && falseBranch!=null) {
            if(stack.peek() instanceof BoolToken) {
                BoolToken condition = (BoolToken) stack.pop();
                if (condition.getValue() == true) {
                    tokens.add(trueBranch.clone());
                    trueBranch = null;
                    return tokens;
                } else {
                    tokens.add(falseBranch.clone());
                    falseBranch = null;
                    return tokens;
                }
            } else {
                throw new RuntimeException("Expected BoolToken and get " + stack.peek().getClass().getSimpleName());
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IToken token : tokens) {
            stringBuilder.append(token).append(" ");
        }
        if(condition!=null) {
            stringBuilder.append(condition).append(" ");
        }
        if(trueBranch!=null && falseBranch!=null) {
            stringBuilder.append(trueBranch).append(" ");
            stringBuilder.append(falseBranch).append(" ");
        }
        return stringBuilder.append("CHOOSE").toString();
    }

    @Override
    public IConditionToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        if(condition!=null && trueBranch!=null && falseBranch!=null) {
            tokensClone.add(condition.clone());
            tokensClone.add(trueBranch.clone());
            tokensClone.add(falseBranch.clone());
        } else {
            tokensClone.add(new QuotationToken(new LinkedList<>()));
            tokensClone.add(new QuotationToken(new LinkedList<>()));
            tokensClone.add(new QuotationToken(new LinkedList<>()));
        }
        return new ChooseToken(tokensClone);
    }
}
