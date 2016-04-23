package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import static org.firebears.commands.ShooterFireCommand.SHOOTER_FIRE;
import static org.firebears.commands.ShooterFireCommand.SHOOTER_RESET;

/**
 * Shoot the boulder.  Lowers the bale, revs up the spinner, pushes 
 * the boulder into the spinner, and then shuts down the spinner.
 */
public class Fire extends CommandGroup {
    
    public  Fire() {
    	this(120);
    }
	
    /**
     * @param speed Goal rate for the spinner PID setpoint.
     */
    public  Fire(final double speed) {
    	addSequential(new ShooterFireCommand(SHOOTER_RESET));
    	addSequential(new WaitCommand(0.50));
    	addSequential(new ShooterSpinCommand(speed),3);
    	addSequential(new WaitCommand(0.50));
    	addSequential(new ShooterFireCommand(SHOOTER_FIRE));
    	addSequential(new WaitCommand(3.0));
    	addSequential(new ShooterSpinCommand(0),.5);
//    	addSequential(new ShooterFireCommand(1),.10);
    	requires(Robot.shooter);
 
    }
}
