package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class AdjustRotation extends PIDCommand {

    public AdjustRotation() {
    	super(0.05, 0.1, 0.1); //PID
    	requires(Robot.chassis);
    }

	@Override
	protected double returnPIDInput() {
		return RobotMap.navXBoard.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		if (output > 0.6){
			output = 0.6;
		} else if (output < -0.6){
			output = -0.6;
		}
		Robot.chassis.drive(output, 0);
	}

	@Override
	protected void initialize() {
		getPIDController().setContinuous(true);
    	getPIDController().setInputRange(0, 359);
    	getPIDController().setAbsoluteTolerance(2);
    	getPIDController().enable();
		setSetpoint(RobotMap.rotation);
		setTimeout(5);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		if (isTimedOut()){
			return true;
		}
		return Math.abs(RobotMap.navXBoard.getAngle() - RobotMap.rotation)< 2;
	}

	@Override
	protected void end() {
		Robot.chassis.drive(0, 0);
	}

	@Override
	protected void interrupted() {
		Robot.chassis.drive(0, 0);
	}

}
