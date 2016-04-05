package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.AdjustRotation;
import org.firebears.commands.AimAndShootCommand;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;
import org.firebears.commands.RotationCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Moat is a 2-1/2 in. high, 4 ft. 2 in. wide, and 1 ft. 8 in. deep u-shaped channel, formed by
 * vertical rectangular steel tubes. 
 */
public class MoatCommand extends CommandGroup {
    
    public  MoatCommand() {
 
    	// Get over defense
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(180.,.85));
        // Point to target
    	addSequential(new AdjustRotation(-30.));
    	// Vision take over.
    	addSequential(new AimAndShootCommand());
     
    	requires(Robot.chassis);
    }
}
