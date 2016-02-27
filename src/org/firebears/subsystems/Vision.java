package org.firebears.subsystems;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTablesJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem to interface with the raspberry pi.
 */
public class Vision extends Subsystem {
	
	static Preferences preferences = Preferences.getInstance();

	final static String NT_CALIBRATION = "vision/calibrationMode";
	final static String NT_DISTANCE = "vision/distance";
	final static String NT_ANGLE = "vision/angle";
	final static String NT_FPS = "vision/fps";
	final static String NT_IMG = "vision/image";
	final static String NT_HUE_LO = "vision/hue.lo";
	final static String NT_HUE_HI = "vision/hue.hi";
	final static String NT_SAT_LO = "vision/sat.lo";
	final static String NT_SAT_HI = "vision/sat.hi";
	final static String NT_VAL_LO = "vision/val.lo";
	final static String NT_VAL_HI = "vision/val.hi";
	
	public final static String PREF_DIST_MULTIPLIER = "vision.dist_multiplier";
	public final static String PREF_ANGLE_MULTIPLIER = "vision.angle_multiplier";
	public final static String PREF_TARGET_DISTANCE = "vision.target_distance";
	public final static String PREF_HUE_LO = "vision.hue.lo";
	public final static String PREF_HUE_HI = "vision.hue.hi";
	public final static String PREF_SAT_LO = "vision.sat.lo";
	public final static String PREF_SAT_HI = "vision.sat.hi";
	public final static String PREF_VAL_LO = "vision.val.lo";
	public final static String PREF_VAL_HI = "vision.val.hi";

	final static double DIST_MULTIPLIER = .001;
	final static double ANGLE_MULTIPLIER = .1;
	final static double TARGET_DISTANCE = 40.;
	final static double HUE_LO = 0.;
	final static double HUE_HI = 255.;
	final static double SAT_LO = 0.;
	final static double SAT_HI = 255.;
	final static double VAL_LO = 0.;
	final static double VAL_HI = 255.;
	
	public static double dist_multiplier = DIST_MULTIPLIER;
	public static double angle_multiplier = ANGLE_MULTIPLIER;
	public static double target_distance = TARGET_DISTANCE;

	@Override
	protected void initDefaultCommand() {}
	
	// Read the preferences and set Network Tables
	public static void readSettingsFromPreferences() {
		dist_multiplier = RobotMap.getPreferencesDouble(PREF_DIST_MULTIPLIER, DIST_MULTIPLIER);
		angle_multiplier = RobotMap.getPreferencesDouble(PREF_ANGLE_MULTIPLIER, ANGLE_MULTIPLIER);
		target_distance = RobotMap.getPreferencesDouble(PREF_TARGET_DISTANCE, TARGET_DISTANCE);
		NetworkTablesJNI.putDouble(NT_HUE_LO, RobotMap.getPreferencesDouble(PREF_HUE_LO, HUE_LO));
		NetworkTablesJNI.putDouble(NT_HUE_HI, RobotMap.getPreferencesDouble(PREF_HUE_HI, HUE_HI));
		NetworkTablesJNI.putDouble(NT_SAT_LO, RobotMap.getPreferencesDouble(PREF_SAT_LO, SAT_LO));
		NetworkTablesJNI.putDouble(NT_SAT_HI, RobotMap.getPreferencesDouble(PREF_SAT_HI, SAT_HI));
		NetworkTablesJNI.putDouble(NT_VAL_LO, RobotMap.getPreferencesDouble(PREF_VAL_LO, VAL_LO));
		NetworkTablesJNI.putDouble(NT_VAL_HI, RobotMap.getPreferencesDouble(PREF_VAL_HI, VAL_HI));
	}
	
	// Save vison calibration
	public static void saveCalibration(String whatpref, double x) {
		preferences.putDouble(whatpref, x);
	}
	
	public void init() {
		readSettingsFromPreferences();
	}
	
	public double getAngle() {
		return angle_multiplier * NetworkTablesJNI.getDouble(NT_ANGLE, 0);
	}
	
	public double getRemainingDistance() {
		return dist_multiplier * (NetworkTablesJNI.getDouble(NT_DISTANCE, 0) - TARGET_DISTANCE);
	}
	
	public static class SaveToPref extends Command {

		String whatpref;
		
		public SaveToPref(String saveVal) {
			whatpref = saveVal;
		}
		
		@Override
		protected void initialize() {
			double setTo = SmartDashboard.getNumber("Vision Set");
			
			// Smart Dashboard -> Preferences
			saveCalibration(whatpref, setTo);
			// Preferences -> Network Tables
			readSettingsFromPreferences();
			// Notify
			SmartDashboard.putString("Vision Calib", "Set " + whatpref + " to " + setTo);
			SmartDashboard.putString("Vision Settings",
					"Hue [ " + preferences.getDouble(PREF_HUE_LO, 0.) +  "," + preferences.getDouble(PREF_HUE_HI, 255.) + " ] \n" +
					"Sat [ " + preferences.getDouble(PREF_SAT_LO, 0.) +  "," + preferences.getDouble(PREF_SAT_HI, 255.) + " ] \n" +
					"Val [ " + preferences.getDouble(PREF_VAL_LO, 0.) +  "," + preferences.getDouble(PREF_VAL_HI, 255.) + " ] \n");
		}

		@Override
		protected void execute() { }

		@Override
		protected boolean isFinished() {
			return true;
		}

		@Override
		protected void end() { }

		@Override
		protected void interrupted() { }
		
	}

}