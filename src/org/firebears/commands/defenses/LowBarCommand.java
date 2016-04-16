package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.AdjustRotation;
import org.firebears.commands.AimAndShootCommand;
import org.firebears.commands.BallGetterSetpointCommand;
import org.firebears.commands.DefenseBusterSetpointCommand;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.GetRotation;
import org.firebears.commands.RotationCommand;

/**
 *
 */
public class LowBarCommand extends AbstractDefenseCommand {

	final boolean shoot;
	
    public  LowBarCommand(boolean shoot) {
    	requires(Robot.chassis);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

    	addSequential(new GetRotation());
    	addSequential(new BallGetterSetpointCommand(Robot.ballGetter.MAX_VALUE));
    	addSequential(new DefenseBusterSetpointCommand(Robot.defenseBuster.MAX_VALUE));
    	addSequential(new DriveStraightCommand(216., .6));
    	// Vision take over.
    	addSequential(new AdjustRotation());
    	//addSequential(new RotationCommand(65));
    	//addSequential(new AimAndShootCommand());
    	//
    	requires(Robot.chassis);
    	requires(Robot.defenseBuster);
    	requires(Robot.ballGetter);
    	this.shoot = shoot;
    }
    
    public LowBarCommand() {
    	this(true);
    }
    
    public String toString() {
    	return "LowBar" + (shoot?"-shoot":"");
    }
}
