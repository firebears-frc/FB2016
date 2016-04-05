package org.firebears.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAutoCommand extends CommandGroup {
    
    public  TestAutoCommand() {
    	addSequential(new GetRotation());
    	addSequential(new DriveStraightCommand(45, .65));
    	addSequential(new AdjustRotation());
    }
}
