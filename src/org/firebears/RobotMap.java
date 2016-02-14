// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.firebears;

import org.firebears.util.LiquidCrystal;
import org.firebears.util.LiquidCrystal_roboRio;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static boolean DEBUG = true;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static CANTalon chassisFrontLeft;
	public static CANTalon chassisFrontRight;
	public static CANTalon chassisBackLeft;
	public static CANTalon chassisBackRight;
	public static RobotDrive chassisRobotDrive;
	public static CANTalon drawbridgeBusterAngleMotor;
	public static CANTalon defenseBusterAngleMotor;
	public static CANTalon ballGetterSideMotor;
	public static CANTalon ballGetterFrontMotor;
	public static CANTalon ballGetterAngleMotor;
	public static CANTalon shooterShootingMotor;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static LiquidCrystal lcd;

	public static AnalogInput defenseBusterAnalogInput;
	public static AnalogPotentiometer defenseBusterAnglePotentiometer;

	public static AnalogInput ballGetterAnalogInput;
	public static AnalogPotentiometer ballGetterAnglePotentiometer;

	public static Encoder encoderLeft;
	public static Encoder encoderRight;

	public static AHRS navXBoard;

	public static BuiltInAccelerometer builtInAccelerometer;

	public static CameraServer usbCamera;

	public static double rotation = 0;


	public static void init() {


		chassisFrontLeft = new CANTalon(2);
		chassisFrontLeft.enableBrakeMode(false);
		LiveWindow.addActuator("Chassis", "FrontLeft", chassisFrontLeft);

		chassisFrontRight = new CANTalon(4);
		chassisFrontRight.enableBrakeMode(false);
		LiveWindow.addActuator("Chassis", "FrontRight", chassisFrontRight);

		chassisBackLeft = new CANTalon(3);
		chassisBackLeft.enableBrakeMode(false);

		LiveWindow.addActuator("Chassis", "BackLeft", chassisBackLeft);

		chassisBackRight = new CANTalon(5);
		chassisBackRight.enableBrakeMode(false);
		LiveWindow.addActuator("Chassis", "BackRight", chassisBackRight);

		defenseBusterAngleMotor = new CANTalon(11);
		defenseBusterAngleMotor.enableBrakeMode(true);
		LiveWindow.addActuator("DefenseBuster", "Motor", defenseBusterAngleMotor);


		chassisRobotDrive = new RobotDrive(chassisBackRight, chassisFrontRight, chassisBackLeft, chassisFrontLeft);

		lcd = new LiquidCrystal_roboRio(0x27);
		lcd.begin(20, 4);
		lcd.clear();

		try {
			navXBoard = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}

		builtInAccelerometer = new BuiltInAccelerometer();

		defenseBusterAnalogInput = new AnalogInput(0);
		defenseBusterAnglePotentiometer = new AnalogPotentiometer(defenseBusterAnalogInput);
		LiveWindow.addActuator("DefenseBuster", "Pot", defenseBusterAnalogInput);

		ballGetterAnalogInput = new AnalogInput(1);
		ballGetterAnglePotentiometer = new AnalogPotentiometer(ballGetterAnalogInput);
		LiveWindow.addActuator("BallGetter", "Pot", ballGetterAnglePotentiometer);

		// button
		// internalDigitalInput1 = new DigitalInput(0);
		// LiveWindow.addSensor("Subsystem 1", "Digital Input 1",
		// internalDigitalInput1);

		chassisRobotDrive.setSafetyEnabled(true);
		chassisRobotDrive.setExpiration(0.1);
		chassisRobotDrive.setSensitivity(0.5);
		chassisRobotDrive.setMaxOutput(1.0);

		/*
		 * drawbridgeBusterAngleMotor = new CANTalon(10);
		 * LiveWindow.addActuator("DrawbridgeBuster", "AngleMotor",
		 * drawbridgeBusterAngleMotor);
		 *
		 * defenseBusterAngleMotor = new CANTalon(11);
		 * LiveWindow.addActuator("DefenseBuster", "AngleMotor",
		 * defenseBusterAngleMotor);
		 *
		 * ballGetterSideMotor = new CANTalon(12);
		 * LiveWindow.addActuator("BallGetter", "SideMotor",
		 * ballGetterSideMotor);
		 *
		 * ballGetterFrontMotor = new CANTalon(13);
		 * LiveWindow.addActuator("BallGetter", "FrontMotor",
		 * ballGetterFrontMotor);
		 *
		 * ballGetterAngleMotor = new CANTalon(14);
		 * LiveWindow.addActuator("BallGetter", "AngleMotor",
		 * ballGetterAngleMotor);
		 *
		 * shooterShootingMotor = new CANTalon(15);
		 * LiveWindow.addActuator("Shooter", "ShootingMotor",
		 * shooterShootingMotor);
		 */
		
		ballGetterAngleMotor = new CANTalon(12);
		LiveWindow.addActuator("BallGetter", "AngleMotor",
		ballGetterAngleMotor);

		// Quadrature encoders read 0.05639 inches per pulse
		// Talon encoder distance is 0.0245 inches per pulse
		encoderLeft = new Encoder(2, 3, false, EncodingType.k4X);
		LiveWindow.addSensor("chassis", "encoder", encoderLeft);
		encoderLeft.setDistancePerPulse(0.05639);
		encoderLeft.setPIDSourceType(PIDSourceType.kRate);

		encoderRight = new Encoder(4, 5, true, EncodingType.k4X);
		LiveWindow.addSensor("chassis", "encoder", encoderRight);
		encoderRight.setDistancePerPulse(0.05639);
		encoderRight.setPIDSourceType(PIDSourceType.kRate);

		usbCamera = CameraServer.getInstance();
		usbCamera.setQuality(50);
		usbCamera.startAutomaticCapture("cam0");
	}
}
