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

import org.firebears.commands.*;
import org.firebears.commands.defenses.DrawbridgeCommand;
import org.firebears.subsystems.*;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Command autonomousCommand;

	public static OI oi;

	// Subsystems
	public static Chassis chassis;
	public static DrawbridgeBuster drawbridgeBuster;
	public static DefenseBuster defenseBuster;
	public static BallGetter ballGetter;
	public static Shooter shooter;
	public static Lights lights;
	public static Vision vision;

	private SelectAuto selectAuto;
	private final LcdOverLay lcdol = new LcdOverLay();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();

		// Initialize Subsystems
		chassis = new Chassis();
		drawbridgeBuster = new DrawbridgeBuster();
		defenseBuster = new DefenseBuster();
		ballGetter = new BallGetter();
		shooter = new Shooter();
		lights = new Lights();
		vision = new Vision();

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// TODO: Make it so this can be switched
		autonomousCommand = new AutonomousCommand(new DrawbridgeCommand());
		selectAuto = new SelectAuto();

		Robot.ballGetter.park();
		Robot.defenseBuster.park();

		// Set Network Tables for vision
		vision.init();
	}




	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		lights.disabledMode();
		selectAuto.initialize();
		lcdol.initialize();
	}




	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		lcdol.execute();
		if (Robot.oi.But.valueChanged()) {
			selectAuto.execute();
		}
	}




	public void autonomousInit() {
		lights.autonomousMode();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
		Robot.ballGetter.park();
		Robot.defenseBuster.park();
	}




	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}




	public void teleopInit() {
		lights.teleopMode();

		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		Robot.ballGetter.park();
		Robot.defenseBuster.park();
	}




	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		if (RobotMap.DEBUG) {

			CANTalon talon3 = RobotMap.chassisBackLeft;
			SmartDashboard.putNumber("encoderLeft dist", talon3.getEncPosition());
			SmartDashboard.putNumber("encoderLeft rate", talon3.getEncVelocity());
			SmartDashboard.putNumber("encoderLeft temp", talon3.getTemperature());

			CANTalon talon5 = RobotMap.chassisBackRight;
			SmartDashboard.putNumber("encoderRight dis", talon5.getEncPosition());
			SmartDashboard.putNumber("encoderRight rate", talon5.getEncVelocity());
			SmartDashboard.putNumber("encoderRight temp", talon5.getTemperature());

//			SmartDashboard.putNumber("encoderLeft dist: ", RobotMap.encoderLeft.getDistance());
//			SmartDashboard.putNumber("encoderLeft rate: ", RobotMap.encoderLeft.getRate());
//
//			SmartDashboard.putNumber("encoderRight dist: ", RobotMap.encoderRight.getDistance());
//			SmartDashboard.putNumber("encoderRight rate: ", RobotMap.encoderRight.getRate());

			if (RobotMap.navXBoard != null) {
				SmartDashboard.putNumber("navX yaw", RobotMap.navXBoard.getAngle());
				SmartDashboard.putNumber("navX pitch", RobotMap.navXBoard.getPitch());
			}

			SmartDashboard.putNumber("accel X", RobotMap.builtInAccelerometer.getX());
			SmartDashboard.putNumber("accel Y", RobotMap.builtInAccelerometer.getY());
			SmartDashboard.putNumber("accel Z", RobotMap.builtInAccelerometer.getZ());

			SmartDashboard.putNumber("defenseBusterInput", RobotMap.defenseBusterAnalogInput.getAverageVoltage());
			SmartDashboard.putNumber("Ballgetterpot", RobotMap.ballGetterAnalogInput.getAverageVoltage());
			// SmartDashboard.putNumber("Ballcurrent",
			// RobotMap.ballGetterAngleMotor.getOutputCurrent());

			SmartDashboard.putNumber("Shooter rate", shooter.getRate());
			SmartDashboard.putNumber("Servo angle", RobotMap.shooterServo.getAngle());
			SmartDashboard.putNumber("Servo position", RobotMap.shooterServo.getPosition());
		}
	}




	public void testInit() { }




	public void testPeriodic() {
		LiveWindow.run();
	}
}
