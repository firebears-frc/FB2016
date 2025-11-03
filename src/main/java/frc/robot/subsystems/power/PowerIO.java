package frc.robot.subsystems.power;

import org.littletonrobotics.junction.AutoLog;

public interface PowerIO {
  @AutoLog
  public static class PowerIOInputs {
    public double primaryVoltage = 0.0;
    public double primaryCurrent = 0.0;
    public double secondaryVoltage = 0.0;
    public double secondaryCurrent = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(PowerIOInputs inputs) {}
}
