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
import edu.wpi.first.wpilibj.command.PrintCommand;

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

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Joystick joystick1;
	public Joystick joystick2;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	DigitalButton But;
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

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);

		// Joystick Buttons
		shooterSpinUp = new JoystickButton(joystick1, 5);
		shooterSpinUp.whenPressed(new ShooterSpinCommand(90));
		shooterSpinDown = new JoystickButton(joystick1, 3);
		shooterSpinDown.whenPressed(new ShooterSpinCommand(0));
		shootButton = new JoystickButton(joystick1, 1);
		shootButton.whenPressed(new ShooterFireCommand());

		ballGetterHighButton = new JoystickButton(joystick2, 6);
		ballGetterHighButton.whenPressed(new BallGetterSetpointCommand(2.1));
		ballGetterLowButton = new JoystickButton(joystick2, 4);
		ballGetterLowButton.whenPressed(new BallGetterSetpointCommand(3.33));
		defenseBusterHighButton = new JoystickButton(joystick2, 5);
		defenseBusterHighButton.whenPressed(new DefenseBusterSetpointCommand(2.726));
		defenseBusterLowButton = new JoystickButton(joystick2, 3);
		defenseBusterLowButton.whenPressed(new DefenseBusterSetpointCommand(3.911));
		ballGetterGrabButton = new JoystickButton(joystick2, 7);
		ballGetterGrabButton.whenPressed(new BallGetterMotorsCommand(1));
		ballGetterSpitButton = new JoystickButton(joystick2, 9);
		ballGetterSpitButton.whenPressed(new BallGetterMotorsCommand(2));
		ballGetterOffButton = new JoystickButton(joystick2, 11);
		ballGetterOffButton.whenPressed(new BallGetterMotorsCommand(3));

		But = new DigitalButton(0);
		But.whenActive(new SelectAuto());

		// SmartDashboard Buttons
		SmartDashboard.putData("DriveStraight", new DriveStraightCommand(60));
		SmartDashboard.putData("Right Rotate", new RotationCommand(90));
		SmartDashboard.putData("Left Rotate", new RotationCommand(-90));
		SmartDashboard.putData("Moat Auto", new MoatCommand());
		SmartDashboard.putData("Rock Wall Auto", new RockWallCommand());
		SmartDashboard.putData("Rough Terrain Auto", new RoughTerrainCommand());
		SmartDashboard.putData("Ramparts Auto", new RampartsCommand());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getJoystick1() {
		return joystick1;
	}
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}