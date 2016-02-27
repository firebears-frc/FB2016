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
import org.firebears.commands.defenses.MoatCommand;
import org.firebears.commands.defenses.RampartsCommand;
import org.firebears.commands.defenses.RockWallCommand;
import org.firebears.commands.defenses.RoughTerrainCommand;
import org.firebears.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

	DigitalButton But;
	DigitalButton lazor;
	JoystickButton ballGetterHighButton;
	JoystickButton ballGetterLowButton;
	JoystickButton ballGetterGrabButton;
	JoystickButton ballGetterSpitButton;
	JoystickButton ballGetterOffButton;
	JoystickButton defenseBusterHighButton;
	JoystickButton defenseBusterLowButton;
	JoystickButton shootButton;
	JoystickButton shooterSpinUp;
	JoystickButton shooterSpinDown;
	JoystickButton servoUP;
	JoystickButton celebrateButton;
	JoystickButton aimAndShoot;
	JoystickButton park;

	public OI() {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);

		// Joystick Buttons
		shootButton = new JoystickButton(joystick1, 1);
		shootButton.whenPressed(new Fire());

		servoUP = new JoystickButton(joystick1, 2);
		servoUP.whenPressed(new ShooterFireCommand(ShooterFireCommand.SHOOTER_TOGGLE));
		
		shooterSpinDown = new JoystickButton(joystick1, 3);
		shooterSpinDown.whenPressed(new ShooterSpinCommand(0));
		
		shooterSpinUp = new JoystickButton(joystick1, 5);
		shooterSpinUp.whenPressed(new ShooterSpinCommand(80));
		
		aimAndShoot = new JoystickButton(joystick1, 7);
		aimAndShoot.whileHeld(new AimAndShootCommand());
		
		park = new JoystickButton(joystick1, 8);
		park.whenPressed(new ParkCommand());
		
		celebrateButton = new JoystickButton(joystick1, 12);
		celebrateButton.whileHeld(new CelebrateCommand());

		ballGetterHighButton = new JoystickButton(joystick2, 6);
		ballGetterHighButton.whenPressed(new BallStoping());
//		ballGetterHighButton.whenPressed(new BallGetterSetpointCommand(2.1));
//		ballGetterHighButton.whenPressed(new BallGetterMotorsCommand(3));
//		ballGetterHighButton.whenPressed(new ShooterFireCommand(1));

		ballGetterLowButton = new JoystickButton(joystick2, 4);
		ballGetterLowButton.whenPressed(new BallGetting());
//		ballGetterLowButton.whenPressed(new ShooterFireCommand(0));
//		ballGetterLowButton.whenPressed(new BallGetterMotorsCommand(1));

		defenseBusterHighButton = new JoystickButton(joystick2, 5);
		defenseBusterHighButton.whenPressed(new DefenseBusterSetpointCommand(Robot.defenseBuster.PARK_VALUE));

		defenseBusterLowButton = new JoystickButton(joystick2, 3);
		defenseBusterLowButton.whenPressed(new DefenseBusterSetpointCommand(Robot.defenseBuster.MAX_VALUE));

//		ballGetterGrabButton = new JoystickButton(joystick2, 7);
//		ballGetterGrabButton.whenPressed(new BallGetterMotorsCommand(1));

		ballGetterSpitButton = new JoystickButton(joystick2, 9);
		ballGetterSpitButton.whenPressed(new BallGetterMotorsCommand(2));

		ballGetterOffButton = new JoystickButton(joystick2, 11);
		ballGetterOffButton.whenPressed(new BallGetterMotorsCommand(3));

		But = new DigitalButton(0);
		But.whenActive(new SelectAuto());
		lazor = new DigitalButton(9);
		lazor.whenActive(new ShooterFireCommand(1));

		// SmartDashboard Buttons
		if (RobotMap.DEBUG)  {
			SmartDashboard.putData("DriveStraight", new DriveStraightCommand(60));
			SmartDashboard.putData("Right Rotate", new RotationCommand(90));
			SmartDashboard.putData("Left Rotate", new RotationCommand(-90));
			SmartDashboard.putData("Moat Auto", new MoatCommand());
			SmartDashboard.putData("Rock Wall Auto", new RockWallCommand());
			SmartDashboard.putData("Rough Terrain Auto", new RoughTerrainCommand());
			SmartDashboard.putData("Ramparts Auto", new RampartsCommand());
			SmartDashboard.putNumber("Vision Set", 0.);
			SmartDashboard.putData("Vision Save To Hue Lo", new Vision.SaveToPref(Vision.PREF_HUE_LO));
			SmartDashboard.putData("Vision Save To Hue Hi", new Vision.SaveToPref(Vision.PREF_HUE_HI));
			SmartDashboard.putData("Vision Save To Sat Lo", new Vision.SaveToPref(Vision.PREF_SAT_LO));
			SmartDashboard.putData("Vision Save To Sat Hi", new Vision.SaveToPref(Vision.PREF_SAT_HI));
			SmartDashboard.putData("Vision Save To Val Lo", new Vision.SaveToPref(Vision.PREF_VAL_LO));
			SmartDashboard.putData("Vision Save To Val Hi", new Vision.SaveToPref(Vision.PREF_VAL_HI));
		}

	}

	public Joystick getJoystick1() {
		return joystick1;
	}
}