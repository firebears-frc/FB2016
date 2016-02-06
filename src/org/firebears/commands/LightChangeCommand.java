package org.firebears.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.firebears.Robot;

/**
 * Command For Changing A Strip (p_which) to a different animation (p_anim)
 */
public class LightChangeCommand extends Command {

	private final String stripName;
	private final String animationName;

	public LightChangeCommand(String stripName, String animationName) {
		requires(Robot.lights);
		this.stripName = stripName;
		this.animationName = animationName;
	}

	protected void initialize() {
		Robot.lights.setStrip(stripName, animationName);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
