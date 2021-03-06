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

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Subsystem for retrieving boulders.
 */
public class BallGetter extends PIDSubsystem {
	int time = 0;

	final double MAXGET_SPEED;

	/** Minimum value that the setpoint may take, measured in volts. */
	public final double MIN_VALUE;

	/** Maximum value that the setpoint may take, measured in volts. */
	public final double MAX_VALUE;

	/** Maximum speed that the motor can turn, in the range 0.0 to 1.0. */
	final double MAX_SPEED;
	
	public final double SIDE_SPEED;
	
	public final double PARK_VALUE;
	
	public int ballGetterPosition = 1;

	private final CANTalon sideMotor = RobotMap.ballGetterSideMotor;
	private final CANTalon frontMotor = RobotMap.ballGetterFrontMotor;
	private final CANTalon angleMotor = RobotMap.ballGetterAngleMotor;
	private final AnalogInput pot = RobotMap.ballGetterAnalogInput;

	public final static int GRAB = 1;
	public final static int SPIT = 2;
	public final static int OFF = 3;
	
	public int mode2 = OFF;
	public int mode3 = 0;

	public BallGetter() {
		
		super(1.005, 0, 0);
//		super(1.75, 0.04, 2.5);

		MAX_SPEED = getPreferencesDouble(RobotMap.PREF_BALL_GETTER_MAX_SPEED, 0.65);
		MIN_VALUE = getPreferencesDouble(RobotMap.PREF_BALL_GETTER_MIN_VALUE, .75);
		MAX_VALUE = getPreferencesDouble(RobotMap.PREF_BALL_GETTER_MAX_VAUE, 2.2);
		MAXGET_SPEED = getPreferencesDouble(RobotMap.PREF_BALL_GETTER_MAXGET_SPEED, 0.75);
		PARK_VALUE = getPreferencesDouble(RobotMap.PREF_BALL_GETTER_PARK_VALUE, .9);
		SIDE_SPEED = MAXGET_SPEED * 0.5;
		
		getPIDController().setInputRange(MIN_VALUE, MAX_VALUE);
		getPIDController().setAbsoluteTolerance(0.01);
		getPIDController().setToleranceBuffer(8);
		setSetpoint(2.1);
//		Robot.ballGetter.ballGetterPosition = 1;
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
	
	public void park(){
		setSetpoint(PARK_VALUE);
		Robot.ballGetter.ballGetterPosition = 1;
	}
//	public void up(){//for toggle
//		angleMotor.set(2.1);
//	}
//	public void down(){
//		angleMotor.set(3.33);
//	}
	public void goup(){
		Robot.ballGetter.setSetpoint(Robot.ballGetter.MIN_VALUE);
    	Robot.ballGetter.ballGetterPosition = 1;
	}
	public void godown(){
    	Robot.ballGetter.setSetpoint(Robot.ballGetter.MAX_VALUE);
    	Robot.ballGetter.ballGetterPosition = 2;
	}
	public void setMotors(int mode) {
		mode2 = mode;
		if (mode == GRAB) {
			frontMotor.set(MAXGET_SPEED); //(-MAXGET_SPEED) if for practice robot
//			frontMotor.set(-MAXGET_SPEED);
			sideMotor.set(-SIDE_SPEED);
			mode3 = 0;
		} else if (mode == OFF) {
			frontMotor.set(0);
			sideMotor.set(0);
		} else if (mode == SPIT) {
			Robot.shooter.servoReset();
			frontMotor.set(-MAXGET_SPEED);//(MAXGET_SPEED) if for practice robot
//			frontMotor.set(MAXGET_SPEED);
			sideMotor.set(0);
			mode3 = 1;
		}
	}
}
