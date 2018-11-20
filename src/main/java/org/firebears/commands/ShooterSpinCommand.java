package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

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
		if (RobotMap.DEBUG) System.out.println("\t # " + this);
    	if (speed <= 0.0) {
    		Robot.shooter.disable();
    		Robot.shooter.shootingMotor.set(-speed);
    	} else {
    		Robot.shooter.enable();
        	Robot.shooter.spinnerStart();
    	}
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
    
    @Override
    public String toString() {
    	return "ShooterSpinCommand(" + this.speed + ")";
    }
}
