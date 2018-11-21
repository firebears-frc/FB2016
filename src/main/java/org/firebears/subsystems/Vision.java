package org.firebears.subsystems;

import org.firebears.RobotMap;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem to interface with the raspberry pi.
 */
public class Vision extends Subsystem {

	static Preferences preferences = Preferences.getInstance();
	private double movingAvg = 0.;

	final static public double ANGLE_TOLERANCE = 0.1;
	final static public double DIST_TOLERANCE = 2;
	final static public double TARGET_DISTANCE = -65.0;
	
	final static String NT_DISTANCE = "distance";
	final static String NT_ANGLE = "angle";
	final static String NT_FPS = "fps";
	final static String NT_HUE_LO = "hue.lo";
	final static String NT_HUE_HI = "hue.hi";
	final static String NT_SAT_LO = "sat.lo";
	final static String NT_SAT_HI = "sat.hi";
	final static String NT_VAL_LO = "val.lo";
	final static String NT_VAL_HI = "val.hi";

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
	final static double ANGLE_MULTIPLIER = -.9 * .01;
	final static double HUE_LO = 0.;
	final static double HUE_HI = 255.;
	final static double SAT_LO = 0.;
	final static double SAT_HI = 255.;
	final static double VAL_LO = 0.;
	final static double VAL_HI = 255.;

	public static double dist_multiplier = DIST_MULTIPLIER;
	public static double angle_multiplier = ANGLE_MULTIPLIER;

	public double which_defense = 0;

	Relay lightRing;

	NetworkTable networkTable = null;

	@Override
	protected void initDefaultCommand() {
	}

	// Read the preferences and set Network Tables
	public static void readSettingsFromPreferences() {
		dist_multiplier = RobotMap.getPreferencesDouble(PREF_DIST_MULTIPLIER, DIST_MULTIPLIER);
		angle_multiplier = RobotMap.getPreferencesDouble(PREF_ANGLE_MULTIPLIER, ANGLE_MULTIPLIER);
		// NetworkTablesJNI.putDouble(NT_HUE_LO,
		// RobotMap.getPreferencesDouble(PREF_HUE_LO, HUE_LO));
		// NetworkTablesJNI.putDouble(NT_HUE_HI,
		// RobotMap.getPreferencesDouble(PREF_HUE_HI, HUE_HI));
		// NetworkTablesJNI.putDouble(NT_SAT_LO,
		// RobotMap.getPreferencesDouble(PREF_SAT_LO, SAT_LO));
		// NetworkTablesJNI.putDouble(NT_SAT_HI,
		// RobotMap.getPreferencesDouble(PREF_SAT_HI, SAT_HI));
		// NetworkTablesJNI.putDouble(NT_VAL_LO,
		// RobotMap.getPreferencesDouble(PREF_VAL_LO, VAL_LO));
		// NetworkTablesJNI.putDouble(NT_VAL_HI,
		// RobotMap.getPreferencesDouble(PREF_VAL_HI, VAL_HI));
	}

	// Save vison calibration
	public static void saveCalibration(String whatpref, double x) {
		preferences.putDouble(whatpref, x);
	}

	public void init() {
		readSettingsFromPreferences();
		lightRing = new Relay(0);
		lightRing.set(Relay.Value.kForward);
		networkTable = NetworkTableInstance.getDefault().getTable("vision");
	}

	public double getAngle() {
		
		double offs = (networkTable.getEntry(NT_ANGLE).getDouble(0) + 30);
		double getting = ANGLE_MULTIPLIER * offs;
		movingAvg = (movingAvg + getting) / 2.;
		return movingAvg;
	}

	public double getRemainingDistance() {
		return networkTable.getEntry(NT_DISTANCE).getDouble(0);
	}

	public boolean isOnTarget() {
		return (Math.abs(getAngle()) < ANGLE_TOLERANCE)
				&& (Math.abs(TARGET_DISTANCE - getRemainingDistance()) < DIST_TOLERANCE);

	}

	public static class SaveToPref extends Command {

		String whatpref;

		public SaveToPref(String saveVal) {
			whatpref = saveVal;
		}

		@Override
		protected void initialize() {
			double setTo = SmartDashboard.getNumber("Vision Set", 0);

			// Smart Dashboard -> Preferences
			saveCalibration(whatpref, setTo);
			// Preferences -> Network Tables
			readSettingsFromPreferences();
			// Notify
			// SmartDashboard.putString("Vision Calib", "Set " + whatpref + " to
			// " + setTo);
			// SmartDashboard.putString("Vision Settings",
			// "Hue [ " + preferences.getDouble(PREF_HUE_LO, 0.) + "," +
			// preferences.getDouble(PREF_HUE_HI, 255.) + " ] \n" +
			// "Sat [ " + preferences.getDouble(PREF_SAT_LO, 0.) + "," +
			// preferences.getDouble(PREF_SAT_HI, 255.) + " ] \n" +
			// "Val [ " + preferences.getDouble(PREF_VAL_LO, 0.) + "," +
			// preferences.getDouble(PREF_VAL_HI, 255.) + " ] \n");
		}

		@Override
		protected void execute() {
		}

		@Override
		protected boolean isFinished() {
			return true;
		}

		@Override
		protected void end() {
		}

		@Override
		protected void interrupted() {
		}

	}

}