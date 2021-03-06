package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Aim at the U shaped target and when aligned, shoot a boulder.
 */
public class AimAndShootCommand extends CommandGroup {
    
    public  AimAndShootCommand() {
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    	// Drive forward Aim the robot at the U.
    	addSequential(new VisionAimCommand(false),5.0);
    	// Drive backward Aim the robot at the U.
//    	addSequential(new VisionAimCommand(true),1.0);
//    	// Drive forward Aim the robot at the U.
//    	addSequential(new VisionAimCommand(false),6.0);
//    	// Shoot the boulder into the castle.
    	addSequential(new Fire(120)); 
    	
    	// Requires
    	requires(Robot.chassis);
    	requires(Robot.vision);
    	requires(Robot.shooter);
    }
}
