package org.firebears.subsystems;

import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Boulder shooter.
 */
public class Shooter extends PIDSubsystem {

	public Shooter() {
		super(0.1, 0.0, 0.0);
		LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
	}

	private final CANTalon shootingMotor = RobotMap.shooterShootingMotor;
	private final Servo shooterServo = RobotMap.shooterServo;
	private final Counter shooterCounter = RobotMap.shooterCounter;

	public void initDefaultCommand() {
		// setDefaultCommand(new ShooterTesterCommand());
	}

	public double getRate() {
		return 1.0 / shooterCounter.getPeriod();
	}

	@Override
	protected double returnPIDInput() {
		return getRate();
	}

	@Override
	protected void usePIDOutput(double output) {
		shootingMotor.set(-1 * output);
	}
}
