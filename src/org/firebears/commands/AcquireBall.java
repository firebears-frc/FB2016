package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Prepares to pick up ball, then automatically picks it up after ball is sensed.
 */
public class AcquireBall extends Command {

    public AcquireBall() {
        requires(Robot.ballGetter);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.ballGetter.setSetpoint(Robot.ballGetter.MAX_VALUE);
//    	Robot.ballGetter.ballGetterPosition = 2;
    	Robot.ballGetter.godown();
    	Robot.ballGetter.setMotors(1);
    	Robot.shooter.servoReset();
    	Robot.shooter.spinnerStop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.shooter.hasBall();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.servoHold();
//		Robot.ballGetter.setSetpoint(Robot.ballGetter.MIN_VALUE);
//		Robot.ballGetter.ballGetterPosition = 1;
		Robot.ballGetter.goup();
		Robot.ballGetter.setMotors(3);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	if (Robot.shooter.hasBall()){
    		Robot.shooter.servoHold();
    	}else {
    		Robot.shooter.servoFire();
    	}
    	Robot.shooter.servoFire();
//		Robot.ballGetter.setSetpoint(Robot.ballGetter.MIN_VALUE);
//		Robot.ballGetter.ballGetterPosition = 1;
//    	Robot.ballGetter.goup();
		Robot.ballGetter.setMotors(3);
    }
}
