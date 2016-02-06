package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Rough Terrain is constructed from thirty-one (31) pieces of square or rectangular steel tubing. 
 * There are three different sizes of steel tubing: 1 in. by 3 in., 2 in. by 3 in., and 3 in. by 3 in.
 * All of the tubing is cut into 3 in. lengths. The tubing is then welded on to a steel plate to form
 * a “random” series of bumps spaced 1-1/2 in. from each other.
 */
public class RoughTerrainCommand extends CommandGroup {
    
    public  RoughTerrainCommand() {
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
