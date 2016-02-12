package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Rotate the robot "degrees" degrees
 */
public class RotationCommand extends PIDCommand {

	double turnValue;
	private double initialAngle;
	private final double SPEED = .99;
	
    public RotationCommand(double degrees) {
        super(.009, 0.00001, 0.0); //PID
        requires(Robot.chassis);
        turnValue = degrees;
    }
    
    private static double getAngleDifference(double ivsl, double navxangle) {
    	double currentAngle = navxangle - ivsl;
    	while(currentAngle >= 360) currentAngle -= 360;
  		while(currentAngle < 0) currentAngle += 360;
    	if(currentAngle > 180) currentAngle = currentAngle -360;
    	return currentAngle;
    }
    
    private double getAngleDifference() {
    	return getAngleDifference(initialAngle, RobotMap.navXBoard.getAngle());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialAngle = RobotMap.navXBoard.getAngle();
    	getPIDController().setSetpoint(turnValue);
    	getPIDController().setContinuous(true);
    	getPIDController().setInputRange(-180, 180);
    	getPIDController().setAbsoluteTolerance(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		double difference = getAngleDifference();
		SmartDashboard.putNumber("Difference", difference);
		// if in bounds, return true
		if(turnValue + 10 > difference && turnValue - 10 < difference) return true;
		else return false;
//        return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.drive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {

//		return (difference > 180)? 360 - difference: difference;
		return getAngleDifference();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.chassis.drive(output, 0.0);
	}
	
	// Unit tests.
/*	public static void main(String arg[]) {
		System.out.println("0,30 = 30;" + getAngleDifference(0,30));
		System.out.println("20,50 = 30;" + getAngleDifference(20,50));
		System.out.println("20,350 = -30;" + getAngleDifference(20,350));
		System.out.println("340,10 = 30;" + getAngleDifference(340,10));
	}*/
}
