package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Turns the shooter mot0r to a value from the joystick's throttle.
 */
public class ShooterTesterCommand extends Command {

    public ShooterTesterCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double value = Robot.oi.joystick2.getThrottle();
    	if (RobotMap.DEBUG) {
    		SmartDashboard.putNumber("Throttle", value);
			SmartDashboard.putNumber("RPM", 1.0 / RobotMap.shooterCounter.getPeriod());
    	}
    	RobotMap.shooterShootingMotor.set(value);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.shooterShootingMotor.set(0);
    }

    protected void interrupted() {
    	end();
    }
}
