package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pitch extends DriveStraightCommand {
	
	private final double angl;
	

    public Pitch(double driveDistance, double speed, double angle) {
    	super(driveDistance, speed);
    	
    	angl = angle;

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected boolean isFinished() {
    	double y = RobotMap.navXBoard.getPitch();
    	if (y > angl) {
    		return true;
    	}
    	return super.isFinished();

    }
}