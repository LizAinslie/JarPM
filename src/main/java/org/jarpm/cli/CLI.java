package org.jarpm.cli;

import org.jarpm.cli.commands.InitCommand;

import picocli.CommandLine;
import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Command;

@Command(subcommands = {
	HelpCommand.class,
	InitCommand.class
})
public class CLI implements Runnable {
	public static void main(String[] args) {
		CommandLine.run(new CLI(), args);
	}

	public void run() {}
}
