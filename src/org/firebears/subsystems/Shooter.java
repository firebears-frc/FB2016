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

	/** Rangefinder volts per inch. */
    final double VOLT_DIST_RATIO = 0.00929687; //5.084 Volts / 512 inch range 0.009929687
    
    final double tolerance = 5.0;
    
    public boolean isSpinning() {
    	return Math.abs(shootingMotor.get()) > 0.25;
    }
    
    public boolean hasBall() {
    	return !RobotMap.lazor.get();
    }

	public Shooter() {
		super(0.20, 0.0, 0.0);
		LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
		GOAL_SPEED = getPreferencesDouble("Shooter.goal_speed", 90);
		SERVO_MAX = getPreferencesDouble("Shooter.servo_max", 90);
		getPIDController().setAbsoluteTolerance(tolerance);
		spinnerStop();
		servoReset();
	}

	public final CANTalon shootingMotor = RobotMap.shooterShootingMotor;
	private final Servo shooterServo = RobotMap.shooterServo;
	private final Counter shooterCounter = RobotMap.shooterCounter;

	public void initDefaultCommand() {
	}

	/**
	 * @return revolutions per second.
	 */
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
//		shootingMotor.set(Math.abs(output));
	}
	
	@Override
	public boolean onTarget() {
		double setpoint = getPIDController().getSetpoint();
		double rate = getRate();
		return Math.abs(rate - setpoint) <= tolerance;
	}


	public void spinnerStart() {
		shootingMotor.set(-0.2);
		setSetpoint(GOAL_SPEED);
		enable();
	}

	public void spinnerStop() {
		setSetpoint(0);
		disable();
		shootingMotor.set(0.0);
	}

	public void servoFire() {
		shooterServo.set(SERVO_MAX);
		RobotMap.servoOn = true;
	}
	
	public void servoHold() {
		shooterServo.set(.5);
		RobotMap.servoOn = true;
	}

	public void servoReset() {
		shooterServo.set(0);
		RobotMap.servoOn = false;
	}

    private double getRangeFinderVoltage() {
    	return RobotMap.shooterrangeFinder.getAverageVoltage();
    }

    public double getRangeFinderDistance() {
        double distanceInInches = getRangeFinderVoltage() / VOLT_DIST_RATIO;
        return distanceInInches;
    }
}
