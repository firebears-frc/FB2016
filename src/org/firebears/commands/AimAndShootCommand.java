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

    	// Aim the robot at the U.
    	addSequential(new VisionAimCommand());
    	// Shoot the boulder into the castle.
    	addSequential(new Fire());
    	
    	// Requires
    	requires(Robot.chassis);
    	requires(Robot.vision);
    }
}
