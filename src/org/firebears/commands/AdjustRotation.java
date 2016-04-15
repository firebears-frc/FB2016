package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AdjustRotation extends PIDCommand {
	
	double offset = 0.;
	public static final double MAX_SPEED = 0.5;

    public AdjustRotation() {
    	super(.020, 0.00001, 0.00); //PID
    	requires(Robot.chassis);
    }
    
    public AdjustRotation(double degree_offset) {
    	super(.020, 0.00001, 0.00); //PID
    	requires(Robot.chassis);
    	offset = degree_offset;
    }

	@Override
	protected double returnPIDInput() {
		return RobotMap.navXBoard.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		if (output > MAX_SPEED){
			output = MAX_SPEED;
		} else if (output < -1 * MAX_SPEED){
			output = -1 * MAX_SPEED;
		}
		Robot.chassis.drive(output, 0);
	}
	
	private double bound(double which) {
		if(which >= 360.) {
			return which - 360;
		}else if(which < 0){
			return which + 360;
		}else{
			return which;
		}
	}

	@Override
	protected void initialize() {
		getPIDController().setContinuous(true);
    	getPIDController().setInputRange(0, 359);
    	getPIDController().setAbsoluteTolerance(2);
    	getPIDController().enable();
		setSetpoint(bound(RobotMap.rotation + offset));
		Robot.chassis.setBrakeMode(true);
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
		Robot.chassis.setBrakeMode(false);
	}

	@Override
	protected void interrupted() {
		Robot.chassis.drive(0, 0);
		Robot.chassis.setBrakeMode(false);
	}

}
