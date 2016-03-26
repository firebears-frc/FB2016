package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Set the Shooter spinner speed
 */
public class ShooterSpinCommand extends Command {

	final double speed;

    public ShooterSpinCommand(double speed) {
    	requires(Robot.shooter);
        this.speed = speed;
    }

    protected void initialize() {
    	if (speed <= 0.0) {
    		Robot.shooter.disable();
    		Robot.shooter.shootingMotor.set(-speed);
    	} else {
    		Robot.shooter.enable();
        	Robot.shooter.setSetpoint(speed);
    	}
    	Robot.lights.shootMode();
    }

    protected void execute() {
    }
   
	protected boolean isFinished() {
		return Robot.shooter.onTarget();
		// return false;
	}

    protected void end() {
    }

    protected void interrupted() {
    	Robot.lights.teleopMode();
    }
}
