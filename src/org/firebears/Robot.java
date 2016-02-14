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
import edu.wpi.first.wpilibj.CANTalon;
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
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Chassis chassis;
	public static DrawbridgeBuster drawbridgeBuster;
	public static DefenseBuster defenseBuster;
	public static BallGetter ballGetter;
	public static Shooter shooter;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static Lights lights;

	private final SelectAuto selectAuto = new SelectAuto();
	private final LcdOverLay lcdol = new LcdOverLay();

	private PIDCommand rotateCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		chassis = new Chassis();
		drawbridgeBuster = new DrawbridgeBuster();
		defenseBuster = new DefenseBuster();
		ballGetter = new BallGetter();
		shooter = new Shooter();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		lights = new Lights();

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// TODO: Make it so this can be switched
		autonomousCommand = new AutonomousCommand(new DrawbridgeCommand());

		// Smart Dashboard
		rotateCommand = new RotationCommand(90);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		lcdol.execute();
		if (Robot.oi.But.valueChanged()) {
			selectAuto.execute();
		}
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)  {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)  {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		if (RobotMap.DEBUG) {
//			CANTalon talon3 = RobotMap.chassisBackLeft;
//			SmartDashboard.putNumber("EncPosition 3", talon3.getEncPosition());
//			SmartDashboard.putNumber("EncVelocity 3", talon3.getEncVelocity());
//			SmartDashboard.putNumber("Temperature 3", talon3.getTemperature());
//
//			CANTalon talon5 = RobotMap.chassisBackRight;
//			SmartDashboard.putNumber("EncPosition 5", talon5.getEncPosition());
//			SmartDashboard.putNumber("EncVelocity 5", talon5.getEncVelocity());
//			SmartDashboard.putNumber("Temperature 5", talon5.getTemperature());

			SmartDashboard.putNumber("encoderLeft dist: ", RobotMap.encoderLeft.getDistance());
			SmartDashboard.putNumber("encoderLeft rate: ", RobotMap.encoderLeft.getRate());

			SmartDashboard.putNumber("encoderRight dist: ", RobotMap.encoderRight.getDistance());
			SmartDashboard.putNumber("encoderRight rate: ", RobotMap.encoderRight.getRate());

			if (RobotMap.navXBoard != null) {
				SmartDashboard.putNumber("navX yaw", RobotMap.navXBoard.getAngle());
				SmartDashboard.putNumber("navX pitch", RobotMap.navXBoard.getPitch());
			}

			SmartDashboard.putNumber("accel X", RobotMap.builtInAccelerometer.getX());
			SmartDashboard.putNumber("accel Y", RobotMap.builtInAccelerometer.getY());
			SmartDashboard.putNumber("accel Z", RobotMap.builtInAccelerometer.getZ());

			SmartDashboard.putData("Rotate", rotateCommand);

			SmartDashboard.putNumber("defenseBusterInput", RobotMap.defenseBusterAnalogInput.getAverageVoltage());
			SmartDashboard.putNumber("Ballgetterpot", RobotMap.ballGetterAnalogInput.getAverageVoltage());
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
