package com.eclipsesource.weaving.demo.faculty;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

public class FacultyCommandProvider implements CommandProvider {

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

}
