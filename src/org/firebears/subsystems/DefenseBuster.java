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
import org.firebears.commands.BallGetterMotorsCommand;
import org.firebears.util.SoftFuse;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DefenseBuster extends PIDSubsystem {

	/** Minimum value that the setpoint may take, measured in volts. */
	public double MIN_VALUE;

	/** Maximum value that the setpoint may take, measured in volts. */
	public double MAX_VALUE;

	/** Maximum speed that the motor can turn, in the range 0.0 to 1.0. */
	public double MAX_SPEED;

	public double PARK_VALUE;
	
	public int defenseBusterPosition = 1;
	
	SoftFuse softFuse;

	public DefenseBuster() {
		super(0.5, 0, 0);

		MAX_SPEED = getPreferencesDouble(RobotMap.PREF_DEFENSE_BUSTER_MAX_SPEED, 0.8);
		MIN_VALUE = getPreferencesDouble(RobotMap.PREF_DEFENSE_BUSTER_MIN_VALUE, .7);
		MAX_VALUE = getPreferencesDouble(RobotMap.PREF_DEFENSE_BUSTER_MAX_VALUE, 2.15);
		PARK_VALUE = getPreferencesDouble(RobotMap.PREF_DEFENSE_BUSTER_PARK_VALUE, .7);

		softFuse = new SoftFuse(angleMotor, 40, 1, 2);
		
		getPIDController().setInputRange(MIN_VALUE, MAX_VALUE);
		getPIDController().setAbsoluteTolerance(0.01);
		setSetpoint(2.6);
		softFuse.positionFuse(angleMotor.getOutputCurrent());

		getPIDController().enable();
		LiveWindow.addActuator("DefenseBuster", "PIDSubsystem Controller", getPIDController());
	}

	private final CANTalon angleMotor = RobotMap.defenseBusterAngleMotor;
	private final AnalogInput pot = RobotMap.defenseBusterAnalogInput;

	public void initDefaultCommand() {
	}

	@Override
	protected double returnPIDInput() {
		return pot.getAverageVoltage();
	}

	@Override
	protected void usePIDOutput(double output) {
		output = Math.max((MAX_SPEED * -1), Math.min(output, MAX_SPEED));
		angleMotor.set(output);
	}

	public void park(){
		setSetpoint(PARK_VALUE);
		softFuse.positionFuse(angleMotor.getOutputCurrent());
	}
//	public void up(){ for toggle
//		angleMotor.set(2.726);
//	}
//	public void down(){
//		angleMotor.set(3.911);
//	}
}
