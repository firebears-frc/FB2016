package org.firebears.commands.defenses;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Cheval de Frise is a series of four (4) independently tilting, weighted polycarbonate platforms. 
 * The platforms rotate about a pipe in the middle and are weighted so that they rest on alternate 
 * sides. Platforms are 1 ft. wide and 2 ft. long and ½ in. thick. The axis of the pipe is 3-3/4 in. from 
 * the surface of the platform. The top edge of the platform is 9-5/8 in. from the DEFENSE platform. 
 * In order to tilt a platform, approximately 1 lbs. of force must be applied at the edge of the platform.
 */
public class ChevalDeFriseCommand extends CommandGroup {
    
    public  ChevalDeFriseCommand() {
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
