package org.firebears.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *  Subsystem interface to the lights running on the Raspberry Pi.
 *  Communicates to the pi through the Network Tables.
 */
public class Lights extends Subsystem {

	NetworkTable table;

	public Lights() {
		table = NetworkTable.getTable("lights");
		setStrip(STRIP_CHASSIS_LEFT, ANIM_FIRE);
		setStrip(STRIP_CHASSIS_RIGHT, ANIM_FIRE);
		setStrip(STRIP_CELEBRATE, ANIM_FIRE);
	}

	public void initDefaultCommand() {
	}

	public void setStrip(String stripName, String animationName) {
		table.putString(stripName, animationName);
	}

	public void setValue(String stripName, double value) {
		table.putNumber(stripName + ".value", value);
	}
		public void teleopMode(){
			if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
				setStrip(Lights.STRIP_CHASSIS_LEFT, Lights.ANIM_MOVING_BLUE);
				setStrip(Lights.STRIP_CHASSIS_RIGHT, Lights.ANIM_MOVING_BLUE);
				setStrip(Lights.STRIP_CELEBRATE, Lights.ANIM_MOVING_BLUE);
			} else {
				setStrip(Lights.STRIP_CHASSIS_LEFT, Lights.ANIM_FIRE);
				setStrip(Lights.STRIP_CHASSIS_RIGHT, Lights.ANIM_FIRE);
				setStrip(Lights.STRIP_CELEBRATE, Lights.ANIM_FIRE);
			}
		}
		public void autonomousMode(){
			// To do
		}
		public void disabledMode(){
			setStrip(Lights.STRIP_CELEBRATE, Lights.ANIM_FIRE);
			setStrip(Lights.STRIP_CHASSIS_LEFT, Lights.ANIM_FIRE);
			setStrip(Lights.STRIP_CHASSIS_RIGHT, Lights.ANIM_FIRE);
		}





	// Constants for pixel strips
	public static final String STRIP_CHASSIS_LEFT = "strip_chassis_left";
	public static final String STRIP_CHASSIS_RIGHT = "strip_chassis_right";
	public static final String STRIP_CELEBRATE = "strip_celebrate";

	// Constants for  animations
	public static final String ANIM_PULSING_GREEN = "ANIM_PULSING_GREEN";
	public static final String ANIM_MOVING_BLUE = "ANIM_MOVING_BLUE";
	public static final String ANIM_FIRE = "ANIM_FIRE";
	public static final String ANIM_CRAZY = "ANIM_CRAZY";
	public static final String ANIM_BINARY = "ANIM_BINARY";
	public static final String ANIM_BULB = "ANIM_BULB";
	public static final String ANIM_CATERPILLAR = "ANIM_CATERPILLAR";
	public static final String ANIM_SPARK = "ANIM_SPARK";
	public static final String ANIM_THEATER = "ANIM_THEATER";
	public static final String ANIM_EXPLODE = "ANIM_EXPLODE";

}
