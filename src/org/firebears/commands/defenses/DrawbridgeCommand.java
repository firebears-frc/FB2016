package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Drawbridge is an arched gateway with a door that lowers toward the NEUTRAL ZONE. The 
 * door is made from polycarbonate and is 37 in. tall and ¼ in. thick. When the door is fully down, 
 * the opening is 3 ft. 6 in. wide and 5 ft. 5-3/4 in. tall (to the top of the center of the arch). The door 
 * is sprung so that it will return to a closed position when there is no weight on it. The door can be 
 * manipulated at any point, but for reference, it takes approximately 2 lbs. of force applied at the top 
 * edge of the door for it to begin to move. Once moving, the required force increases to a maximum of 5 lbs
 */
public class DrawbridgeCommand extends CommandGroup {
    
    public  DrawbridgeCommand() {
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
