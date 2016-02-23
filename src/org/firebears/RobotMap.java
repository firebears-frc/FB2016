// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
// /*/*/*Original open loop version with "comment out" SRX locations

package org.firebears;

import org.firebears.util.LiquidCrystal;
import org.firebears.util.LiquidCrystal_roboRio;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
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
    public static AnalogInput shooterrangeFinder;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static LiquidCrystal lcd;

	public static Servo shooterServo;
	public static DigitalInput shouterCounterDigitalInput;
	public static Counter shooterCounter;

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


	static double m_P = .1;
	static double m_I = 0;
	static double m_D = 0;
	static double m_ff = 0;
	static int m_izone = 256;
	static double m_rampRate = 10;
	static int m_profile = 0;
	static int m_CountPerRev = 255;//****Magnetic
	public static boolean servoOn = false;
//	public static boolean defenseBuster = false;
//	public static boolean ballGetter = false;

	public static void init() {

		//*/*/*/*/*/Begin Open Loop /*/*/*/*/*/
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
		//*/*/*/*/*/END Open Loop /*/*/*/*/*/




		//*/*/*/*/*/Begin SRX PID Loop /*/*/*/*/*/
//		chassisFrontRight = new CANTalon(4);
//		chassisFrontRight.changeControlMode(CANTalon.TalonControlMode.Speed);
//		chassisFrontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);//is this covered above with the sRX_PIDQuadratureEncoder1   ?????
//		chassisFrontRight.reverseSensor(false);//is this covered above with the sRX_PIDQuadratureEncoder1   ?????
//		chassisFrontRight.configNominalOutputVoltage(+0.0d, -0.0d);//Forward/reverse threshold
//		chassisFrontRight.configPeakOutputVoltage(+12.0d, -12.0d);
//		chassisFrontRight.setPID(m_P, m_I, m_D, m_ff, m_izone, m_rampRate, m_profile );
//		chassisFrontRight.configEncoderCodesPerRev(m_CountPerRev);//
//		chassisFrontRight.enableBrakeMode(false);
//		chassisFrontRight.enable();
//		LiveWindow.addActuator("Chassis", "FrontRight", chassisFrontRight);
//
//		chassisBackLeft = new CANTalon(3);
//		chassisBackLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
//		chassisBackLeft.set(chassisFrontLeft.getDeviceID());
//		chassisBackLeft.enableBrakeMode(false);
//		LiveWindow.addActuator("Chassis", "BackLeft", chassisBackLeft);
//
//		chassisBackRight = new CANTalon(5);
//		chassisBackRight.changeControlMode(CANTalon.TalonControlMode.Follower);
//		chassisBackRight.set(chassisFrontRight.getDeviceID());
//		chassisBackRight.enableBrakeMode(false);
//		LiveWindow.addActuator("Chassis", "BackRight", chassisBackRight);
//
//		defenseBusterAngleMotor = new CANTalon(11);
//		defenseBusterAngleMotor.enableBrakeMode(true);
//		LiveWindow.addActuator("DefenseBuster", "Motor", defenseBusterAngleMotor);
		//*/*/*/*/*/END SRX PID Loop /*/*/*/*/*/

		chassisRobotDrive = new RobotDrive(chassisBackRight, chassisFrontRight, chassisBackLeft, chassisFrontLeft);

		//*/*/*/*/*/Begin SRX PID Loop /*/*/*/*/*/

		//chassisRobotDrive.setMaxOutput(2500);

		//*/*/*/*/*/END SRX PID Loop /*/*/*/*/*/

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
		LiveWindow.addActuator("BallGetter", "Pot", ballGetterAnalogInput);

		shooterServo = new Servo(1);
		LiveWindow.addActuator("Shooter", "ShootingServo", shooterServo);

		shouterCounterDigitalInput = new DigitalInput(1);
		shooterCounter = new Counter(shouterCounterDigitalInput);
		shooterCounter.setUpDownCounterMode();
		shooterCounter.setPIDSourceType(PIDSourceType.kRate);
		shooterCounter.reset();
		LiveWindow.addActuator("Shooter", "ShootingCounter", shooterCounter);

		// button
		// internalDigitalInput1 = new DigitalInput(0);
		// LiveWindow.addSensor("Subsystem 1", "Digital Input 1",
		// internalDigitalInput1);

		chassisRobotDrive.setSafetyEnabled(true);
		chassisRobotDrive.setExpiration(0.1);
		chassisRobotDrive.setSensitivity(0.5);
		chassisRobotDrive.setMaxOutput(1.0);

		ballGetterAngleMotor = new CANTalon(12);
		LiveWindow.addActuator("BallGetter", "AngleMotor", ballGetterAngleMotor);

		ballGetterSideMotor = new CANTalon(14);
		LiveWindow.addActuator("BallGetter", "SideMotor", ballGetterSideMotor);

		ballGetterFrontMotor = new CANTalon(13);
		LiveWindow.addActuator("BallGetter", "FrontMotor", ballGetterFrontMotor);

		shooterShootingMotor = new CANTalon(16);
		shooterShootingMotor.enableBrakeMode(false);
		LiveWindow.addActuator("Shooter", "ShootingMotor", shooterShootingMotor);

		/*
		 * Quadrature encoders read 0.05639 inches per pulse Talon encoder
		 * distance is 0.0245 inches per pulse
		 */
		DigitalInput encoderLeftInputA = new DigitalInput(2);
		DigitalInput encoderLeftInputB = new DigitalInput(3);
		encoderLeft = new Encoder(encoderLeftInputA, encoderLeftInputB, false, EncodingType.k4X);
		LiveWindow.addSensor("chassis", "encoder", encoderLeft);
		encoderLeft.setDistancePerPulse(0.05639);
		encoderLeft.setPIDSourceType(PIDSourceType.kRate);

		DigitalInput encoderRightInputA = new DigitalInput(4);
		DigitalInput encoderRightInputB = new DigitalInput(5);
		encoderRight = new Encoder(encoderRightInputA, encoderRightInputB, true, EncodingType.k4X);
		LiveWindow.addSensor("chassis", "encoder", encoderRight);
		encoderRight.setDistancePerPulse(0.05639);
		encoderRight.setPIDSourceType(PIDSourceType.kRate);

		usbCamera = CameraServer.getInstance();
		usbCamera.setQuality(50);
		usbCamera.startAutomaticCapture("cam0");

		shooterrangeFinder = new AnalogInput(2);
        LiveWindow.addSensor("Shooter", "rangeFinder", shooterrangeFinder);

	}

	/**
	 * Retrieve numbers from the preferences table. If the specified key is in
	 * the preferences table, then the preference value is returned. Otherwise,
	 * return the backup value, and also start a new entry in the preferences
	 * table.
	 */
	public static double getPreferencesDouble(String key, double backup) {
		Preferences preferences = Preferences.getInstance();
		if (!preferences.containsKey(key)) {
			preferences.putDouble(key, backup);
		}
		return preferences.getDouble(key, backup);
	}
}
