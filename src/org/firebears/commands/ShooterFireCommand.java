package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Causes the Shooter's servo to kick the ball into the spinner.
 */
public class ShooterFireCommand extends Command {

    public ShooterFireCommand() {
        requires(Robot.shooter);
    }

    protected void initialize() {
//    	setTimeout(100);
    	if(RobotMap.servoOn) {
    		Robot.shooter.servoReset();
    		RobotMap.servoOn = false;
    	}else{
    		Robot.shooter.servoFire();
    		RobotMap.servoOn = true;
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
