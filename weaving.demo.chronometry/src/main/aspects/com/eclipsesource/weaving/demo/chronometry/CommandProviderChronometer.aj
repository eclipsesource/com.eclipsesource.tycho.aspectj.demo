package com.eclipsesource.weaving.demo.chronometry;

import org.eclipse.osgi.framework.console.CommandInterpreter;

import org.eclipse.osgi.framework.console.CommandProvider;

public aspect CommandProviderChronometer {
	void around(CommandInterpreter ci): execution(void CommandProvider+._faculty(CommandInterpreter)) && args(ci) {
		long start = System.nanoTime();
		proceed(ci);
		long duration = System.nanoTime() - start;
		System.out.println("Result calculated in " + (duration / 1000) + " micro seconds");
	}

}
