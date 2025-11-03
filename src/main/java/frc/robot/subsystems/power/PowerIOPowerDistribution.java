package frc.robot.subsystems.power;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.RobotController;

public class PowerIOPowerDistribution implements PowerIO {
  private final PowerDistribution powerDistribution = new PowerDistribution();

  @Override
  public void updateInputs(PowerIOInputs inputs) {
    inputs.primaryVoltage = powerDistribution.getVoltage();
    inputs.primaryCurrent = powerDistribution.getTotalCurrent();
    inputs.secondaryVoltage = RobotController.getBatteryVoltage();
    inputs.secondaryCurrent = 0.0;
  }
}
