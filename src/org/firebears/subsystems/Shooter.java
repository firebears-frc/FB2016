package org.firebears.subsystems;

import static org.firebears.RobotMap.getPreferencesDouble;

import org.firebears.RobotMap;
import org.firebears.commands.ShooterTesterCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Boulder shooter.
 */
public class Shooter extends PIDSubsystem {

	/** Goal speed for shooting, as returned by the counter rate. */
	double GOAL_SPEED;

	public Shooter() {
		super(0.05, 0.0, 0.0);
		LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
		GOAL_SPEED = getPreferencesDouble("Shooter.goal_speed", 90);
		setSetpoint(0.0);
		disable();
	}

	private final CANTalon shootingMotor = RobotMap.shooterShootingMotor;
	private final Servo shooterServo = RobotMap.shooterServo;
	private final Counter shooterCounter = RobotMap.shooterCounter;

	public void initDefaultCommand() {
		 setDefaultCommand(new ShooterTesterCommand());
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
		shootingMotor.set(-1 * Math.abs(output));
	}

	public void spinnerStart() {
		setSetpoint(GOAL_SPEED);
		enable();
	}

	public void spinnerStop() {
		setSetpoint(0);
		enable();
	}
}
