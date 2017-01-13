package org.firebears.commands;

import org.firebears.Robot;

//import org.usfirst.frc2846.TalonPID.Robot;

import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.command.Command;


/**q
 *
 */
public class JoyCon extends Command {
	
	//SRX_PID srx_pid = SRX_PID.getInstance();

    public JoyCon() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.sRX_PID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = Robot.oi.getJoystick1().getRawAxis(1);
    	Robot.sRX_PID.setSetpointRPS(speed);
    	SmartDashboard.putNumber("CmdJoy", speed);

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
