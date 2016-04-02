package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to align the robot to the U shaped target in order to shoot.
 */
public class VisionAimCommand extends Command {

	public double AngleTolerance = .1;
	private boolean goBack;
	final static double TARGET_DISTANCE = -70.;
	final static double FORWARD_SPEED = .5;
	
    public VisionAimCommand(boolean backward) {
    	requires(Robot.chassis);
    	requires(Robot.vision);
    	goBack = backward;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Angle", Robot.vision.getAngle());
    	SmartDashboard.putNumber("Distance Away", Robot.vision.getRemainingDistance());
    	Robot.chassis.drive((goBack ? -2: 1) * (.4 * Robot.vision.getAngle()) +
    			(.6 * (Robot.vision.getAngle() > 0 ? FORWARD_SPEED : -FORWARD_SPEED)),
    			goBack ? FORWARD_SPEED : -FORWARD_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double angle = Robot.vision.getAngle();
    	double dist = Robot.vision.getRemainingDistance();
    	
    	System.out.println("Dist = " + dist + "/ " + TARGET_DISTANCE + ", Angle = " + angle);
    	// If Remaining Distance is within tolerance, or past, then stop.
    	if((dist <= TARGET_DISTANCE) && goBack == false) {
        	System.out.println("Reached Target: Dist = " + dist + ", Angle = " + angle);
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
