package org.firebears.commands;

import org.firebears.Robot;

/**
 * Drive straight a certain distance, but stop if the ultrasonic rangefinder
 * shows we are a certain distance from the wall.
 */
public class DriveStraightCommandAndStop extends DriveStraightCommand {

	private final double stop_distance;
	
	/**
	 * @param driveDistance  Distance to drive in inches.
	 * @param speed  relative speed in the range (0 to 1.0).
	 * @param stopDistance  Distance to stop, in inches.
	 */
    public DriveStraightCommandAndStop(double driveDistance, double speed, double stopDistance) {
    	super(driveDistance, speed);
    	stop_distance = stopDistance;
    }
    
    @Override
    protected boolean isFinished() {
    	double dist = Robot.shooter.getRangeFinderDistance();
    	System.out.println("Dist =" + dist + ",  " + stop_distance);
    	if (dist < stop_distance) {
    		return true;
    	}
    	return super.isFinished();

    }
	
}
