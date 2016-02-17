package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.AdjustRotation;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Moat is a 2-1/2 in. high, 4 ft. 2 in. wide, and 1 ft. 8 in. deep u-shaped channel, formed by
 * vertical rectangular steel tubes. 
 */
public class MoatCommand extends CommandGroup {
    
    public  MoatCommand() {
 
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(120.,.75));
    	addSequential(new AdjustRotation());
     
    	requires(Robot.chassis);
    }
}
