package com.sagar.pattern.behavioral.command;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FileInvoker {
	public Queue<ICommand> commands = new ArrayBlockingQueue<>(10);

	public FileInvoker() {
	}

	public void addCommand(ICommand command) {
		commands.add(command);
	}

	public void execute() {
		while (!commands.isEmpty()) {
			commands.poll().execute();
		}
	}
}
