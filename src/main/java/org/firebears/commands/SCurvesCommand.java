package org.firebears.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Turn right, travel some distance, and then turn left.
 */
public class SCurvesCommand extends CommandGroup {
	
	/** Low bar. */
	public static final double DEFENSE_1 = 8.0;
	
	/** Second defense from the left. */
	public static final double DEFENSE_2 = 4.0;
	
	/** Third defense from the left; near the center. */
	public static final double DEFENSE_3 = 0.0; 
	
	/** Fourth defense from the right; near the center*/
	public static final double DEFENSE_4 = 0.0; 
	
	/** Far right defense, near the secret passage */
	public static final double DEFENSE_5 = 4.0; 

	public SCurvesCommand(double distance) {
		this(distance, true);
	}

	/**
	 * @param distance
	 *            Distance to travel in inches.
	 * @param turnRight
	 *            whether the first turn is to the right.
	 */
	public SCurvesCommand(double distance, boolean turnRight) {
		addSequential(new RotateCurveCommand(turnRight ? 90 : -90));
		if (distance > 0) {
			addSequential(new DriveStraightCommand(distance, 0.8));
		}
		addSequential(new RotateCurveCommand(turnRight ? -90 : 90));
	}
}
