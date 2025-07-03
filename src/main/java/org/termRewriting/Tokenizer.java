package org.termRewriting;

import org.termRewriting.tokens.condition.ChooseToken;
import org.termRewriting.tokens.constant.*;
import org.termRewriting.tokens.interfaces.*;
import org.termRewriting.tokens.aritmetic.*;
import org.termRewriting.tokens.logic.*;
import org.termRewriting.tokens.quotation.QuotationToken;
import org.termRewriting.tokens.stack.*;

import java.util.LinkedList;
import java.util.List;

public class Tokenizer {
    public List<IToken> getTokenList(String input) {
        Integer quotations = 0;
        if (input == null || input.isEmpty()) {
            return new LinkedList<>();
        }
        String[] inputTokens = input.split(" ");
        List<List<IToken>> programs = new LinkedList<>();
        List<IToken> tokenList = new LinkedList<>();
        for (String token : inputTokens) {
            if(token.matches("-?\\d+")) {
                tokenList.add(new IntToken(token));
            } else if(token.toUpperCase().matches("TRUE|FALSE")) {
                tokenList.add(new BoolToken(token));
            } else if(token.toUpperCase().matches("ADD")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new AddToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("MUL")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new MulToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("SUB")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new SubToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("CMP")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new CmpToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("NOT")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new NotToken(getTokenList(tokenList, List.of(ILogicToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("AND")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new AndToken(getTokenList(tokenList, List.of(ILogicToken.class, ILogicToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("ISPOS")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new IsPosToken(getTokenList(tokenList, List.of(IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("ISNEG")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new IsNegToken(getTokenList(tokenList, List.of(IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("CLEAR")) {
                if(!tokenList.isEmpty()) {
                    ClearToken clearToken = new ClearToken(tokenList);
                    tokenList = new LinkedList<>();
                    tokenList.add(clearToken);
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("POP")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new PopToken(getTokenList(tokenList, List.of(IToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("DUP")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new DupToken(getTokenList(tokenList, List.of(IToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("OVER")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new OverToken(getTokenList(tokenList, List.of(IToken.class, IToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("SWAP")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new SwapToken(getTokenList(tokenList, List.of(IToken.class, IToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("ROTL")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new RotlToken(getTokenList(tokenList, List.of(IToken.class, IToken.class, IToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("CHOOSE")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new ChooseToken(getTokenList(tokenList, List.of(IToken.class, IToken.class, IToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if (token.equals("{")) {
                programs.add(tokenList);
                tokenList = new LinkedList<>();
                quotations++;
            } else if (token.equals("}")) {
                quotations--;
                if(!tokenList.isEmpty()) {
                    tokenList.add(new QuotationToken(getTokenList(tokenList)));
                    tokenList.addAll(0, programs.removeLast());
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else {
                throw new RuntimeException(tokenList.toString());
            }
        }
        return tokenList;
    }

    private List<IToken> getTokenList(List<IToken> tokenList, List<Class<? extends IToken>> expectedTokenList) {
        List<IToken> subTokenList = new LinkedList<>();
        int classIndex = expectedTokenList.size()-1;
        List<Class<? extends IToken>> getTokenList = new LinkedList<>();
        for (int tokenIndex = tokenList.size()-1; tokenIndex>=0; tokenIndex--) {
            IToken token = tokenList.removeLast();
            subTokenList.addFirst(token);
            List<Class<? extends IToken>> availabelTokenList = token.getAvailableTokenList();
            getTokenList.addAll(availabelTokenList);
        }
        for(int availableClassToken=getTokenList.size()-1; availableClassToken>=0; availableClassToken--){
            if(getTokenList.get(availableClassToken) != expectedTokenList.get(classIndex) || expectedTokenList.get(classIndex) != IToken.class) {
                StringBuilder stringBuilder = new StringBuilder("Expected: ..., ");
                for(Class<? extends IToken> tokenClass: expectedTokenList) {
                    stringBuilder.append(tokenClass.getSimpleName()).append(", ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.append(" but get: ");
                for(int availableTokenIndex=getTokenList.size()-1; availableTokenIndex>=0; availableTokenIndex--){
                    stringBuilder.append(getTokenList.get(availableTokenIndex).getSimpleName()).append(", ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                throw new RuntimeException(stringBuilder.toString());
            }
            classIndex--;
            if(classIndex<0){
                return subTokenList;
            }
        }
        return subTokenList;
    }

    private List<IToken> getTokenList(List<IToken> tokenList) {
        List<IToken> subTokenList = new LinkedList<>();
        for (int tokenIndex = tokenList.size()-1; tokenIndex>=0; tokenIndex--) {
            IToken token = tokenList.removeLast();
            subTokenList.addFirst(token);
            List<Class<? extends IToken>> availabelTokenList = token.getAvailableTokenList();
        }
        return subTokenList;
    }
}
