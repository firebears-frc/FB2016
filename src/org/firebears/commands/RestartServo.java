package org.firebears.commands;

import static org.firebears.commands.ShooterFireCommand.SHOOTER_FIRE;
import static org.firebears.commands.ShooterFireCommand.SHOOTER_RESET;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RestartServo extends CommandGroup {
    
    public  RestartServo() {
    	addSequential(new ShooterFireCommand(SHOOTER_RESET));
    	addSequential(new WaitCommand(.25));
    	addSequential(new ShooterFireCommand(SHOOTER_FIRE));
    	requires(Robot.shooter);
    }
}
