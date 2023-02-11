package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Chassis;

public class AutonomousBalancingCommand extends CommandBase {
  private final Chassis m_chassis;

  public AutonomousBalancingCommand(Chassis subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_chassis = subsystem;
    addRequirements(m_chassis);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    if (m_chassis.getPitch() <= -1) {
      m_chassis.arcadeDrive(0.5, 0);
    } else if (m_chassis.getPitch() >= 1) {
      m_chassis.arcadeDrive(-0.5, 0);
    } else {
      m_chassis.arcadeDrive(0, 0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_chassis.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return m_chassis.getPitch() >= -1 && m_chassis.getPitch() <= 1;
  }
}
