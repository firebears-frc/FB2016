package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.subsystems.BallGetter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallGetterSetpointCommand extends Command {

	private double setpoint;
	
    public BallGetterSetpointCommand(double value) {
        requires(Robot.ballGetter);
        setpoint = value;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (setpoint == Robot.ballGetter.MIN_VALUE){
    		Robot.ballGetter.ballGetterPosition = 1;
    	}else if(setpoint  == Robot.ballGetter.MAX_VALUE) {
    		Robot.ballGetter.ballGetterPosition = 2;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ballGetter.setSetpoint(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
