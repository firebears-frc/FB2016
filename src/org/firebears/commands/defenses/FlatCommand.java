package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

/**
 * Drive forward and shoot.
 * Useful for rock wall, rough terrain, moat, etc.
 */
public class FlatCommand extends AbstractDefenseCommand {
	
	final boolean shoot;
	
    public  FlatCommand(boolean shoot) {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(165.,.75));
        // Do vision if shooting.
        finishAuto(shoot);     
    	requires(Robot.chassis);
    	this.shoot = shoot;
    }
    
    public FlatCommand() {
    	this(true);
    }
    
    public String toString() {
    	return "Flat" + (shoot?"-shoot":"");
    }
}
