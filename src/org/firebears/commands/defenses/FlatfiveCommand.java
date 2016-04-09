package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;

public class FlatfiveCommand extends AbstractDefenseCommand {
    
    public  FlatfiveCommand(boolean shoot) {
    	addSequential(new GetRotation());
        addSequential(new DriveStraightCommand(165.,.75));
        // Do vision if shooting.
        finishAuto(-40.);     
    	requires(Robot.chassis);
    }
    
    public FlatfiveCommand() {
    	this(true);
    }
}
