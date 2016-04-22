package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BatterCommand extends CommandGroup {
    
    public  BatterCommand() {
    	addSequential(new BatterDetetion(5.));
    	addSequential(new ParkCommand());
//    	requires(Robot.chassis);
    }
}
