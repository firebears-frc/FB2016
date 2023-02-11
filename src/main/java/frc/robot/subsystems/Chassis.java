package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DriverStation;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends SubsystemBase {
    private WPI_TalonSRX frontleft;
    private WPI_TalonSRX backleft;
    private MotorControllerGroup leftMotors;
    private WPI_TalonSRX frontright;
    private WPI_TalonSRX backright;
    private MotorControllerGroup rightMotors;
    private DifferentialDrive differentialDrive;
    private AHRS navx;

    public Chassis() {
        frontleft = new WPI_TalonSRX(2);

        backleft = new WPI_TalonSRX(3);

        leftMotors = new MotorControllerGroup(frontleft, backleft);
        addChild("leftMotors", leftMotors);

        frontright = new WPI_TalonSRX(4);

        backright = new WPI_TalonSRX(5);

        rightMotors = new MotorControllerGroup(frontright, backright);
        addChild("rightMotors", rightMotors);

        differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("differentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        try {
            navx = new AHRS(I2C.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError(ex.getMessage(), true);
        }
        Timer.delay(1.0);


    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("pitch", navx.getPitch());

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void arcadeDrive(double speed, double rotaiton) {

        differentialDrive.arcadeDrive(rotaiton, speed * -1);
    }

    public double getPitch(){
        return navx.getPitch();
    }
}
