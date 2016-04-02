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

import org.firebears.commands.AutonomousCommand;
import org.firebears.commands.LcdOverLay;
import org.firebears.commands.SelectAuto;
import org.firebears.commands.defenses.MoatCommand;
import org.firebears.subsystems.BallGetter;
import org.firebears.subsystems.Chassis;
import org.firebears.subsystems.DefenseBuster;
import org.firebears.subsystems.DrawbridgeBuster;
import org.firebears.subsystems.Lights;
import org.firebears.subsystems.Shooter;
import org.firebears.subsystems.Vision;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	private long count = 0;
//	private boolean lazorDown = false;
	public boolean ballAcquired = false;

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
		autonomousCommand = new AutonomousCommand(new MoatCommand());
		selectAuto = new SelectAuto();

		Robot.ballGetter.park();
		Robot.defenseBuster.park();
		Robot.shooter.servoFire();

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
		if ((count++) % 15 == 0) {
			lights.autonomousMode();
		}
	}




	public void teleopInit() {
		lights.teleopMode();

		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		Robot.ballGetter.park();
		Robot.defenseBuster.park();

		count = 0;
	}




	public void teleopPeriodic() {
		Scheduler.getInstance().run();
//		double voltage = Robot.lazor.getAverageVoltage();
		
		ballAcquired = Robot.shooter.hasBall();
		
		// Not broken
//		if(ballAcquired) {
//			lazorDown = true;
//		// Broken
//		}else{
//			if(lazorDown) {
//		    	if(Robot.ballGetter.mode3 == 1) {
//		    		Robot.shooter.servoReset();
//		    	}else{
//		    		Robot.shooter.servoFire();
//		    	}
//			}
//	    	lazorDown = false;
//		}

		if ((count++) % 15 == 0) {
			
			lights.teleopMode();

			if (RobotMap.DEBUG) {

				CANTalon talon2 = RobotMap.chassisFrontLeft;
				SmartDashboard.putNumber("encoderLeft dist", talon2.getEncPosition());
				SmartDashboard.putNumber("encoderLeft rate", talon2.getEncVelocity());

				CANTalon talon4 = RobotMap.chassisFrontRight;
				SmartDashboard.putNumber("encoderRight dis", talon4.getEncPosition());
				SmartDashboard.putNumber("encoderRight rate", talon4.getEncVelocity());
				
				SmartDashboard.putBoolean("Ball Acquired", Robot.shooter.hasBall());
//				SmartDashboard.putBoolean("Ball Acquired", lazorDown);

//				SmartDashboard.putNumber("encoderLeft dist: ", RobotMap.encoderLeft.getDistance());
//				SmartDashboard.putNumber("encoderLeft rate: ", RobotMap.encoderLeft.getRate());
//
//				SmartDashboard.putNumber("encoderRight dist: ", RobotMap.encoderRight.getDistance());
//				SmartDashboard.putNumber("encoderRight rate: ", RobotMap.encoderRight.getRate());

				if (RobotMap.navXBoard != null) {
					SmartDashboard.putNumber("navX yaw", RobotMap.navXBoard.getAngle());
					SmartDashboard.putNumber("navX pitch", RobotMap.navXBoard.getPitch());
				}

				SmartDashboard.putNumber("accel X", RobotMap.builtInAccelerometer.getX());
				SmartDashboard.putNumber("accel Y", RobotMap.builtInAccelerometer.getY());
				SmartDashboard.putNumber("accel Z", RobotMap.builtInAccelerometer.getZ());

				SmartDashboard.putNumber("Shooter rate RPS", shooter.getRate());
				SmartDashboard.putNumber("Servo angle", RobotMap.shooterServo.getAngle());
				SmartDashboard.putNumber("Servo position", RobotMap.shooterServo.getPosition());

				SmartDashboard.putNumber("Rangefinder Inches:", shooter.getRangeFinderDistance());
			}

			SmartDashboard.putNumber("DefenseBuster pot", RobotMap.defenseBusterAnalogInput.getAverageVoltage());
			SmartDashboard.putNumber("Ballgetter pot", RobotMap.ballGetterAnalogInput.getAverageVoltage());

		}
	}




	public void testInit() { }




	public void testPeriodic() {
		LiveWindow.run();
	}
}
