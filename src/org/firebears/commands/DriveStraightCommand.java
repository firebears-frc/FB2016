

package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 * Drive straight a certain distance.
 */
public class DriveStraightCommand extends PIDCommand {
	final double max_speed;
	final double distance;
	double targetLocation;
	double targetAngle;
	long timeout;

    public DriveStraightCommand(double z, double speed) {
    	super(0.1,0,0);
    	requires(Robot.chassis);
    	distance = z;
    	max_speed = speed;
    	getPIDController().setAbsoluteTolerance(2);
    }
    
    public DriveStraightCommand(double z) {
    	this(z, .6);
    }

    protected void initialize() {
    	 timeout = System.currentTimeMillis() + 5000;
    	targetAngle = RobotMap.navXBoard.getAngle();
    	targetLocation = distance + RobotMap.encoderLeft.getDistance();
    	setSetpoint(targetLocation);
    	getPIDController().enable();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	double currentLocation = returnPIDInput();
    	return (Math.abs(currentLocation - targetLocation) < 2)||(System.currentTimeMillis() > timeout);
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
		output = Math.max((max_speed*-1), Math.min(output, max_speed));
		double currentAngle = RobotMap.navXBoard.getAngle();
		double angleDiff = targetAngle - currentAngle;
		double x = angleDiff * 0.1;
		x = Math.max(-0.2, Math.min(x, 0.2));
		double y = -1 * output;
		Robot.chassis.drive(x, y);

	}
}

