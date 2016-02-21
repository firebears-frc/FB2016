package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Causes the Shooter's servo to kick the ball into the spinner.
 */
public class ShooterFireCommand extends Command {

    public ShooterFireCommand() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	setTimeout(2);
    	Robot.shooter.servoFire();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.shooter.servoReset();
    }

    protected void interrupted() {
    	Robot.shooter.servoReset();
    }
}
