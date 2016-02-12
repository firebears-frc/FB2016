package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 * Drive straight a certain distance.
 */
public class DriveStraightCommand extends PIDCommand {
	static final double MAX_SPEED = 0.6;
	final double distance;
	double targetLocation;
	double targetAngle;

    public DriveStraightCommand(double z) {
    	super(0.1,0,0);
    	requires(Robot.chassis);
    	distance = z;
    	getPIDController().setAbsoluteTolerance(2);
    }

    protected void initialize() {
    	targetAngle = RobotMap.navXBoard.getAngle();
    	targetLocation = distance + RobotMap.encoderLeft.getDistance();
    	setSetpoint(targetLocation);
    	getPIDController().enable();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	double currentLocation = returnPIDInput();
    	return Math.abs(currentLocation - targetLocation) < 2;
//        return getPIDController().onTarget();
    }

    protected void end() {
    	getPIDController().disable();
		Robot.chassis.drive(0, 0);
    }

    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return RobotMap.encoderLeft.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		output = Math.max((MAX_SPEED*-1), Math.min(output, MAX_SPEED));
		double currentAngle = RobotMap.navXBoard.getAngle();
		double angleDiff = targetAngle - currentAngle;
		double x = angleDiff * 0.1;
		x = Math.max(-0.2, Math.min(x, 0.2));
		double y = -1 * output;
		Robot.chassis.drive(x, y);

	}
}

