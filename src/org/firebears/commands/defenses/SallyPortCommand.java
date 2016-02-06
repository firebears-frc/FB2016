package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Sally Port is a door ¼” thick, 4 ft. wide, 2 ft. tall that can only swing toward the NEUTRAL 
 * ZONE. The opening is 3 ft. 6 in. wide. The top of the door is 2 ft. 1 in. from the surface of the
 * platform. The door is sprung so that it will return to a closed position when it is not being held 
 * open. A force of approximately 1.5 lbs. must be applied to the outer edge of the door in order for it 
 * to open.
 */
public class SallyPortCommand extends CommandGroup {
    
    public  SallyPortCommand() {
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
