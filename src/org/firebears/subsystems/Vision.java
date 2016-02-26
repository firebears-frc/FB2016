package org.firebears.subsystems;

import org.firebears.RobotMap;
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
	
	final String PREF_DIST_MULTIPLIER = "vision.dist_multiplier";
	final String PREF_ANGLE_MULTIPLIER = "vision.angle_multiplier";
	final String PREF_TARGET_DISTANCE = "vision.target_distance";
	final String PREF_HUE_LO = "vision.hue.lo";
	final String PREF_HUE_HI = "vision.hue.hi";
	final String PREF_SAT_LO = "vision.sat.lo";
	final String PREF_SAT_HI = "vision.sat.hi";
	final String PREF_VAL_LO = "vision.val.lo";
	final String PREF_VAL_HI = "vision.val.hi";

	final double DIST_MULTIPLIER = .001;
	final double ANGLE_MULTIPLIER = .1;
	final double TARGET_DISTANCE = 40.;
	final double HUE_LO = 0.;
	final double HUE_HI = 255.;
	final double SAT_LO = 0.;
	final double SAT_HI = 255.;
	final double VAL_LO = 0.;
	final double VAL_HI = 255.;
	
	public double dist_multiplier = DIST_MULTIPLIER;
	public double angle_multiplier = ANGLE_MULTIPLIER;
	public double target_distance = TARGET_DISTANCE;

	@Override
	protected void initDefaultCommand() {}
	
	public void readSettingsFromPreferences() {
		dist_multiplier = RobotMap.getPreferencesDouble(PREF_DIST_MULTIPLIER, DIST_MULTIPLIER);
		angle_multiplier = RobotMap.getPreferencesDouble(PREF_ANGLE_MULTIPLIER, ANGLE_MULTIPLIER);
		target_distance = RobotMap.getPreferencesDouble(PREF_TARGET_DISTANCE, TARGET_DISTANCE);
	}
	
	public void init() {
		readSettingsFromPreferences();
		RobotMap.getPreferencesDouble(PREF_HUE_LO, HUE_LO);
		RobotMap.getPreferencesDouble(PREF_HUE_HI, HUE_HI);
		RobotMap.getPreferencesDouble(PREF_HUE_LO, SAT_LO);
		RobotMap.getPreferencesDouble(PREF_HUE_HI, SAT_HI);
		RobotMap.getPreferencesDouble(PREF_HUE_LO, VAL_LO);
		RobotMap.getPreferencesDouble(PREF_HUE_HI, VAL_HI);
	}
	
	public double getAngle() {
		return angle_multiplier * NetworkTablesJNI.getDouble(NT_ANGLE, 0);
	}
	
	public double getRemainingDistance() {
		return dist_multiplier * (NetworkTablesJNI.getDouble(NT_DISTANCE, 0) - TARGET_DISTANCE);
	}

}