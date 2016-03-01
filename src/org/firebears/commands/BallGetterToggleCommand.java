package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.subsystems.BallGetter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallGetterToggleCommand extends Command {
	
    public BallGetterToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ballGetter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	switch(Robot.ballGetter.ballGetterPosition){
    		case (1):
    			Robot.ballGetter.setSetpoint(Robot.ballGetter.MAX_VALUE-0.15);
    			Robot.ballGetter.ballGetterPosition = 2;
    			break;
    		case (2):
    			Robot.ballGetter.setSetpoint(Robot.ballGetter.MIN_VALUE+0.1);
    			Robot.ballGetter.ballGetterPosition = 1;
    			break;
    	}
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
