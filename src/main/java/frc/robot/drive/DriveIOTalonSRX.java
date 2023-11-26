package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveIOTalonSRX implements DriveIO {
    private final WPI_TalonSRX frontLeft, rearLeft, frontRight, rearRight;
    private final MotorControllerGroup left, right;

    private double leftAppliedVolts, rightAppliedVolts;

    public DriveIOTalonSRX() {
        frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_CAN_ID);
        frontLeft.configFactoryDefault();
        frontLeft.setInverted(false);
        frontLeft.setNeutralMode(NeutralMode.Coast);
        frontLeft.configPeakCurrentLimit(Constants.PEAK_CURRENT_LIMIT);
        frontLeft.configPeakCurrentDuration(Constants.PEAK_CURRENT_DURATION);
        frontLeft.configContinuousCurrentLimit(Constants.CONTINUOUS_CURRENT_LIMIT);

        rearLeft = new WPI_TalonSRX(Constants.REAR_LEFT_CAN_ID);
        rearLeft.configFactoryDefault();
        rearLeft.setInverted(false);
        rearLeft.setNeutralMode(NeutralMode.Coast);
        rearLeft.configPeakCurrentLimit(Constants.PEAK_CURRENT_LIMIT);
        rearLeft.configPeakCurrentDuration(Constants.PEAK_CURRENT_DURATION);
        rearLeft.configContinuousCurrentLimit(Constants.CONTINUOUS_CURRENT_LIMIT);

        frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_CAN_ID);
        frontRight.configFactoryDefault();
        frontRight.setInverted(false);
        frontRight.setNeutralMode(NeutralMode.Coast);
        frontRight.configPeakCurrentLimit(Constants.PEAK_CURRENT_LIMIT);
        frontRight.configPeakCurrentDuration(Constants.PEAK_CURRENT_DURATION);
        frontRight.configContinuousCurrentLimit(Constants.CONTINUOUS_CURRENT_LIMIT);

        rearRight = new WPI_TalonSRX(Constants.REAR_RIGHT_CAN_ID);
        rearRight.configFactoryDefault();
        rearRight.setInverted(false);
        rearRight.setNeutralMode(NeutralMode.Coast);
        rearRight.configPeakCurrentLimit(Constants.PEAK_CURRENT_LIMIT);
        rearRight.configPeakCurrentDuration(Constants.PEAK_CURRENT_DURATION);
        rearRight.configContinuousCurrentLimit(Constants.CONTINUOUS_CURRENT_LIMIT);

        left = new MotorControllerGroup(frontLeft, rearLeft);
        right = new MotorControllerGroup(frontRight, rearRight);

        // https://v5.docs.ctr-electronics.com/en/stable/ch18_CommonAPI.html#setting-status-frame-periods
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, 20);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1000);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat, 20);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, 1000);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 1000);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 1000);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 1000);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_14_Turn_PIDF1, 1000);
        frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_21_FeedbackIntegrated, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, 20);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat, 20);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_14_Turn_PIDF1, 1000);
        rearLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_21_FeedbackIntegrated, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, 20);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat, 20);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_14_Turn_PIDF1, 1000);
        frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_21_FeedbackIntegrated, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, 20);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat, 20);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_14_Turn_PIDF1, 1000);
        rearRight.setStatusFramePeriod(StatusFrameEnhanced.Status_21_FeedbackIntegrated, 1000);

        leftAppliedVolts = 0.0;
        rightAppliedVolts = 0.0;
    }

    @Override
    public void updateInputs(DriveIOInputs inputs) {
        inputs.leftAppliedVolts = leftAppliedVolts;
        inputs.leftCurrentAmps = new double[] { frontLeft.getStatorCurrent(), rearLeft.getStatorCurrent() };
        inputs.rightAppliedVolts = rightAppliedVolts;
        inputs.rightCurrentAmps = new double[] { frontRight.getStatorCurrent(), rearRight.getStatorCurrent() };
    }

    @Override
    public void setVoltage(double leftVolts, double rightVolts) {
        leftAppliedVolts = leftVolts;
        rightAppliedVolts = rightVolts;

        left.setVoltage(leftVolts);
        right.setVoltage(rightVolts);
    }
}
