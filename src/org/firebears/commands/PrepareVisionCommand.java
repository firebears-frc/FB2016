package org.firebears.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrepareVisionCommand extends CommandGroup {
    	
    public  PrepareVisionCommand(int position) {
    	switch(position) {
    		default:
    			break;
    		case 1:
    	        // Turn toward target.
 //   	    	addSequential(new GetRotation());
    	    	addSequential(new AdjustRotation(85.));
    	    	break;
    		case 2:
    			// Turn toward target.
    	    	addSequential(new GetRotation());
    	    	addSequential(new AdjustRotation(45.));
    	    	break;
    		case 3:
    			// Turn Right
    	    	addSequential(new GetRotation());
    	    	addSequential(new AdjustRotation(90.));
    	    	// 3 Feet to the right
    	        addSequential(new DriveStraightCommand(3.,.85));
    	    	// Turn Left toward target
    	    	addSequential(new GetRotation());
    	    	addSequential(new AdjustRotation(-120.));
    	    	break;
    		case 4:
    			// Point toward target
    	    	addSequential(new GetRotation());
    	    	addSequential(new AdjustRotation(-30.));
    	    	break;
    		case 5:
    	        // Turn toward target.
    	    	addSequential(new GetRotation());
    	    	addSequential(new AdjustRotation(-60.));
    	    	break;
    	}
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
