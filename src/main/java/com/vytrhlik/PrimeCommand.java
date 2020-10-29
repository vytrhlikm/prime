package com.vytrhlik;

import com.github.rvesse.airline.HelpOption;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.Pattern;

import javax.inject.Inject;

@Command(name = "prime", description = "command for finding prime numbers from .xlsx file")
public class PrimeCommand implements Runnable {

    @Option(name = {"-f", "--file"}, description = "Set .xlsx file")
    @Pattern(pattern = "([a-zA-Z]:(\\\\w+)*\\\\[a-zA-Z0_9]+)?.xlsx")
    private String file;

    @Inject
    private HelpOption help;

    private final PrimeResolver resolver = new PrimeResolver();

    @Override
    public void run() {
        if (!help.showHelpIfRequested()) {
            if (null != file) {
                resolver.resolve(file);
            }
            else {
                System.out.println("Parameter for xlsx file wasn't defined!");
                help.showHelp();
            }
        }
    }
}
