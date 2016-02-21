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
	public final double GOAL_SPEED;

	/** Value at which servo fires ball. */
	public final double SERVO_MAX;

	public Shooter() {
		super(0.05, 0.0, 0.0);
		LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
		GOAL_SPEED = getPreferencesDouble("Shooter.goal_speed", 90);
		SERVO_MAX = getPreferencesDouble("Shooter.servo_max", 90);
		getPIDController().setAbsoluteTolerance(5.0);
		spinnerStop();
		servoReset();
	}

	private final CANTalon shootingMotor = RobotMap.shooterShootingMotor;
	private final Servo shooterServo = RobotMap.shooterServo;
	private final Counter shooterCounter = RobotMap.shooterCounter;

	public void initDefaultCommand() {
//		 setDefaultCommand(new ShooterTesterCommand());
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

	public void servoFire() {
		shooterServo.set(SERVO_MAX);
	}

	public void servoReset() {
		shooterServo.set(0);
	}
}
