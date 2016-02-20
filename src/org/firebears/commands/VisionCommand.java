package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTablesJNI;

/**
 * Command to process vision processing information from the raspberry pi.
 * - Aligns the robot to the U shaped target in order to shoot.
 */
public class VisionCommand extends Command {

	final String NT_CALIBRATION = "vision/calibrationMode";
	final String NT_DISTANCE = "vision/distance";
	final String NT_ANGLE = "vision/angle";
	final String NT_FPS = "vision/fps";
	final String NT_IMG = "vision/image";

    public VisionCommand() {
    	RobotMap.getPreferencesDouble("vision.hue.lo", 20);
    	RobotMap.getPreferencesDouble("vision.hue.hi", 40);
    	RobotMap.getPreferencesDouble("vision.sat.lo", 200);
    	RobotMap.getPreferencesDouble("vision.sat.hi", 255);
    	RobotMap.getPreferencesDouble("vision.val.lo", 90);
    	RobotMap.getPreferencesDouble("vision.val.hi", 180);
        requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("movex: " + NetworkTablesJNI.getDouble(NT_ANGLE) + ",disty: "
    			+ NetworkTablesJNI.getDouble(NT_DISTANCE));
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
