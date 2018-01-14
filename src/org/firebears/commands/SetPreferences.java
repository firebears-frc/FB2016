package org.firebears.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetPreferences extends Command {

	Preferences preferences;
	final private String KEYNAME;
	static public final String SET_VAR = "Set Preferences";

	public SetPreferences(String KeyName) {
		preferences = Preferences.getInstance();
		KEYNAME = KeyName;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double setTo = getValue();
		preferences.putDouble(KEYNAME, setTo);
	}

	protected double getValue() {
		return SmartDashboard.getNumber(SET_VAR, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
