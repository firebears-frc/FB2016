package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 *
 */
public class ParkCommand extends CommandGroup {
    
	class BreakCommand extends Command {
		@Override
		protected void initialize() {
			Robot.chassis.setBrakeMode(true);
		}

		@Override
		protected void execute() { }

		@Override
		protected boolean isFinished() {
			return true;
		}

		@Override
		protected void end() { }

		@Override
		protected void interrupted() { }
	}
	
    public  ParkCommand() {
    	// Drive up the slope until wall is hit.
    	// addSequential(new DriveStraightCommand(DriveStraightCommand.UNTIL.UNTIL_HIT_WALL, .6));
    	// Turn on break as to not move.
    	addSequential(new BreakCommand());
    }
}
