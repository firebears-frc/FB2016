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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.firebears.commands.*;
import org.firebears.commands.defenses.ChevalDeFriseCommand;
import org.firebears.commands.defenses.LowBarCommand;
import org.firebears.commands.defenses.MoatCommand;
import org.firebears.commands.defenses.PortcullisCommand;
import org.firebears.commands.defenses.RampartsCommand;
import org.firebears.commands.defenses.RockWallCommand;
import org.firebears.commands.defenses.RoughTerrainCommand;
import org.firebears.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import static org.firebears.commands.SCurvesCommand.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick joystick1;
	public Joystick joystick2;

	public DigitalButton autoSwichButton;
	DigitalButton lazor;
//	JoystickButton ballGetterHighButton;
//	JoystickButton ballGetterLowButton;
	JoystickButton ballGetterGrabButton;
	JoystickButton ballGetterSpitButton;
//	JoystickButton ballGetterOffButton;
//	JoystickButton defenseBusterHighButton;
//	JoystickButton defenseBusterLowButton;
	JoystickButton shootButton;
	JoystickButton shooterSpinUp;
	JoystickButton shooterSpinDown;
	JoystickButton servoUP;
	JoystickButton celebrateButton;
	JoystickButton aimAndShoot;
	JoystickButton park;
	JoystickButton ballGetterChangesButton;
	JoystickButton defenseBusterChangesButton;
	JoystickButton portcullisAutoButton;
	JoystickButton chevalDeFriseAutoButton;
	JoystickButton lowBarButton;
	JoystickButton shooterReverseButton;
	JoystickButton servoButton;
	JoystickButton acquireBall;
	JoystickButton idc;

	public OI() {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);

		// Joystick Buttons
//		shootButton = new JoystickButton(joystick1, 1);
//		shootButton.whenPressed(new Fire());

		// TODO: Remove when not needed anymore.
		servoUP = new JoystickButton(joystick1, 2);
		servoUP.whenPressed(new ShooterFireCommand(ShooterFireCommand.SHOOTER_FIRE));
		
//		servoButton = new JoystickButton(joystick1, 1);
//		servoButton.whenPressed(new ShooterFireCommand(ShooterFireCommand.SHOOTER_RESET));
		
		shooterSpinDown = new JoystickButton(joystick1, 3);
		shooterSpinDown.whenPressed(new ShooterSpinCommand(0));

		shooterSpinUp = new JoystickButton(joystick1, 5);
		shooterSpinUp.whenPressed(new ShooterSpinCommand(80));

		park = new JoystickButton(joystick1, 8);
		park.whenPressed(new ParkCommand());
		
		idc = new JoystickButton(joystick1, 1);
		idc.whenPressed(new ShooterFireCommand(ShooterFireCommand.SHOOTER_RESET));
		

//		celebrateButton = new JoystickButton(joystick1, 12);
//		celebrateButton.whileHeld(new CelebrateCommand());

		//Actual Joystick Buttons
//		ballGetterHighButton = new JoystickButton(joystick2, 6);
//		ballGetterHighButton.whenPressed(new BallStoping());
//		ballGetterHighButton.whenPressed(new BallGetterSetpointCommand(2.1));
//		ballGetterHighButton.whenPressed(new BallGetterMotorsCommand(3));
//		ballGetterHighButton.whenPressed(new ShooterFireCommand(1));

//		ballGetterLowButton = new JoystickButton(joystick2, 4);
//		ballGetterLowButton.whenPressed(new BallGetting());
//		ballGetterLowButton.whenPressed(new ShooterFireCommand(0));
//		ballGetterLowButton.whenPressed(new BallGetterMotorsCommand(1));

//		defenseBusterHighButton = new JoystickButton(joystick2, 5);
//		defenseBusterHighButton.whenPressed(new DefenseBusterSetpointCommand(Robot.defenseBuster.PARK_VALUE));

//		defenseBusterLowButton = new JoystickButton(joystick2, 3);
//		defenseBusterLowButton.whenPressed(new DefenseBusterSetpointCommand(Robot.defenseBuster.MAX_VALUE));

//		ballGetterGrabButton = new JoystickButton(joystick2, 7);
//		ballGetterGrabButton.whenPressed(new BallGetterMotorsCommand(1));

