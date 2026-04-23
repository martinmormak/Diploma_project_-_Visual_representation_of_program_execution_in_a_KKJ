package org.server.controllers;

import org.StringProcessor;
import org.core.Tokenizer;
import org.core.tokens.interfaces.IToken;
import org.server.JSON.RequestJSONRepresentation;
import org.server.JSON.ResponseJSONRepresentation;
import org.server.services.AppStateService;
import org.slang.KKJException;
import org.slang.lang.kkj.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class KKJController {

    private final AppStateService appStateService;

    public KKJController(AppStateService appStateService) {
        this.appStateService = appStateService;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateInput(@RequestBody RequestJSONRepresentation request) {
        if (!appStateService.isActive()) {
            return new ResponseEntity<>("Application is inactive", HttpStatus.SERVICE_UNAVAILABLE);
        }

        System.out.println("---------- validateInput ----------");
        if (request.getTokensValue() == null || request.getTokensValue().isEmpty()) {
            return new ResponseEntity<>("Tokens input is empty", HttpStatus.BAD_REQUEST);
        }
        String tokensValue = request.getTokensValue();
        System.out.println("From API input: " + tokensValue);

        // replace commands sing map
        tokensValue = StringProcessor.replaceByPatterns(tokensValue);
        System.out.println("After map replacing: " + tokensValue);

        // Apply POPn replacements
        tokensValue = StringProcessor.replacePopOccurrences(tokensValue);
        System.out.println("After pop replacing: " + tokensValue);

        // Apply toUpperCase replacements
        tokensValue = tokensValue.toUpperCase();
        System.out.println("After to upper case replacing: " + tokensValue);

        try {
            Program program = KKJ_parser.parseProgram(tokensValue);
            System.out.println(program);
            Program_program.operation(program).apply();
            Program_.operation(program).apply();
            System.out.println("------------------------------\n");
        } catch (KKJException e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Input is invalid with error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Unknow error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Input is valid", HttpStatus.OK);
    }

    @PostMapping("/simulate/from-scratch")
    public ResponseEntity<String> getSimulationFromScratch(@RequestBody RequestJSONRepresentation request) {
        if (!appStateService.isActive()) {
            return new ResponseEntity<>("Application is inactive", HttpStatus.SERVICE_UNAVAILABLE);
        }

        System.out.println("---------- getSimulationFromScratch ----------");
        if (request.getTokensValue() == null || request.getTokensValue().isEmpty()) {
            return new ResponseEntity<>("Tokens input is empty", HttpStatus.BAD_REQUEST);
        }
        String tokensValue = request.getTokensValue();
        System.out.println("From API input: " + tokensValue);

        // replace commands sing map
        tokensValue = StringProcessor.replaceByPatterns(tokensValue);
        System.out.println("After map replacing: " + tokensValue);

        // Apply POPn replacements
        tokensValue = StringProcessor.replacePopOccurrences(tokensValue);
        System.out.println("After pop replacing: " + tokensValue);

        // Apply toUpperCase replacements
        tokensValue = tokensValue.toUpperCase();
        System.out.println("After to upper case replacing: " + tokensValue);

        List<ResponseJSONRepresentation> responseJsonRepresentationList = new LinkedList<>();
        try {
            Program program = KKJ_parser.parseProgram(tokensValue);
            System.out.println(program);
            Program_program.operation(program).apply();
            List<IToken> tokens = Program_.operation(program).apply();
            System.out.println("------------------------------\n");

            responseJsonRepresentationList.add(new ResponseJSONRepresentation(tokens));
            Stack<IToken> stack = new Stack<>();

            responseJsonRepresentationList.addAll(simulate(tokens, stack));
        } catch (KKJException e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Input is invalid, simulation failed.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Unknow error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        ResponseEntity<String> response = new ResponseEntity<>(toJsonArray(responseJsonRepresentationList), HttpStatus.OK);
        return response;
    }

    @PostMapping("/simulate/from-point")
    public ResponseEntity<String> getSimulationFromPoint(@RequestBody RequestJSONRepresentation request) {
        if (!appStateService.isActive()) {
            return new ResponseEntity<>("Application is inactive", HttpStatus.SERVICE_UNAVAILABLE);
        }
        
        System.out.println("---------- getSimulationFromPoint ----------");
        if (request.getTokensValue() == null || request.getTokensValue().isEmpty() || request.getStackValue() == null || request.getStackValue().isEmpty()) {
            return new ResponseEntity<>("Tokens input or Stack input is empty", HttpStatus.BAD_REQUEST);
        }
        String tokensValue = request.getTokensValue();
        String stackValue = request.getStackValue();
        System.out.println("From API input: " + tokensValue);

        // replace commands sing map
        tokensValue = StringProcessor.replaceByPatterns(tokensValue);
        System.out.println("After map replacing: " + tokensValue);

        // Apply POPn replacements
        tokensValue = StringProcessor.replacePopOccurrences(tokensValue);
        System.out.println("After pop replacing: " + tokensValue);

        // Apply toUpperCase replacements
        tokensValue = tokensValue.toUpperCase();
        System.out.println("After to upper case replacing: " + tokensValue);

        List<ResponseJSONRepresentation> responseJsonRepresentationList;
        Tokenizer tokenizer = new Tokenizer();
        try {
            List<IToken> tokens = tokenizer.getTokenList(tokensValue);

            List<IToken> stackList = tokenizer.getTokenList(stackValue);

            Stack<IToken> stack = new Stack<>();
            for(IToken stackToken : stackList) {
                stack.push(stackToken);
            }
            System.out.println("------------------------------\n");

            responseJsonRepresentationList = simulate(tokens, stack);
        } catch (KKJException e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Input is invalid, simulation failed.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Unknow error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        ResponseEntity<String> response = new ResponseEntity<>(toJsonArray(responseJsonRepresentationList), HttpStatus.OK);
        return response;
    }

    private List<ResponseJSONRepresentation> simulate (List<IToken> tokens, Stack<IToken> stack) {
            List<ResponseJSONRepresentation> responseJsonRepresentationList = new LinkedList<>();
            int counter = 0;
            while (!tokens.isEmpty() && counter < 50) {
                IToken token = tokens.removeFirst();
                List<IToken> newTokens = new LinkedList<>();
                while (token != null && counter < 50) {
                    List<IToken> returnTokens = token.stackSolving(stack);

                    if (returnTokens != null && !returnTokens.isEmpty()) {
                        newTokens.addAll(0, returnTokens);
                    }
                    if (!newTokens.isEmpty() && newTokens.getLast() == null) {
                        newTokens.removeLast();
                    }

                    responseJsonRepresentationList.add(new ResponseJSONRepresentation(newTokens, tokens, stack));
                    System.out.println(responseJsonRepresentationList.getLast());
                    counter++;

                    for (IToken iToken : newTokens) {
                        System.out.print(iToken + " ");
                    }
                    for (IToken iToken : tokens) {
                        System.out.print(iToken + " ");
                    }

                    System.out.print("\t|\t");
                    for (IToken iToken : stack) {
                        System.out.print(iToken + " ");
                    }
                    System.out.println();
                    if(!newTokens.isEmpty()) {
                        token = newTokens.removeFirst();
                    } else {
                        token = null;
                    }
                }
            }
            System.out.println("------------------------------\n");
        return responseJsonRepresentationList;
    }

    private String toJsonArray(List<ResponseJSONRepresentation> list) {
        return list.stream()
                .map(ResponseJSONRepresentation::toJson)
                .collect(Collectors.joining(",\n", "[", "]"));
    }
}
