package org.firebears.commands.defenses;

import org.firebears.commands.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Moat is a 2-1/2 in. high, 4 ft. 2 in. wide, and 1 ft. 8 in. deep u-shaped channel, formed by
 * vertical rectangular steel tubes. 
 */
public class MoatCommand extends CommandGroup {
    
    public  MoatCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new DriveStraightCommand(120, 0.6));

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
