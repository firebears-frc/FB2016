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
	protected final double SPEED = 0.5;
	protected double angleTolerance = 5.0;
	protected double targetAngle;
	long timeout;

	public RotationCommand(double degrees) {
		super(1., 0.0, 0.0); // PID
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
		while (angle > 180) angle -= 360;
		while (angle < -180) angle += 360;
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
		timeout = System.currentTimeMillis() + 1000 * 2;
		targetAngle = bound(RobotMap.navXBoard.getAngle() + turnValue);
		getPIDController().setSetpoint(0.0);
		if (RobotMap.DEBUG) System.out.println("\t # " + this);
		
	}

	protected void execute() {
	}

	/**
	 * @return true when the angle difference gets close to zero.
	 */
	protected boolean isFinished() {
		double difference = getAngleDifference();
//		System.out.println("Target + " + targetAngle + ", Turn" + turnValue + ", Now" + RobotMap.navXBoard.getAngle() + ", Diff" + difference);
//		SmartDashboard.putNumber("Difference", difference);
		
		return Math.abs(difference) < angleTolerance ||System.currentTimeMillis() >= timeout;
	}

	protected void end() {
		Robot.chassis.stopDriving();
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
		Robot.chassis.drive(-output, 0.0);
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
//		
//		for (int angle = -200 ; angle < 400; angle+=45) {
//			System.out.println("bound(" + angle + ") = " + bound(angle));
//		}
//		System.out.println("bound(" + 180 + ") = " + bound(180));
//		System.out.println("bound(" + -180 + ") = " + bound(-180));
//	}
	
    
    @Override
    public String toString() {
    	return "RotationCommand(" + this.turnValue + ")";
    }
}
