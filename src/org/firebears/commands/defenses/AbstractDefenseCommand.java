package org.firebears.commands.defenses;

import org.firebears.commands.AdjustRotation;
import org.firebears.commands.AdjustRotation1;
import org.firebears.commands.AimAndShootCommand;
import org.firebears.commands.PrepareVisionCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class AbstractDefenseCommand extends CommandGroup {

	void finishAuto(boolean shoot) {
		if (shoot) {
			// Point to target
			addSequential(new AdjustRotation(-30.));
			// addSequential(new PrepareVisionCommand(4));
			// Vision take over.
			addSequential(new AimAndShootCommand());
		} else {
			addSequential(new AdjustRotation());
		}
	}

	void finishAuto(double degrees) {
		addSequential(new AdjustRotation1(degrees));
		addSequential(new AimAndShootCommand());
	}

	/** @return Text to display in row 1 of the LCD. */
	public String getRow1() {
		return "";
	}

	/** @return Text to display in row 2 of the LCD. */
	public String getRow2() {
		return "";
	}

	/** @return Text to display in row 3 of the LCD. */
	public String getRow3() {
		return "";
	}

	/** @return Text to display in row 4 of the LCD. */
	public String getRow4() {
		return "";
	}

}
