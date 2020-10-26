package com.vytrhlik;

import com.github.rvesse.airline.Cli;
import com.github.rvesse.airline.help.Help;
import com.vytrhlik.commands.FileCommand;

/**
 * Prime app
 */
@com.github.rvesse.airline.annotations.Cli(name = "prime",
        description = "CLI application for finding prime numbers from .xlsx file",
        defaultCommand = Help.class,
        commands = {FileCommand.class, Help.class})
public class App {
    public static void main(String[] args) {
        Cli<Runnable> cli = new Cli<>(App.class);
        Runnable cmd = cli.parse(args);
        cmd.run();
    }
}
