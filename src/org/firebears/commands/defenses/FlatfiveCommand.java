package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

public class FlatfiveCommand extends AbstractDefenseCommand {
    
	final boolean shoot;
	
    public  FlatfiveCommand(boolean shoot) {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(165.,.75));
        // Do vision if shooting.
        finishAuto(-40.);     
    	requires(Robot.chassis);
    	this.shoot = shoot;
    }
    
    public FlatfiveCommand() {
    	this(true);
    }
    
    public String toString() {
    	return "FlatFive" + (shoot?"-shoot":"");
    }
}
