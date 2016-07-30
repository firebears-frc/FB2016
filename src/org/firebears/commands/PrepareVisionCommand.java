package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.commands.defenses.FlatCommand;
import org.firebears.commands.defenses.LowBarCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive forward, turn, and shoot. Specific to one of the defense positions.
 */
public class PrepareVisionCommand extends CommandGroup {

	final int position;
	final boolean shoot;

	public PrepareVisionCommand(int position) {
		this(position, true);
	}

	public PrepareVisionCommand(int position, boolean shoot) {
		this.position = position;
		this.shoot = shoot;
		switch (position) {

		case 1:
			// Go though low bar, on the far left defense position
			addSequential(new LowBarCommand(false));
			addSequential(new RotationCommand(50));
			addSequential(new DriveStraightCommand(36, 0.75));
			if (shoot) {
				addSequential(new AimAndShootCommand());
			}
			break;
		case 2:
			// Go through defense position 2, on the second from the left position.
			addSequential(new GetRotation());
			addSequential(new DriveStraightCommand(220, 0.75));
			addSequential(new AdjustRotation1());
			addSequential(new RotationCommand(40));
			if (shoot) {
				addSequential(new AimAndShootCommand());
			}
			break;
		case 3:
			// Go through defense position 3, near the middle
			addSequential(new GetRotation());
			addSequential(new DriveStraightCommand(140, 0.75));
			addSequential(new AdjustRotation1());
			addSequential(new RotationCommand(30));
			addSequential(new DriveStraightCommand(40, 0.75));
			addSequential(new AdjustRotation1());
			if (shoot) {
				addSequential(new AimAndShootCommand());
			}
			break;
		case 4:
			// Go through defense position 4; to the right of the middle
			addSequential(new GetRotation());
			addSequential(new DriveStraightCommand(180, 0.75));
			addSequential(new AdjustRotation1());
			addSequential(new RotationCommand(-20));
			if (shoot) {
				addSequential(new AimAndShootCommand());
			}
			break;
		case 5:
			// Go through defense position 2; closest to secret passage
			addSequential(new GetRotation());
			addSequential(new DriveStraightCommand(140, 0.75));
			addSequential(new AdjustRotation1());
			addSequential(new RotationCommand(-40));
			addSequential(new DriveStraightCommand(60, 0.75));
			addSequential(new AdjustRotation1());
			if (shoot) {
				addSequential(new AimAndShootCommand());
			}
			break;
		default:
			break;
		}

	}

	protected void initialize() {
		if (RobotMap.DEBUG) System.out.println("\t * " + this);
	}

	public String toString() {
		return "Defense=" + this.position + (shoot ? "-shoot" : "-no");
	}
}
