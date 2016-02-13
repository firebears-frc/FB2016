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
import org.firebears.commands.defenses.LowBarCommand;
import org.firebears.commands.defenses.RampartsCommand;
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
    // One type of button is a joystick button which is any button on a joystick.
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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
DigitalButton But;
JoystickButton joy;
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick1 = new Joystick(0);

        joy = new JoystickButton(joystick1,4);
        joy.whenPressed(new PrintCommand("Joystick"));

        But = new DigitalButton(0);
        But.whenActive(new SelectAuto());


        // SmartDashboard Buttons
        SmartDashboard.putData("DriveStraight", new DriveStraightCommand(60, .6));
		SmartDashboard.putData("Right Rotate", new RotationCommand(90));
		SmartDashboard.putData("Left Rotate", new RotationCommand(-90));
		SmartDashboard.putData("LowBar", new LowBarCommand());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		SmartDashboard.putData("Move .7", new DriveStraightCommand(120, .7));
		SmartDashboard.putData("Move .75", new DriveStraightCommand(120, .75));
		SmartDashboard.putData("Move .8", new DriveStraightCommand(120, .8));
		SmartDashboard.putData("Move .9", new DriveStraightCommand(120, .9));
		SmartDashboard.putData("Move 1.", new DriveStraightCommand(120, 1.));
		SmartDashboard.putData("Do the Ramparts Command", new RampartsCommand());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

