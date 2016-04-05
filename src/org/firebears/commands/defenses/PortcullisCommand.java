package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.DefenseBusterSetpointCommand;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.DriveStraightCommandAndStop;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * The Portcullis is an arched gateway with a door that opens when lifted up. The gateway is 3 ft. 8 in. 
 * wide and 5 ft. 2 in. tall. The door is constructed of a steel frame with a 1/8 in. thick polycarbonate
 * sheet covering the opening in the frame. The door requires approximately 5 lbs. to lift from the
 * bottom edge. When it is resting in its natural position there is a 5 in. gap below the door.
 */
public class PortcullisCommand extends CommandGroup {
    
    public  PortcullisCommand() {
    	addSequential(new DefenseBusterSetpointCommand(Robot.defenseBuster.MAX_VALUE));
    	addSequential(new WaitCommand(.25));
    	addSequential(new DriveStraightCommandAndStop(60, .65, 15));
    	addSequential(new WaitCommand(.125));
    	addSequential(new DefenseBusterSetpointCommand(Robot.defenseBuster.MIN_VALUE));
    	addSequential(new DriveStraightCommand(40));
    	requires(Robot.chassis);
    	
    }
}
