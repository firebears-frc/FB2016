package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pitch extends DriveStraightCommand {
	
	double angl;
	

    public Pitch(double driveDistance, double speed, double angle) {
    	super(driveDistance, speed);
    	
    	angl = angle;

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	double y = RobotMap.navXBoard.getPitch();
    	if (y > angl) {
    		return true;
    	}
    	return super.isFinished();

    }
	

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
