package frc.robot.subsystems.power;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.AutoLogOutput;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.LoggedNetworkNumber;

public class Power extends SubsystemBase {
  private final PowerIO io;
  private final PowerIOInputsAutoLogged inputs = new PowerIOInputsAutoLogged();

  // Dashboard inputs
  private final LoggedNetworkNumber primaryWarning =
      new LoggedNetworkNumber("Power/Primary Battery/Warning Voltage", 8.0);
  private final LoggedNetworkNumber primaryShutdown =
      new LoggedNetworkNumber("Power/Primary Battery/Shutdown Voltage", 7.0);
  private final LoggedNetworkNumber secondaryWarning =
      new LoggedNetworkNumber("Power/Secondary Battery/Warning Voltage", 11.0);
  private final LoggedNetworkNumber secondaryShutdown =
      new LoggedNetworkNumber("Power/Secondary Battery/Shutdown Voltage", 10.0);

  /** Creates a new Power subsystem. */
  public Power(PowerIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Power", inputs);
  }

  @AutoLogOutput(key = "Power/Primary Battery/Warning")
  public boolean primaryWarning() {
    return inputs.primaryVoltage < primaryWarning.get();
  }

  @AutoLogOutput(key = "Power/Secondary Battery/Warning")
  public boolean secondaryWarning() {
    return inputs.secondaryVoltage < secondaryWarning.get();
  }

  @AutoLogOutput(key = "Power/Warning")
  public boolean warning() {
    return primaryWarning() || secondaryWarning();
  }

  @AutoLogOutput(key = "Power/Primary Battery/Shutdown")
  public boolean primaryShutdown() {
    return inputs.primaryVoltage < primaryShutdown.get();
  }

  @AutoLogOutput(key = "Power/Secondary Battery/Shutdown")
  public boolean secondaryShutdown() {
    return inputs.secondaryVoltage < secondaryShutdown.get();
  }

  @AutoLogOutput(key = "Power/Shutdown")
  public boolean shutdown() {
    return primaryShutdown() || secondaryShutdown();
  }
}
