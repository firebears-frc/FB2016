package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

public class RoughTerrainCommand extends AbstractDefenseCommand {
	
	final boolean shoot;
    
    public  RoughTerrainCommand(boolean shoot) {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(165.,.75));
        // Do vision if shooting.
        finishAuto(shoot);     
    	requires(Robot.chassis);
    	this.shoot = shoot;
    }
    
    public RoughTerrainCommand() {
    	this(true);
    }
    
    public String toString() {
    	return "RoughTerrain" + (shoot?"-shoot":"");
    }
}
