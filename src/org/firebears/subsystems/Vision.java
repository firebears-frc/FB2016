package org.firebears.subsystems;

import org.firebears.RobotMap;
import org.firebears.commands.VisionCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTablesJNI;

/**
 * Subsystem to interface with the raspberry pi.
 */
public class Vision extends Subsystem {

	final String NT_CALIBRATION = "vision/calibrationMode";
	final String NT_DISTANCE = "vision/distance";
	final String NT_ANGLE = "vision/angle";
	final String NT_FPS = "vision/fps";
	final String NT_IMG = "vision/image";
	
	final String NT_DIST_MULTIPLIER = "vision.processing.dist_multiplier";
	final String NT_ANGLE_MULTIPLIER = "vision.processing.angle_multiplier";
	final String NT_TARGET_DISTANCE = "vision.processing.target_distance";

	final double DIST_MULTIPLIER = .001;
	final double ANGLE_MULTIPLIER = .1;
	final double TARGET_DISTANCE = 40.;
	
	public double dist_multiplier = DIST_MULTIPLIER;
	public double angle_multiplier = ANGLE_MULTIPLIER;
	public double target_distance = TARGET_DISTANCE;
	
	@Override
	protected void initDefaultCommand() {}
	
	public void readSettingsFromPreferences() {
		dist_multiplier = RobotMap.getPreferencesDouble(NT_DIST_MULTIPLIER, DIST_MULTIPLIER);
		angle_multiplier = RobotMap.getPreferencesDouble(NT_ANGLE_MULTIPLIER, ANGLE_MULTIPLIER);
		target_distance = RobotMap.getPreferencesDouble(NT_TARGET_DISTANCE, TARGET_DISTANCE);
	}
	
	public double getAngle() {
		return ANGLE_MULTIPLIER * NetworkTablesJNI.getDouble(NT_ANGLE, 0);
	}
	
	public double getRemainingDistance() {
		return DIST_MULTIPLIER * (NetworkTablesJNI.getDouble(NT_DISTANCE, 0) - TARGET_DISTANCE);
	}

}