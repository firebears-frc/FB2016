package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

public class RoughTerrainCommand extends AbstractDefenseCommand {
    
    public  RoughTerrainCommand(boolean shoot) {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(180.,.75));
        // Do vision if shooting.
        finishAuto(shoot);     
    	requires(Robot.chassis);
    }
    
    public RoughTerrainCommand() {
    	this(true);
    }
}
