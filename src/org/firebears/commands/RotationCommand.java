package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class RotationCommand extends PIDCommand {

	double turnValue;
	private double initialAngle;
	
    public RotationCommand(double degrees) {
        super(.01, 0.0, 0.0); //PID
        turnValue = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialAngle = RobotMap.navXBoard.getAngle();
    	getPIDController().setContinuous(true);
    	getPIDController().setSetpoint(turnValue);
    	getPIDController().setAbsoluteTolerance(5);
    	getPIDController().setInputRange(0, 360);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.drive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		double difference = RobotMap.navXBoard.getAngle()-initialAngle;
//		return (difference > 180)? 360 - difference: difference;
		return difference;
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.chassis.drive(output, 0.0);
	}
}
