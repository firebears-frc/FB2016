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
import org.firebears.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Subsystem for retrieving boulders.
 */
public class BallGetter extends PIDSubsystem {
	
	final double maxget_speed;
	
	/** Minimum value that the setpoint may take, measured in volts. */
	final double min_value;

	/** Maximum value that the setpoint may take, measured in volts. */
	final double max_value;

	/** Maximum speed that the motor can turn, in the range 0.0 to 1.0. */
	final double max_speed;

    private final CANTalon sideMotor = RobotMap.ballGetterSideMotor;
    private final CANTalon frontMotor = RobotMap.ballGetterFrontMotor;
    private final CANTalon angleMotor = RobotMap.ballGetterAngleMotor;
    private final AnalogInput pot = RobotMap.ballGetterAnalogInput;
    

    public BallGetter() {
    	
    	
    	
    	super(0.5, 0, 0);
    	
    	Preferences preferences = Preferences.getInstance();
        
        max_speed = preferences.getDouble("BallGetter.max_speed", .65);
        min_value = preferences.getDouble("BallGetter.max_speed", 1.450);
        max_value = preferences.getDouble("BallGetter.max_speed", 3.711);
        maxget_speed = preferences.getDouble("BallGetter.max_speed", .25);
        
		getPIDController().setInputRange(min_value, max_value);
		getPIDController().setAbsoluteTolerance(0.01);
		setSetpoint(min_value);
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
		output = Math.max((max_speed*-1), Math.min(output, max_speed));
		angleMotor.set(output);
		frontMotor.set(maxget_speed);
		sideMotor.set(-maxget_speed);
	}
}

