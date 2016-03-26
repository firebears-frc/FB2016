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
    	addSequential(new WaitCommand(0.25));
    	addSequential(new ShooterSpinCommand(speed),1.5);
    	//addSequential(new WaitCommand(.5));
    	addSequential(new ShooterFireCommand(SHOOTER_FIRE));
    	addSequential(new WaitCommand(2.0));
    	addSequential(new ShooterSpinCommand(0),.5);
//    	addSequential(new ShooterFireCommand(1),.10);
    	requires(Robot.shooter);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
