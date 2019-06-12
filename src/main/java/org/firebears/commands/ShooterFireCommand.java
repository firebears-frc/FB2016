package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Causes the Shooter's servo to kick the ball into the spinner.
 */
public class ShooterFireCommand extends Command {

	public static final int SHOOTER_RESET = 0;
	public static final int SHOOTER_FIRE = 1;
	public static final int SHOOTER_TOGGLE = 2;
	public static final int SHOOTER_PARK = 3;
	public int shooter_mode;
	
    public ShooterFireCommand(int mode) {
        requires(Robot.shooter);
        shooter_mode = mode;
    }

    protected void initialize() {
//    	setTimeout(100);
		if (RobotMap.DEBUG) System.out.println("\t # " + this);
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
    		case SHOOTER_PARK:
    			Robot.shooter.servoHold();
    			break;
    		default:
    			Robot.shooter.servoFire();
    			break;
    	}
    	setTimeout(1);
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
    
    @Override
	public String toString() {
		return "ShooterFireCommand("
				+ (shooter_mode == SHOOTER_RESET ? "RESET" 
						: (shooter_mode == SHOOTER_FIRE ? "FIRE" 
								: (shooter_mode == SHOOTER_PARK ? "PARK" 
										: "TOGGLE"))) + ")";
	}
}