//		ballGetterSpitButton = new JoystickButton(joystick2, 9);
//		ballGetterSpitButton.whenPressed(new BallGetterMotorsCommand(2));
//
//		ballGetterOffButton = new JoystickButton(joystick2, 11);
//		ballGetterOffButton.whenPressed(new BallGetterMotorsCommand(3));
		
		//Driver Station Buttons
		ballGetterChangesButton = new JoystickButton(joystick2, 8);
		ballGetterChangesButton.whenPressed(new BallGetterToggleCommand());
		
		ballGetterGrabButton = new JoystickButton(joystick2, 6);
//		ballGetterGrabButton.whenActive(new BallGetterMotorsCommand(BallGetter.GRAB));
//		ballGetterGrabButton.whenReleased(new BallGetterMotorsCommand(BallGetter.OFF));
		ballGetterGrabButton.whenPressed(new AcquireBall());
		
		ballGetterSpitButton = new JoystickButton(joystick2, 7);
		ballGetterSpitButton.whenActive(new BallGetterMotorsCommand(BallGetter.SPIT));
		ballGetterSpitButton.whenReleased(new BallGetterMotorsCommand(BallGetter.OFF));
		
		shootButton = new JoystickButton(joystick2, 5);
		shootButton.whenPressed(new Fire(120));
		
		defenseBusterChangesButton = new JoystickButton(joystick2, 3);
		defenseBusterChangesButton.whenPressed(new DefenseBusterToggleCommand());
		
		aimAndShoot = new JoystickButton(joystick2, 11);
		aimAndShoot.whenPressed(new AimAndShootCommand());
		
//		portcullisAutoButton = new JoystickButton(joystick2, 2);
//		portcullisAutoButton.whenPressed(new PortcullisCommand());
		
//		chevalDeFriseAutoButton = new JoystickButton(joystick2, 1);
		
		lowBarButton = new JoystickButton(joystick2, 1);
		lowBarButton.whenPressed(new LowBarNotAutonomousCommand());
		
		shooterReverseButton = new JoystickButton(joystick2, 2);
		shooterReverseButton.whenActive(new ShooterSpinCommand(-10));
		shooterReverseButton.whenPressed(new ShooterFireCommand(ShooterFireCommand.SHOOTER_RESET));
		shooterReverseButton.whenReleased(new ShooterSpinCommand(0));
		
		celebrateButton = new JoystickButton(joystick2, 4);
		celebrateButton.whileHeld(new CelebrateCommand());

		autoSwichButton = new DigitalButton(0);
		autoSwichButton.whenActive(new SelectAuto2());
