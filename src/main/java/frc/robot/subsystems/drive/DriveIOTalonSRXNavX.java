package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;

public class DriveIOTalonSRXNavX implements DriveIO {
  private final WPI_TalonSRX frontleft, backleft, frontright, backright;
  private AHRS navx;

  public DriveIOTalonSRXNavX() {
    frontleft = new WPI_TalonSRX(2);
    frontleft.setNeutralMode(NeutralMode.Brake);
    backleft = new WPI_TalonSRX(3);
    backleft.setNeutralMode(NeutralMode.Brake);
    frontright = new WPI_TalonSRX(4);
    frontright.setNeutralMode(NeutralMode.Brake);
    backright = new WPI_TalonSRX(5);
    backright.setNeutralMode(NeutralMode.Brake);

    try {
      navx = new AHRS(I2C.Port.kMXP);
    } catch (RuntimeException ex) {
      DriverStation.reportError(ex.getMessage(), true);
    }
  }

  /** Updates the set of loggable inputs. */
  public void updateInputs(DriveIOInputs inputs) {
    inputs.leftAppliedVolts = frontleft.getMotorOutputVoltage();
    inputs.rightAppliedVolts = frontright.getMotorOutputVoltage();
    inputs.leftCurrentAmps =
        new double[] {frontleft.getSupplyCurrent(), backleft.getSupplyCurrent()};
    inputs.rightCurrentAmps =
        new double[] {frontright.getSupplyCurrent(), backright.getSupplyCurrent()};
    inputs.gyroYaw = (navx == null ? new Rotation2d() : navx.getRotation2d());
  }

  /** Run open loop at the specified voltage. */
  public void setVoltage(double leftVolts, double rightVolts) {
    frontleft.setVoltage(leftVolts);
    backleft.setVoltage(leftVolts);
    frontright.setVoltage(rightVolts);
    backright.setVoltage(rightVolts);
  }
}
