package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Rock Wall is a steel block that is 4 ft. 2 in. wide, 5-¼ in. deep, and 4-5/8 in. tall.
 */
public class RockWallCommand extends CommandGroup {
    
    public  RockWallCommand() {
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
