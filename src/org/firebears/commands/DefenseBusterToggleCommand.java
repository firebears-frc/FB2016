package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DefenseBusterToggleCommand extends Command {
	
    public DefenseBusterToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.defenseBuster);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	switch(Robot.defenseBuster.defenseBusterPosition){
    		case(1):
    			Robot.defenseBuster.setSetpoint(Robot.defenseBuster.MAX_VALUE);
				Robot.defenseBuster.defenseBusterPosition = 2;
				break;
    		case (2):
    			Robot.defenseBuster.setSetpoint(Robot.defenseBuster.MIN_VALUE);
				Robot.defenseBuster.defenseBusterPosition = 1;
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
