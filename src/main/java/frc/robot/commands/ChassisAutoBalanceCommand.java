// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class ChassisAutoBalanceCommand extends CommandBase {
  Chassis m_chassis;
  Timer timer;
  double lastPitch;
  double speed;
  Timer timer2;
  /** Creates a new ChassisAutoBalanceCommand. */
  public ChassisAutoBalanceCommand(Chassis chassis) {
    m_chassis = chassis;
    timer = new Timer();
    timer2 = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lastPitch = m_chassis.getPitch();
    timer2.reset();
    timer2.start();
    speed = 0.55;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double pitchVelocity;
    pitchVelocity = Math.abs(m_chassis.getPitch() - lastPitch);
    double pitchSpeed = m_chassis.getPitch() - lastPitch;

    SmartDashboard.putNumber("Pitch Velocity", pitchVelocity);
    SmartDashboard.putNumber("Speed", speed);
    SmartDashboard.putNumber("Timer2", timer2.get());
    SmartDashboard.putNumber(
      "CounterRot", 
      pitchSpeed * Math.signum(m_chassis.getPitch())
    );
    if(pitchVelocity >= 0.3 && timer2.hasElapsed(1)) {
      speed = -0.31;
    }

    if(m_chassis.getPitch() >= 3) {
      m_chassis.arcadeDrive(-speed, 0);
      timer.reset();
    } else if(m_chassis.getPitch() <= -3) {
      m_chassis.arcadeDrive(speed, 0);
      timer.reset();
    } else {
      timer.start();
    }
    lastPitch = m_chassis.getPitch();
     
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_chassis.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(1);
  }
}
