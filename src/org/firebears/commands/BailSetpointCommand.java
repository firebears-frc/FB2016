package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BailSetpointCommand extends Command {
	
	private double setpoint;

    public BailSetpointCommand(double value) {//set (double value)for two button command
        requires(Robot.bail);
        requires(Robot.chassis);
        setpoint = value;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (setpoint == Robot.bail.PARK_VALUE){
    	}else if (setpoint == Robot.bail.MAX_VALUE){
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.defenseBuster.setSetpoint(setpoint);
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
