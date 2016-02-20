
package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.commands.defenses.LowBarCommand;
import org.firebears.commands.defenses.MoatCommand;
import org.firebears.commands.defenses.RampartsCommand;
import org.firebears.util.LiquidCrystal;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SelectAuto extends Command {
	RotationCommand rc = new RotationCommand(90);
	RotationCommand rc180 = new RotationCommand(180);
	RotationCommand rc45 = new RotationCommand(45);
	DriveStraightCommand ds = new DriveStraightCommand(5,.5);
	RampartsCommand rp = new RampartsCommand();
	MoatCommand mc = new MoatCommand();
	LowBarCommand lb = new LowBarCommand();

	int x = 0;



	

	public SelectAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	public void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	public void execute() {
		
		LiquidCrystal lcd = RobotMap.lcd;
		x = x + 1;
		lcd.home();

		if (x > 7) {//number of autos + one welcome screen
			x = 2;
		}
		if (x > 1){
			
			lcd.setCursor(0, 0);
			lcd.print("Auto Mode:");
		}
		if (x == 1) {
			lcd.setCursor(0, 0);
			lcd.print("Welcome to the");
			lcd.setCursor(0, 1);
			lcd.print("FireBears2846 Robot!");
			lcd.setCursor(0, 2);
			lcd.print("Your Journey Begins");
			lcd.setCursor(0, 3);
			lcd.print("Now.");
			
		}
		if (x == 2) {
			lcd.setCursor(10, 0);
			lcd.print("Rotate45");
			lcd.print("  ");
			lcd.setCursor(0, 1);
			lcd.print("Rotate the robot    ");
			lcd.setCursor(0, 2);
			lcd.print("45 degrees.         ");
			lcd.setCursor(0, 3);
			lcd.print("               ");
			Robot.autonomousCommand = rc45;
		}
		if (x == 3) {
			lcd.setCursor(10, 0);
			lcd.print("Rotate90");
			lcd.print("  ");
			lcd.setCursor(0, 1);
			lcd.print("Rotate the robot    ");
			lcd.setCursor(0, 2);
			lcd.print("90 degrees.         ");
			lcd.setCursor(0, 3);
			lcd.print("               ");
			Robot.autonomousCommand = rc;
		}
		if (x == 4){
			lcd.setCursor(10, 0);
			lcd.print("Rotate180");
			lcd.print(" ");
			lcd.setCursor(0, 1);
			lcd.print("Rotate the robot    ");
			lcd.setCursor(0, 2);
			lcd.print("180 degrees.        ");
			lcd.setCursor(0, 3);
			lcd.print("               ");
			Robot.autonomousCommand = rc180;
		}
		if (x == 5) {
			lcd.setCursor(10, 0);
			lcd.print("RampParts");
			lcd.print(" ");
			lcd.setCursor(0, 1);
			lcd.print("Drive straight over ");
			lcd.setCursor(0, 2);
			lcd.print("the RampParts.      ");
			lcd.setCursor(0, 3);
			lcd.print("               ");
			Robot.autonomousCommand = rp;//command
		}
		if (x == 6) {
			lcd.setCursor(10, 0);
			lcd.print("Moat");
			lcd.print("      ");
			lcd.setCursor(0, 1);
			lcd.print("Go over the Moat    ");
			lcd.setCursor(0, 2);
			lcd.print("                    ");
			lcd.setCursor(0, 3);
			lcd.print("               ");
			Robot.autonomousCommand = mc;//command
		}
		if (x == 7) {
			lcd.setCursor(10, 0);
			lcd.print("LowBar");
			lcd.print("    ");
			lcd.setCursor(0, 1);
			lcd.print("Drive under the     ");
			lcd.setCursor(0, 2);
			lcd.print("LowBar.             ");
			lcd.setCursor(0, 3);
			lcd.print("               ");
			Robot.autonomousCommand = lb;//command
		}
//Note: if the lcd goes out of bounds of the lcd it will send an error and disable the INTER ROBOt
//		lcd.setCursor(0, 1);//Debugging button number
//		lcd.print("" + x);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}