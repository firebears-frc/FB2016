package org.firebears.commands;

import org.firebears.Robot;

/**
 * Store preferences into the RoboRio's file system, based on the position of the 
 * defense buster arm.
 */
public class SetPreferencesDefenseBuster extends SetPreferences {

	public SetPreferencesDefenseBuster(String keyName) {
		super(keyName);
	}
	
	@Override
	protected double getValue() {
		return Robot.defenseBuster.getPosition();
	}
}
