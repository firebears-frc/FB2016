package org.firebears.commands.defenses;

import org.firebears.*;
import org.firebears.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The Ramparts are two static, steel ramps, side by side, facing opposite directions. Each ramp is 2
 * ft. wide and 1 ft. 10 in. deep, set at an 8 deg. angle.
 */
public class RampartsCommand extends CommandGroup {
    
    public  RampartsCommand() {
//    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(210.,.85));
//    	addSequential(new AdjustRotation());
     
    	requires(Robot.chassis);
    }
}
