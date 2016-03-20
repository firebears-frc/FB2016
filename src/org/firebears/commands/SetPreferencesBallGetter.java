package org.firebears.commands;

import org.firebears.Robot;

/**
 * Store preferences into the RoboRio's file system, based on the position of the 
 * ball getter arm.
 */
public class SetPreferencesBallGetter extends SetPreferences {

	public SetPreferencesBallGetter(String keyName) {
		super(keyName);
	}
	
	@Override
	protected double getValue() {
		return Robot.ballGetter.getPosition();
	}
}
