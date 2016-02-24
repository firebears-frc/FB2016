package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AimAndShootCommand extends CommandGroup {
    
    public  AimAndShootCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    	addSequential(command);
    	requires(Robot.chassis);
    	requires(Robot.vision);
    }
}
