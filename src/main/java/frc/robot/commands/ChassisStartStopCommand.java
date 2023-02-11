package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class ChassisStartStopCommand extends CommandBase {

  private Chassis chassis;
  private Timer stateTimer = new Timer();
  private boolean movingState = false;
 
  public ChassisStartStopCommand(Chassis c) {
    chassis = c;
    addRequirements(chassis);
  }

  @Override
  public void initialize() {
    stateTimer.reset();
    stateTimer.start();
  }

  @Override
  public void execute() {
    if (movingState) {
      chassis.arcadeDrive(0.6, 0.0);
    } else  {
      chassis.arcadeDrive(0.0, 0.0);
    }
    if (stateTimer.hasElapsed(0.5)) {
      movingState = ! movingState;
      stateTimer.reset();
      stateTimer.start();
    }
  }

  @Override
  public void end(boolean interrupted) {
    chassis.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
