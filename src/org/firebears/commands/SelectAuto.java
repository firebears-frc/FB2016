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
	int x = 0;
	RotationCommand rc = new RotationCommand(90);
	RotationCommand rc180 = new RotationCommand(180);
	RotationCommand rc45 = new RotationCommand(45);
	DriveStraightCommand ds = new DriveStraightCommand(5,.5);
	RampartsCommand rp = new RampartsCommand();
	MoatCommand mc = new MoatCommand();
	LowBarCommand lb = new LowBarCommand();
	LiquidCrystal lcd = RobotMap.lcd;
	
	
	

	public SelectAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	public void initialize() {
		
		

	}

	// Called repeatedly when this Command is scheduled to run
	public void execute() {
		x = x + 1;

		if (x > 7) {//number of autos + one welcome screen
			x = 2;
		}
		if (x == 1) {
			lcd.setCursor(10, 0);
			lcd.print("Welcome");
			lcd.print("   ");
			lcd.setCursor(0, 1);
			lcd.print("FireBears 2846");
			lcd.begin(0, 2);
			lcd.print("Begin your journey");
			lcd.setCursor(0, 3);
			lcd.print("now");
			
		}
		if (x == 2) {
			lcd.setCursor(10, 0);
			lcd.print("Rot45");
			lcd.print("    ");
			lcd.setCursor(0, 1);
			lcd.print("Rotate the Robot 45");
			lcd.print(" ");
			lcd.begin(0, 2);
			lcd.print("                    ");
			lcd.setCursor(0, 3);
			lcd.print("                    ");
			Robot.autonomousCommand = rc45;
		}
		if (x == 3) {
			lcd.setCursor(10, 0);
			lcd.print("Rot180");
			lcd.print("    ");
			lcd.setCursor(0, 1);
			lcd.print("Rotate the Robot 180");
			lcd.begin(0, 2);
			lcd.print("                    ");
			lcd.setCursor(0, 3);
			lcd.print("                    ");
			Robot.autonomousCommand = rc180;
		}
		if (x == 4){
			lcd.setCursor(10, 0);
			lcd.print("Rot90");
			lcd.print("     ");
			lcd.setCursor(0, 1);
			lcd.print("Rotate the Robot 90");
			lcd.print(" ");
			lcd.begin(0, 2);
			lcd.print("                    ");
			lcd.setCursor(0, 3);
			lcd.print("                    ");
			Robot.autonomousCommand = rc;
		}
		if (x == 5) {
			lcd.setCursor(10, 0);
			lcd.print("Ramparts");//Title
			lcd.print("  ");//number of spaces after the word to erase the last word(spaces should equal 10)
			lcd.setCursor(0, 1);//Description of the command
			lcd.print("Drive the robot over");
			lcd.begin(0, 2);
			lcd.print("the Ramparts");
			lcd.print("       ");
			lcd.setCursor(0, 3);
			lcd.print("                    ");
			Robot.autonomousCommand = rp;//command
		}
		if (x == 6) {
			lcd.setCursor(10, 0);
			lcd.print("Moat");//Title
			lcd.print("      ");//number of spaces after the word to erase the last word(spaces should equal 10)
			lcd.setCursor(0, 1);
			lcd.print("Drive the robot over");
			lcd.begin(0, 2);
			lcd.print("the Moat");
			lcd.print("            ");
			lcd.setCursor(0, 3);
			lcd.print("                    ");
			Robot.autonomousCommand = mc;//command
		}
		if (x == 7) {
			lcd.setCursor(10, 0);
			lcd.print("LowBar");//Title
			lcd.print("    ");//number of spaces after the word to erase the last word(spaces should equal 10)
			lcd.setCursor(0, 1);
			lcd.print("Drive the robot over");
			lcd.begin(0, 2);
			lcd.print("the LowBar");
			lcd.print("        ");
			lcd.setCursor(0, 3);
			lcd.print("                    ");
			Robot.autonomousCommand = lb;//command
		}
//Note: if the lcd goes out of bounds of the lcd it will send an error and disable the INTER ROBOT
		lcd.home();
		lcd.setCursor(0, 0);
		lcd.print("Auto Mode:");
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
