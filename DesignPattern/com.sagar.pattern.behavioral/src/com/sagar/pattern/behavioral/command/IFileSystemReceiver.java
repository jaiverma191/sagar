package com.sagar.pattern.behavioral.command;

public interface IFileSystemReceiver {
	void openFile();

	void writeFile();

	void closeFile();
}
