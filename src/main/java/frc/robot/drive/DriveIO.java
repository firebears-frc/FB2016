package frc.robot.drive;

import org.littletonrobotics.junction.AutoLog;

public interface DriveIO {
    @AutoLog
    public static class DriveIOInputs {
        public double leftAppliedVolts = 0.0;
        public double[] leftCurrentAmps = new double[] {};

        public double rightAppliedVolts = 0.0;
        public double[] rightCurrentAmps = new double[] {};
    }

    public void updateInputs(DriveIOInputs inputs);

    public void setVoltage(double leftVolts, double rightVolts);
}
