package org.firebears.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TestAutoCommand extends CommandGroup {
    
    public  TestAutoCommand() {
    	addSequential(new GetRotation());
//    	addSequential(new DriveStraightCommand(45, .65));
//    	addSequential(new RotationCommand(90));
    	addSequential(new WaitCommand(1.5));
    	addSequential(new AdjustRotation());
    }
}
