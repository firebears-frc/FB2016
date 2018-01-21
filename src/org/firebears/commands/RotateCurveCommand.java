package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 * Drive the robot forward in a curve until it has rotated a given number of degrees.
 * @author keith
 *
 */
public class RotateCurveCommand extends PIDCommand {

	protected final double TURN_VALUE;
	protected final double MAX_FORWARD;
	protected final double MAX_CURVE;
	protected double angleTolerance = 3.0;
	protected double targetAngle;

	public RotateCurveCommand(double degrees) {
		this(degrees, 0.3, 0.5);
	}

	public RotateCurveCommand(double degrees, double maxCurve) {
		this(degrees, maxCurve, 0.4);
	}

	public RotateCurveCommand(double degrees, double maxCurve, double maxForward) {
		super(0.0275, 0.0, 0.0); // PID
		TURN_VALUE = degrees;
		MAX_CURVE = maxCurve;
		MAX_FORWARD = maxForward;

		requires(Robot.chassis);
		
		getPIDController().setInputRange(-180, 180);
		getPIDController().setContinuous(true);
		getPIDController().setAbsoluteTolerance(angleTolerance);
	}

	/**
	 * @return (angle2 - angle1) in the range from -180 to 180. This is the
	 *         angle to get from angle1 to angle2.
	 */
	private static double getAngleDifference(double angle1, double angle2) {
		return bound(angle2 - angle1);
	}

	/**
	 * @return the angle folded into the range -180 to 180.
	 */
	protected static double bound(double angle) {
		while (angle > 180) { angle -= 360; }
		while (angle < -180) { angle += 360; }
		return angle;
	}

	/**
	 * @return the angle from the current heading to get back to the target
	 *         angle, in the range -180 to 180.
	 */
	private double getAngleDifference() {
		return getAngleDifference(targetAngle, RobotMap.navXBoard.getAngle());
	}

	protected void initialize() {
		targetAngle = bound(RobotMap.navXBoard.getAngle() + TURN_VALUE);
		getPIDController().setSetpoint(0.0);
		setTimeout(Math.round(Math.abs(TURN_VALUE/20.0)));
	}

	protected void execute() { }

	/**
	 * @return true when the angle difference gets close to zero.
	 */
	protected boolean isFinished() {
		if (isTimedOut()) { return true; }
		double difference = getAngleDifference();
		return Math.abs(difference) < angleTolerance;
	}

	protected void end() {
		Robot.chassis.stopDriving();
	}

	protected void interrupted() {
		end();
	}

	/**
	 * @return the angle distance from the current heading to the target angle.
	 */
	@Override
	protected double returnPIDInput() {
		return getAngleDifference();
	}

	/**
	 * Set the speed of forward motion and curving.
	 * @param output value in the range -1.0 to 1.0.
	 */
	@Override
	protected void usePIDOutput(double output) {
		double curve = Math.max(-MAX_CURVE, Math.min(output, MAX_CURVE));
		double forward = Math.min(Math.abs(output), MAX_FORWARD);
		Robot.chassis.driveCurve(forward, curve);
	}

}
