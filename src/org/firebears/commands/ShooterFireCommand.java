package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Causes the Shooter's servo to kick the ball into the spinner.
 */
public class ShooterFireCommand extends Command {

	public final int SHOOTER_RESET = 0;
	public final int SHOOTER_FIRE = 1;
	public final int SHOOTER_TOGGLE = 2;
	public int shooter_mode;
	
    public ShooterFireCommand(int mode) {
        requires(Robot.shooter);
        shooter_mode = mode;
    }

    
    
    protected void initialize() {
//    	setTimeout(100);
    	switch(shooter_mode) {
    		case SHOOTER_TOGGLE:
		    	if(RobotMap.servoOn) {
		    		Robot.shooter.servoReset();
		    	}else{
		    		Robot.shooter.servoFire();
		    	}
		    	break;
    		case SHOOTER_FIRE:
    			Robot.shooter.servoFire();
    			break;
    		case SHOOTER_RESET:
    			Robot.shooter.servoReset();
    			break;
    		default:
    			Robot.shooter.servoReset();
    			break;
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
