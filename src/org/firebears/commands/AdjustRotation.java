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

    public AdjustRotation() {
    	super(.009, 0.00001, 0.00); //PID
    	requires(Robot.chassis);
    }
    
    public AdjustRotation(double degree_offset) {
    	super(.009, 0.00001, 0.0); //PID
    	requires(Robot.chassis);
    	offset = degree_offset;
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
