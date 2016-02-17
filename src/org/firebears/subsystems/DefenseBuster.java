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

import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class DefenseBuster extends PIDSubsystem {

	/** Minimum value that the setpoint may take, measured in volts. */
	double MIN_VALUE;

	/** Maximum value that the setpoint may take, measured in volts. */
	double MAX_VALUE;

	/** Maximum speed that the motor can turn, in the range 0.0 to 1.0. */
	double MAX_SPEED;


    public DefenseBuster() {
		super(0.5, 0, 0);
		
		Preferences preferences = Preferences.getInstance();
        
        MAX_SPEED = preferences.getDouble("DefenseBuster.max_speed", 1.0);
        MIN_VALUE = preferences.getDouble("DefenseBuster.min_value", 1.80);
        MAX_VALUE = preferences.getDouble("DefenseBuster.max_value", 3.72);
		
		getPIDController().setInputRange(MIN_VALUE, MAX_VALUE);
		getPIDController().setAbsoluteTolerance(0.01);
		setSetpoint(MIN_VALUE);
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
		output = Math.max((MAX_SPEED*-1), Math.min(output, MAX_SPEED));
		angleMotor.set(output);
	}
}

