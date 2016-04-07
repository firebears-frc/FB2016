package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Rotate the robot "degrees" degrees
 */
public class RotationCommand extends PIDCommand {

	protected final double turnValue;
	protected final double SPEED = 0.9;
	protected double angleTolerance = 5.0;
	protected double targetAngle;

	public RotationCommand(double degrees) {
		super(0.1, 0.00001, 0.0); // PID
		requires(Robot.chassis);
		turnValue = degrees;
		
		getPIDController().setContinuous(true);
		getPIDController().setInputRange(-180, 180);
		getPIDController().setAbsoluteTolerance(angleTolerance);
	}

	/**
	 * @return (angle2 - angle1) in the range from -180 to 180.
	 *     This is the angle to get from angle1 to angle2.
	 */
	private static double getAngleDifference(double angle1, double angle2) {
		return bound(angle2 - angle1);
	}

	/**
	 * @return the angle folded into the range -180 to 180.
	 */
	protected static double bound(double angle) {
		while (angle >= 360) angle -= 360;
		while (angle < 0) angle += 360;
		if (angle > 180) angle = angle - 360;
		return angle;
	}

	/**
	 * @return the angle from the current heading to get back to the target angle, 
	 *     in the range -180 to 180.
	 */
	private double getAngleDifference() {
		return getAngleDifference(RobotMap.navXBoard.getAngle(), targetAngle);
	}

	protected void initialize() {
		targetAngle = bound(RobotMap.navXBoard.getAngle() + turnValue);
		getPIDController().setSetpoint(0.0);

	}

	protected void execute() {
	}

	/**
	 * @return true when the angle difference gets close to zero.
	 */
	protected boolean isFinished() {
		double difference = getAngleDifference();
//		SmartDashboard.putNumber("Difference", difference);
		return Math.abs(difference) < angleTolerance;
	}

	protected void end() {
		Robot.chassis.drive(0.0, 0.0);
	}

	protected void interrupted() {
		end();
	}

	@Override
	/**
	 * @return the angle distance from the current heading to the target angle.
	 */
	protected double returnPIDInput() {
		return getAngleDifference();
	}

	@Override
	protected void usePIDOutput(double output) {
		output = Math.max(-SPEED, Math.min(output, SPEED));
		Robot.chassis.drive(output, 0.0);
	}

	// Unit tests.
//	public static void main(String arg[]) {
//		System.out.println("0,30 = 30; " + getAngleDifference(0, 30));
//		System.out.println("20,50 = 30; " + getAngleDifference(20, 50));
//		System.out.println("20,350 = -30; " + getAngleDifference(20, 350));
//		System.out.println("340,10 = 30; " + getAngleDifference(340, 10));
//		System.out.println("170,-170 = 20; " + getAngleDifference(170, -170));
//		System.out.println("110,-110 = 140; " + getAngleDifference(110, -110));
//		System.out.println("-110,110 = -140; " + getAngleDifference(-110, 110));
//		System.out.println("110,250 = 140; " + getAngleDifference(110, 250));
//		System.out.println("250,110 = -140; " + getAngleDifference(250, 110));
//	}
	
}
