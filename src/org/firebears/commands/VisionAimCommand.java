package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to align the robot to the U shaped target in order to shoot.
 */
public class VisionAimCommand extends Command {

	public double AngleTolerance = .1;
	final static double TARGET_DISTANCE = -60.;
	final static double FORWARD_SPEED = .5;
	
    public VisionAimCommand() {
    	requires(Robot.chassis);
    	requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Angle", Robot.vision.getAngle());
    	SmartDashboard.putNumber("Distance Away", Robot.vision.getRemainingDistance());
    	Robot.chassis.drive(-1.5 * Robot.vision.getAngle(), -FORWARD_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double angle = Robot.vision.getAngle();
    	double dist = Robot.vision.getRemainingDistance();
    	
    	System.out.println("Dist = " + dist + ", Angle = " + angle);
    	// If Remaining Distance is within tolerance, or past, then stop.
    	if(dist <= TARGET_DISTANCE) {
    		return true;
    	}else{
    		return false;
    	}
/*    	if(angle > -AngleTolerance && angle < AngleTolerance) {
    		// Angle is in the acceptable range.
    		if(dist > -DistanceTolerance && dist < DistanceTolerance) {
    			// Distance is in the acceptable range.
    			return true;
    		}else{
    			return false;
    		}
    	}else{
    		// Angle needs to be adjusted
    		return false;
    	}*/
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