//		lazor = new DigitalButton(6);
//		lazor.whenActive(new LazorCommand());


		// SmartDashboard Buttons
		if (RobotMap.DEBUG)  {
//			SmartDashboard.putData("Autonomous Select", new SelectAuto());
//			SmartDashboard.putData("DriveStraight", new DriveStraightCommandAndStop(180, 0.8, 45));
//			SmartDashboard.putData("Right Rotate", new RotationCommand(90));
//			SmartDashboard.putData("Left Rotate", new RotationCommand(-90));
//			SmartDashboard.putData("Moat Auto", new MoatCommand());
//			SmartDashboard.putData("Rock Wall Auto", new RockWallCommand());
//			SmartDashboard.putData("Rough Terrain Auto", new RoughTerrainCommand());
//			SmartDashboard.putData("Ramparts Auto", new RampartsCommand());
//			SmartDashboard.putData("ChevalDeFrise Auto", new ChevalDeFriseCommand());
//			SmartDashboard.putData("Low Bar", new LowBarCommand());
//			SmartDashboard.putData("TestAutoCommamnd", new TestAutoCommand());
//			SmartDashboard.putNumber("Vision Set", 0.);
//			SmartDashboard.putData("Vision Save To Hue Lo", new Vision.SaveToPref(Vision.PREF_HUE_LO));
//			SmartDashboard.putData("Vision Save To Hue Hi", new Vision.SaveToPref(Vision.PREF_HUE_HI));
//			SmartDashboard.putData("Vision Save To Sat Lo", new Vision.SaveToPref(Vision.PREF_SAT_LO));
//			SmartDashboard.putData("Vision Save To Sat Hi", new Vision.SaveToPref(Vision.PREF_SAT_HI));
//			SmartDashboard.putData("Vision Save To Val Lo", new Vision.SaveToPref(Vision.PREF_VAL_LO));
//			SmartDashboard.putData("Vision Save To Val Hi", new Vision.SaveToPref(Vision.PREF_VAL_HI));
//			SmartDashboard.putData("Location 1", new PrepareVisionCommand(1));
//			SmartDashboard.putData("Location 2", new PrepareVisionCommand(2));
//			SmartDashboard.putData("Location 3", new PrepareVisionCommand(3));
//			SmartDashboard.putData("Location 4", new PrepareVisionCommand(4));
//			SmartDashboard.putData("Location 5", new PrepareVisionCommand(5));
//			SmartDashboard.putData("Rotate30", new RotationCommand(30));
//			SmartDashboard.putData("Rotate45", new RotationCommand(45));
//			SmartDashboard.putData("Rotate90", new RotationCommand(90));
//			
//			SmartDashboard.putData("ballGetter set min", new SetPreferencesBallGetter(RobotMap.PREF_BALL_GETTER_MIN_VALUE));
//			SmartDashboard.putData("ballGetter set max", new SetPreferencesBallGetter(RobotMap.PREF_BALL_GETTER_MAX_VAUE));
//			SmartDashboard.putData("ballGetter set park", new SetPreferencesBallGetter(RobotMap.PREF_BALL_GETTER_PARK_VALUE));
//			SmartDashboard.putData("defenseBuster set min", new SetPreferencesDefenseBuster(RobotMap.PREF_DEFENSE_BUSTER_MIN_VALUE));
//			SmartDashboard.putData("defenseBuster set max", new SetPreferencesDefenseBuster(RobotMap.PREF_DEFENSE_BUSTER_MAX_VALUE));
//			SmartDashboard.putData("defenseBuster set park", new SetPreferencesDefenseBuster(RobotMap.PREF_DEFENSE_BUSTER_PARK_VALUE));
//
			SmartDashboard.putData("Defense 1", new PrepareVisionCommand(1, false));
			SmartDashboard.putData("Defense 2", new PrepareVisionCommand(2, false));
			SmartDashboard.putData("Defense 3", new PrepareVisionCommand(3, false));
			SmartDashboard.putData("Defense 4", new PrepareVisionCommand(4, false));
			SmartDashboard.putData("Defense 5", new PrepareVisionCommand(5, false));
			
			SmartDashboard.putData("GetRotation", new GetRotation());
			SmartDashboard.putData("AdjustRotation", new AdjustRotation());
			
			SmartDashboard.putData("RotateCurve " + -90, new RotateCurveCommand(-90));
			SmartDashboard.putData("RotateCurve " + 90, new RotateCurveCommand(90));
			
			SmartDashboard.putData("Bail@1", new BailSetpointCommand(.5));
	
		}
		// Create a variable to be read for the Network Tables Variables.
		SmartDashboard.putNumber(SetPreferences.SET_VAR, 0.0);
		// Create buttons for each preference value to set the preferences from previous variable.
		pref_btn("Shooter.goal_speed");
//		pref_btn(RobotMap.PREF_DEFENSE_BUSTER_MAX_SPEED);
//		pref_btn(RobotMap.PREF_DEFENSE_BUSTER_MIN_VALUE);
//		pref_btn(RobotMap.PREF_DEFENSE_BUSTER_MAX_VALUE);
//		pref_btn(RobotMap.PREF_DEFENSE_BUSTER_PARK_VALUE);
//		pref_btn(RobotMap.PREF_BALL_GETTER_MAX_SPEED);
//		pref_btn(RobotMap.PREF_BALL_GETTER_MIN_VALUE);
//		pref_btn(RobotMap.PREF_BALL_GETTER_MAX_VAUE);
//		pref_btn(RobotMap.PREF_BALL_GETTER_MAXGET_SPEED);
//		pref_btn(RobotMap.PREF_BALL_GETTER_PARK_VALUE);

	}
	
	public void pref_btn(String pref_var_name) {
		SmartDashboard.putData("Set Preference \"" + pref_var_name + "\"", new SetPreferences(pref_var_name));
	}

	public Joystick getJoystick1() {
		return joystick1;
	}
}