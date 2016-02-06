package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Ramparts are two static, steel ramps, side by side, facing opposite directions. Each ramp is 2
 * ft. wide and 1 ft. 10 in. deep, set at an 8 deg. angle.
 */
public class RampartsCommand extends CommandGroup {
    
    public  RampartsCommand() {
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
