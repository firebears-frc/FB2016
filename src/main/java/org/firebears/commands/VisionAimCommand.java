package org.firebears.commands;

import static org.firebears.subsystems.Vision.ANGLE_TOLERANCE;
import static org.firebears.subsystems.Vision.DIST_TOLERANCE;
import static org.firebears.subsystems.Vision.TARGET_DISTANCE;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to align the robot to the U shaped target in order to shoot.
 */
public class VisionAimCommand extends Command {

	final private boolean goBack;
	final public static double FORWARD_SPEED = 0.70;
	final public static double TURN_SPEED = 0.65;
	final public static double PITCH_LIMIT = 5.0;

	public VisionAimCommand(boolean backward) {
		requires(Robot.chassis);
		requires(Robot.vision);
		goBack = backward;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (RobotMap.DEBUG) System.out.println("\t # " + this);
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
		boolean onTarget = Robot.vision.isOnTarget();
		if (RobotMap.DEBUG)  
			System.out.printf("\t %c   Dist = %6.1f / %6.1f,   Angle = %8.4f,   onTarget = %b : \n", (goBack ? '<' : '>'),
				Math.abs(dist), Math.abs(TARGET_DISTANCE), angle, onTarget);

		// Distance of 500 means the camera can't see the target
		if (Math.abs(dist) >= 500) { 
			return false; 
		}
		
		double pitch = RobotMap.navXBoard.getPitch();
		if (PITCH_LIMIT>0.0 && pitch > PITCH_LIMIT)  {
			if (RobotMap.DEBUG)  System.out.printf("\tReached the batter:  pitch= %8.4f\n", pitch);
			return true;
		}
		
		// If going forwards and remaining distance is within tolerance, or
		// past, then stop.
		if ((goBack == false) && (dist <= TARGET_DISTANCE)) {
			if (RobotMap.DEBUG)  System.out.printf("\tReached Target: Dist = %6.1f, Angle = %8.4f\n", dist, angle);
			return true;
		}

		// If both distance and angle are within tolerance, then stop
		if ((Math.abs(dist - TARGET_DISTANCE) <= DIST_TOLERANCE) && (Math.abs(angle) <= ANGLE_TOLERANCE)) {
			return true;
		}

		return false;

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
	
	@Override
	public String toString() {
		return "VisionAimCommand(" + goBack + ")";
	}
}
