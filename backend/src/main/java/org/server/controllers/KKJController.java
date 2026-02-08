package org.server.controllers;

import org.StringProcessor;
import org.core.tokens.interfaces.IToken;
import org.server.JSON.JSONRepresentation;
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

    @PostMapping("/validate/{value}")
    public ResponseEntity<String> validateInput(@PathVariable String value) {
        System.out.println("---------- validateInput ----------");
        if(value==null){
            return new ResponseEntity<>("Input is empty", HttpStatus.BAD_REQUEST);
        }
        System.out.println("From API input: " + value);

        // replace commands sing map
        value = StringProcessor.replaceByPatterns(value);
        System.out.println("After map replacing: " + value);

        // Apply POPn replacements
        value = StringProcessor.replacePopOccurrences(value);
        System.out.println("After pop replacing: " + value);

        // Apply toUpperCase replacements
        value = value.toUpperCase();
        System.out.println("After to upper case replacing: " + value);

        try {
            Program program = KKJ_parser.parseProgram(value);
            System.out.println(program);
            Program_program.operation(program).apply();
            Program_.operation(program).apply();
            System.out.println("------------------------------\n");
        } catch (Exception e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Input is invalid with error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Input is valid", HttpStatus.OK);
    }

    @GetMapping("/simulate/{value}")
    public ResponseEntity<String> getSimulation(@PathVariable String value) {
        System.out.println("---------- getSimulation ----------");
        if(value==null){
            return new ResponseEntity<>("Input is empty", HttpStatus.BAD_REQUEST);
        }
        System.out.println("From API input: " + value);

        // replace commands sing map
        value = StringProcessor.replaceByPatterns(value);
        System.out.println("After map replacing: " + value);

        // Apply POPn replacements
        value = StringProcessor.replacePopOccurrences(value);
        System.out.println("After pop replacing: " + value);

        // Apply toUpperCase replacements
        value = value.toUpperCase();
        System.out.println("After to upper case replacing: " + value);

        List<JSONRepresentation> jsonRepresentationList = new LinkedList<>();
        try {
            Program program = KKJ_parser.parseProgram(value);
            System.out.println(program);
            Program_program.operation(program).apply();
            List<IToken> tokens = Program_.operation(program).apply();
            System.out.println("------------------------------\n");

            jsonRepresentationList.add(new JSONRepresentation(tokens));
            Stack<IToken> stack = new Stack<>();
            while (!tokens.isEmpty()) {
                IToken token = tokens.removeFirst();
                List<IToken> newTokens = new LinkedList<>();
                while (token != null) {
                    List<IToken> returnTokens = token.stackSolving(stack);

                    if (returnTokens != null && !returnTokens.isEmpty()) {
                        newTokens.addAll(0, returnTokens);
                    }
                    if (!newTokens.isEmpty() && newTokens.getLast() == null) {
                        newTokens.removeLast();
                    }

                    jsonRepresentationList.add(new JSONRepresentation(newTokens, tokens, stack));

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
        } catch (Exception e) {
            System.out.println("------------------------------\n");
            return new ResponseEntity<>("Input is invalid with error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(toJsonArray(jsonRepresentationList), HttpStatus.OK);
    }

    private String toJsonArray(List<JSONRepresentation> list) {
        return list.stream()
                .map(JSONRepresentation::toJson)
                .collect(Collectors.joining(",\n", "[", "]"));
    }
}
