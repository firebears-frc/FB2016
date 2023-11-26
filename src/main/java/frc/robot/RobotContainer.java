package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.drive.Drive;
import frc.robot.drive.DriveIOTalonSRX;

public class RobotContainer {
    private static final class Constants {
        private static final int CONTROLLER_PORT = 0;

        public static final double JOYSTICK_DEADBAND = 0.05;

        private static final int PDP_CAN_ID = 1;
    }

    private final PowerDistribution pdp;

    private final Drive drive;

    private final CommandXboxController controller;

    public RobotContainer() {
        pdp = new PowerDistribution(Constants.PDP_CAN_ID, PowerDistribution.ModuleType.kCTRE);

        drive = new Drive(new DriveIOTalonSRX());

        controller = new CommandXboxController(Constants.CONTROLLER_PORT);

        configureBindings();
    }

    private void configureBindings() {
        drive.setDefaultCommand(drive.arcadeDrive(
                () -> -MathUtil.applyDeadband(controller.getLeftY(), Constants.JOYSTICK_DEADBAND),
                () -> -MathUtil.applyDeadband(controller.getLeftX(), Constants.JOYSTICK_DEADBAND)));
    }
}
