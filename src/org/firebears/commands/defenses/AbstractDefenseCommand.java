package org.firebears.commands.defenses;

import org.firebears.commands.AdjustRotation;
import org.firebears.commands.AimAndShootCommand;
import org.firebears.commands.PrepareVisionCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class AbstractDefenseCommand extends CommandGroup {

	void finishAuto(boolean shoot) {
	    if(shoot) {
	        // Point to target
	    	addSequential(new AdjustRotation(-30.));
//			addSequential(new PrepareVisionCommand(4));
	    	// Vision take over.
	    	addSequential(new AimAndShootCommand());
	    }else{
	    	addSequential(new AdjustRotation());
	    }
	}
	
}
