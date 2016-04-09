package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

public class FlatCommand extends AbstractDefenseCommand {
    
    public  FlatCommand(boolean shoot) {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(165.,.75));
        // Do vision if shooting.
        finishAuto(shoot);     
    	requires(Robot.chassis);
    }
    
    public FlatCommand() {
    	this(true);
    }
}
