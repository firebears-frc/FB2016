package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class DriveStraightCommand extends PIDCommand {
	double targetDistance = 60;
	
    public DriveStraightCommand(double z) {
    	super(0.1,0,0);
    	requires(Robot.chassis);
    	targetDistance = z;
    	getPIDController().setAbsoluteTolerance(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double target = targetDistance + RobotMap.encoderLeft.getDistance();
    	setSetpoint(target);
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
		Robot.chassis.drive(0, 0);	
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.drive(0, 0);
    }

	@Override
	protected double returnPIDInput() {
		return RobotMap.encoderLeft.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.chassis.drive(0, output * -1);
		
	}
}

