package com.eclipsesource.weaving.demo.faculty;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class FacultyCommandProvider implements CommandProvider, BundleActivator {

	public void _faculty(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		int argumentAsInteger = Integer.valueOf(argument).intValue();
		System.out.println("Faculty of " + argumentAsInteger + " is " + recur(argumentAsInteger));
	}

	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---faculty commands---\n");
		buffer.append("\tfaculty {number} - calculate faculty of given number\n");
		return buffer.toString();
	}

	private int recur(int x) {
		if (x <= 1) {
			return 1;
		} else {
			return x * recur(x - 1);
		}
	}

	@Override
	public void start(BundleContext arg0) throws Exception {
		System.out.println("start");
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("stop");
	}

}
