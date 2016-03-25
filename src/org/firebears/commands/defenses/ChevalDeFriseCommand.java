package org.firebears.commands.defenses;

import org.firebears.Robot;
import org.firebears.commands.AdjustRotation;
import org.firebears.commands.DefenseBusterSetpointCommand;
import org.firebears.commands.DriveStraightCommand;
import org.firebears.commands.DriveStraightCommandAndStop;
import org.firebears.commands.GetRotation;
import org.firebears.commands.RangeFinderStop;
import org.firebears.commands.RotationCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * The Cheval de Frise is a series of four (4) independently tilting, weighted polycarbonate platforms. 
 * The platforms rotate about a pipe in the middle and are weighted so that they rest on alternate 
 * sides. Platforms are 1 ft. wide and 2 ft. long and ½ in. thick. The axis of the pipe is 3-3/4 in. from 
 * the surface of the platform. The top edge of the platform is 9-5/8 in. from the DEFENSE platform. 
 * In order to tilt a platform, approximately 1 lbs. of force must be applied at the edge of the platform.
 */
public class ChevalDeFriseCommand extends CommandGroup {
    
    public  ChevalDeFriseCommand() {
    	
//    	addParallel(new DriveStraightCommand(60,.5));
    	addSequential(new DriveStraightCommandAndStop(60, .45 , 15));
    	addSequential(new WaitCommand(1.25));
    	addSequential(new DefenseBusterSetpointCommand(Robot.defenseBuster.MAX_VALUE));
    	addSequential(new WaitCommand(.25));
    	addSequential(new DriveStraightCommand(30,.7));
    	addSequential(new DefenseBusterSetpointCommand(Robot.defenseBuster.MIN_VALUE));
    	addSequential(new DriveStraightCommand(30,.7));
    	addSequential(new DriveStraightCommand(30,.8));

    	requires(Robot.chassis);
    }
}
