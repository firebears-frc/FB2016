package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to align the robot to the U shaped target in order to shoot.
 */
public class VisionAimCommand extends Command {

	final public double AngleTolerance = .1;
	final public double DistanceTolerance = 5;
	final private boolean goBack;
	final static double TARGET_DISTANCE = -65.;
	final static double FORWARD_SPEED = .6;
	final static double TURN_SPEED = .5;

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
		double angle = Robot.vision.getAngle();
		double dist = Robot.vision.getRemainingDistance();
		SmartDashboard.putNumber("Angle", angle);
		SmartDashboard.putNumber("Distance Away", dist);
		double rotateValue = (goBack ? -2 : 1) * (.4 * angle) + (.6 * (angle > 0 ? TURN_SPEED : -TURN_SPEED));
		double moveValue = goBack ? FORWARD_SPEED : -FORWARD_SPEED;
		Robot.chassis.drive(rotateValue, moveValue);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double angle = Robot.vision.getAngle();
		double dist = Robot.vision.getRemainingDistance();
		System.out.printf("Dist = %8.1f / %8.1f, Angle = %8.4f   : \n)", dist, TARGET_DISTANCE, angle);

		// If going forwards and remaining distance is within tolerance, or past, then stop.
		if ((goBack == false) && (dist <= TARGET_DISTANCE) ) {
			System.out.println("Reached Target: Dist = " + dist + ", Angle = " + angle);
			return true;
		}
		
		// If both distance and angle are within tolerance, then stop
		if ((Math.abs(dist - TARGET_DISTANCE) <= DistanceTolerance) 
				&& (Math.abs(angle) <= AngleTolerance)) {
			return true;
		}
		
		return false;

		// if (angle > -AngleTolerance && angle < AngleTolerance) {
		// // Angle is in the acceptable range.
		// if (dist > -DistanceTolerance && dist < DistanceTolerance) {
		// // Distance is in the acceptable range.
		// return true;
		// } else {
		// return false;
		// }
		// } else {
		// // Angle needs to be adjusted
		// return false;
		// }

	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.chassis.stopDriving();
	}

	// Called when another command which requires one or more of the same 
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.chassis.stopDriving();
	}
}
