package com.vytrhlik.commands;

import com.github.rvesse.airline.HelpOption;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.OptionType;
import com.github.rvesse.airline.annotations.restrictions.Pattern;

import javax.inject.Inject;

@Command(name = "file", description = "Set .xlsx file")
public class FileCommand implements Runnable {

    @Option(type = OptionType.COMMAND, name = {"-f", "--file"}, description = "Set .xlsx file")
    @Pattern(pattern="([a-zA-Z]:(\\\\w+)*\\\\[a-zA-Z0_9]+)?.xlsx")
    private String file;

    @Inject
    private HelpOption<FileCommand> help;


    @Override
    public void run() {
        if (!help.showHelpIfRequested()) {
            System.out.println("Xlsx file: " + file);
        }
    }
}
