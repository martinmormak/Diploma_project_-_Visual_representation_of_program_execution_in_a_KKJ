package org.termRewriting;

import org.termRewriting.tokens.constant.*;
import org.termRewriting.tokens.interfaces.*;
import org.termRewriting.tokens.aritmetic.*;
import org.termRewriting.tokens.logic.*;
import org.termRewriting.tokens.stack.*;

import java.util.LinkedList;
import java.util.List;

public class Tokenizer {
    public List<IToken> getTokenList(String input) {
        if (input == null || input.isEmpty()) {
            return new LinkedList<>();
        }
        String[] inputTokens = input.split(" ");
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
                    tokenList.add(new AndToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("ISPOS")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new IsPosToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
                } else {
                    throw new RuntimeException(tokenList.toString());
                }
            } else if(token.toUpperCase().matches("ISNEG")) {
                if(!tokenList.isEmpty()) {
                    tokenList.add(new IsNegToken(getTokenList(tokenList, List.of(IArithmeticToken.class, IArithmeticToken.class))));
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
            } else {
                throw new RuntimeException(tokenList.toString());
            }
        }
        return tokenList;
    }

    private List<IToken> getTokenList(List<IToken> tokenList, List<Class<? extends IToken>> expectedTokenList) {
        List<IToken> subTokenList = new LinkedList<>();
        int classIndex = expectedTokenList.size()-1;
        for (int tokenIndex = tokenList.size()-1; tokenIndex>=0; tokenIndex--) {
            IToken token = tokenList.removeLast();
            subTokenList.addFirst(token);
            List<Class<? extends IToken>> availabelTokenList = token.getAvailableTokenList();
            for(int availableClassToken=availabelTokenList.size()-1; availableClassToken>=0; availableClassToken--){
                if(availabelTokenList.get(availableClassToken) == expectedTokenList.get(classIndex)){
                    classIndex--;
                    if(classIndex<0){
                        return subTokenList;
                    }
                }
            }
        }
        return subTokenList;
    }
}
