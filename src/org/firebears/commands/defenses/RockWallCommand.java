package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.AdjustRotation;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class RockWallCommand extends CommandGroup {
    
    public  RockWallCommand() {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(180.,.75));
    	addSequential(new AdjustRotation());
     
    	requires(Robot.chassis);
    }
}
