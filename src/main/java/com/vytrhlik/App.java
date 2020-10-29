package com.vytrhlik;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.parser.ParseResult;
import com.github.rvesse.airline.parser.errors.ParseException;

/**
 * Prime app
 */
public class App {
    public static void main(String[] args) {
        try {
            SingleCommand<PrimeCommand> command = SingleCommand.singleCommand(PrimeCommand.class);
            ParseResult<PrimeCommand> result = command.parseWithResult(args);
            if (result.wasSuccessful()) {
                result.getCommand().run();
            } else {
                System.err.printf("%d errors encountered:%n", result.getErrors().size());
                int i = 1;
                for (ParseException e : result.getErrors()) {
                    System.err.printf("Error %d: %s%n", i, e.getMessage());
                    i++;
                }

                System.err.println();

                com.github.rvesse.airline.help.Help.help(command.getCommandMetadata(), System.err);
            }
        } catch (Exception e) {
            System.err.printf("Unexpected error: %s%" +
                    "n", e.getMessage());
            System.exit(1);
        }
    }
}
