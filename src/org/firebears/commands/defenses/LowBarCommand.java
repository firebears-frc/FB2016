package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.BallGetterSetpointCommand;
import org.firebears.commands.DefenseBusterSetpointCommand;
import org.firebears.commands.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarCommand extends CommandGroup {

    public  LowBarCommand() {
    	requires(Robot.chassis);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

    	addSequential(new BallGetterSetpointCommand(Robot.ballGetter.MAX_VALUE - 0.15));
    	addSequential(new DefenseBusterSetpointCommand(Robot.defenseBuster.MAX_VALUE));
    	addSequential(new DriveStraightCommand(60., .6));

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
