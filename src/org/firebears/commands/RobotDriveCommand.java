// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.firebears.commands;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;

/** *
 */
public class RobotDriveCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public RobotDriveCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    double x3;
	double y3;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double y = Robot.oi.getJoystick1().getY();
    	double x = Robot.oi.getJoystick1().getX();
    	double sens = 1.5;
    	
    	
    	if (x < 0){
    		double x2 = x * -1;
    		x3 = -Math.pow(x2, sens);
    	}
    	if (y < 0){
    		double y2 = y * -1;
    		y3 = -Math.pow(y2, sens);
    	}
    	if (x > 0){
    		x3 = Math.pow(x, sens);
    	}
    	if (y > 0){
    		y3 = Math.pow(y, sens);
    	}
    	
//    	double x2 = Math.pow(x, .5);
//    	double y2 = Math.pow(y, .5);
    	
    	Robot.chassis.drive(x3, y3);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
