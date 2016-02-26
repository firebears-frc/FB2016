package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to align the robot to the U shaped target in order to shoot.
 */
public class VisionAimCommand extends Command {

	public double AngleTolerance = .1;
	public double DistanceTolerance = .1;
	
    public VisionAimCommand() {
    	requires(Robot.chassis);
    	requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(
    			Robot.vision.getAngle(),
    			Robot.vision.getRemainingDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double angle = Robot.vision.getAngle();
    	double dist = Robot.vision.getRemainingDistance();
    	
    	if(angle > -AngleTolerance && angle < AngleTolerance) {
    		// Angle is in the acceptable range.
    		if(dist > -DistanceTolerance && dist < DistanceTolerance) {
    			// Distance is in the acceptable range.
    			return true;
    		}else{
    			return false;
    		}
    	}else{
    		// Angle needs to be adjused
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
