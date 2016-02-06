package org.firebears.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Lights extends Subsystem {

	NetworkTable table;

	public Lights() {
		table = NetworkTable.getTable("lights");
	}

	public void initDefaultCommand() {
	}

	public void setStrip(String stripName, String animationName) {
		table.putString(stripName, animationName);
	}

	public void setValue(String stripName, double value) {
		table.putNumber(stripName + ".value", value);
	}





	// Constants for pixel strips
	public static final String STRIP_LIFTU = "lift_up";
	public static final String STRIP_LIFTD = "lift_down";
	public static final String STRIP_SUPPU = "support_up";
	public static final String STRIP_SUPPD = "support_down";
	public static final String STRIP_TROPH = "trophy";
	public static final String STRIP_INRBT = "inside";

	// Constants for  animations
	public static final String ANIM_PULSE = "PULSING_GREEN_ANIM";
	public static final String ANIM_MOVE = "MOVING_BLUE_ANIM";
	public static final String ANIM_FIRE = "FIRE_ANIM";
	public static final String ANIM_LIFT = "LIFT";
	public static final String ANIM_CRAZY = "CRAZY";
	public static final String ANIM_BINARY = "BIN_ANIM";
	public static final String ANIM_BULB = "BULB";
	public static final String ANIM_CATERPILLAR = "ANIM_CATERPILLAR";
	public static final String ANIM_SPARK = "SPARK";
	public static final String ANIM_THEATER = "THEATER";
	public static final String ANIM_EXPLODE = "ANIM_EXPLODE";

}
