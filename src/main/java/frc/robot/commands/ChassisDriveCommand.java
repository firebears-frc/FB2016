package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;

public class ChassisDriveCommand extends CommandBase {

        private final Chassis m_chassis;


    public ChassisDriveCommand(Chassis subsystem) {

        m_chassis = subsystem;
        addRequirements(m_chassis);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        XboxController xboxController=RobotContainer.getInstance().getxbox();
        double speed=xboxController.getLeftY();
        double rotaiton=xboxController.getLeftX();
        m_chassis.arcadeDrive (speed, rotaiton);
    }


    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
