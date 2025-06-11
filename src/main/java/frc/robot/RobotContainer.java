// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.DriveIO;
import frc.robot.subsystems.drive.DriveIOSim;
import frc.robot.subsystems.drive.DriveIOTalonSRXNavX;
import org.littletonrobotics.junction.networktables.LoggedDashboardNumber;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final Drive drive;

  // Controller
  private final CommandXboxController controller = new CommandXboxController(0);

  // Power distribution
  private final PowerDistribution powerDistribution = new PowerDistribution();

  // Dashboard inputs
  private final LoggedDashboardNumber rioThreshold =
      new LoggedDashboardNumber("RIO Warning Voltage");
  private final LoggedDashboardNumber pdpThreshold =
      new LoggedDashboardNumber("PDP Warning Voltage");

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    switch (Constants.currentMode) {
      case REAL:
        // Real robot, instantiate hardware IO implementations
        drive = new Drive(new DriveIOTalonSRXNavX());
        break;

      case SIM:
        // Sim robot, instantiate physics sim IO implementations
        drive = new Drive(new DriveIOSim());
        break;

      default:
        // Replayed robot, disable IO implementations
        drive = new Drive(new DriveIO() {});
        break;
    }

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Only drive while B button is pressed
    controller
        .b()
        .whileTrue(drive.arcade(() -> -controller.getLeftY(), () -> -controller.getLeftX()))
        .onFalse(drive.stop());

    // Longer rumble for low RIO voltage
    new Trigger(() -> RobotController.getBatteryVoltage() < rioThreshold.get())
        .whileTrue(
            Commands.repeatingSequence(
                Commands.runOnce(
                    () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 1.0)),
                Commands.waitSeconds(0.5),
                Commands.runOnce(
                    () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0)),
                Commands.waitSeconds(0.5)))
        .onFalse(
            Commands.runOnce(
                () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0)));

    // Double rumble for low PDP voltage
    new Trigger(() -> powerDistribution.getVoltage() < pdpThreshold.get())
        .whileTrue(
            Commands.repeatingSequence(
                Commands.runOnce(
                    () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 1.0)),
                Commands.waitSeconds(0.125),
                Commands.runOnce(
                    () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0)),
                Commands.waitSeconds(0.25),
                Commands.runOnce(
                    () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 1.0)),
                Commands.waitSeconds(0.125),
                Commands.runOnce(
                    () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0)),
                Commands.waitSeconds(0.5)))
        .onFalse(
            Commands.runOnce(
                () -> controller.getHID().setRumble(GenericHID.RumbleType.kBothRumble, 0.0)));
  }
}
