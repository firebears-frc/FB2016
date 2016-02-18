// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.firebears.subsystems;

import static org.firebears.RobotMap.getPreferencesDouble;

import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Subsystem for retrieving boulders.
 */
public class BallGetter extends PIDSubsystem {

	final double MAXGET_SPEED;

	/** Minimum value that the setpoint may take, measured in volts. */
	final double MIN_VALUE;

	/** Maximum value that the setpoint may take, measured in volts. */
	final double MAX_VALUE;

	/** Maximum speed that the motor can turn, in the range 0.0 to 1.0. */
	final double MAX_SPEED;

	private final CANTalon sideMotor = RobotMap.ballGetterSideMotor;
	private final CANTalon frontMotor = RobotMap.ballGetterFrontMotor;
	private final CANTalon angleMotor = RobotMap.ballGetterAngleMotor;
	private final AnalogInput pot = RobotMap.ballGetterAnalogInput;

	public final static int GRAB = 1;
	public final static int SPIT = 2;
	public final static int OFF = 3;

	public BallGetter() {

		super(1.005, 0, 0);

		MAX_SPEED = getPreferencesDouble("BallGetter.max_speed", 0.65);
		MIN_VALUE = getPreferencesDouble("BallGetter.min_value", 1.450);
		MAX_VALUE = getPreferencesDouble("BallGetter.max_value", 3.711);
		MAXGET_SPEED = getPreferencesDouble("BallGetter.maxget_speed", 0.75);

		getPIDController().setInputRange(MIN_VALUE, MAX_VALUE);
		getPIDController().setAbsoluteTolerance(0.01);
		setSetpoint(1.75);
		getPIDController().enable();
		LiveWindow.addActuator("BallGetter", "PIDSubsystem Controller", getPIDController());
		LiveWindow.addSensor("BallGetter", "current", RobotMap.ballGetterAngleMotor);
	}

	public void initDefaultCommand() {

	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return pot.getAverageVoltage();
	}

	@Override
	protected void usePIDOutput(double output) {
		output = Math.max((MAX_SPEED * -1), Math.min(output, MAX_SPEED));
		angleMotor.set(output);
	}

	public void setMotors(int mode) {
		if (mode == GRAB) {
			frontMotor.set(-MAXGET_SPEED);
			sideMotor.set(-MAXGET_SPEED);
		} else if (mode == OFF) {
			frontMotor.set(0);
			sideMotor.set(0);
		} else if (mode == SPIT) {
			frontMotor.set(MAXGET_SPEED);
			sideMotor.set(0);
		}
	}
}
