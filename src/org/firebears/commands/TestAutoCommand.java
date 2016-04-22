package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TestAutoCommand extends CommandGroup {
    
    public  TestAutoCommand() {
//    	addSequential(new GetRotation());
//    	addSequential(new DriveStraightCommand(45, .65));
//    	addSequential(new RotationCommand(90));
//    	addSequential(new WaitCommand(1.5));
//    	addSequential(new AdjustRotation());
//    	addSequential(new RotationCommand(40.));
//    	addSequential(new WaitCommand(.75));
//    	addSequential(new GetRotation());
//    	addSequential(new RotationCommand(-40.));
    	
//		auto end rollup.
//    	addSequential(new Pitch(85,.6,5));
//    	addSequential(new BailSetpointCommand(Robot.bail.MIN_VALUE));
//    	addSequential(new BallGetterSetpointCommand(Robot.ballGetter.MIN_VALUE));
//    	addSequential(new WaitCommand(.5));
//    	addSequential(new DriveStraightCommand(25,.7));
    	
    	addSequential(new BatterDetetion(3.));
    	addSequential(new WaitCommand(1.25));
    	addSequential(new Fire());
//    	
    	
//    	requires(Robot.chassis);
    	
    }
}
