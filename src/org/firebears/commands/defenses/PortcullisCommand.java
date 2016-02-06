package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Portcullis is an arched gateway with a door that opens when lifted up. The gateway is 3 ft. 8 in. 
 * wide and 5 ft. 2 in. tall. The door is constructed of a steel frame with a 1/8 in. thick polycarbonate
 * sheet covering the opening in the frame. The door requires approximately 5 lbs. to lift from the
 * bottom edge. When it is resting in its natural position there is a 5 in. gap below the door.
 */
public class PortcullisCommand extends CommandGroup {
    
    public  PortcullisCommand() {
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
