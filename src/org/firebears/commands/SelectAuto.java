
package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.commands.defenses.ChevalDeFriseCommand;
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
	ChevalDeFriseCommand cdf = new ChevalDeFriseCommand();

	int x = 0;
	double rf = Robot.shooter.getRangeFinderDistance();



	

	public SelectAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.chassis);
		
	}

	// Called just before this Command runs the first time
	public void initialize() {
		
	

	}

	// Called repeatedly when this Command is scheduled to run
	public void execute() {
		LiquidCrystal lcd = RobotMap.lcd;
		x = x + 1;
		lcd.home();

		if (x > 10) {//number of autos + one welcome screen
			x = 2;
		}
		if (x > 1){
			lcd.setCursor(0, 0);
			lcd.print("Auto Mode:");
		}
		if (x == 1) {
			String row1 = "Welcome to the";
			String row2 = "FireBears2846 Robot!";
			String row3 = "Your Journey Begins";
			String row4 = "Now.";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			
			lcd.setCursor(0, 0);
			lcd.print(""+row1);
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			
		}
		if (x == 2) {
			String row1 = "Rotate45";
			String row2 = "Rotate the robot    ";
			String row3 = "45 degrees.         ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print("  ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = rc45;
		}
		if (x == 3) {
			String row1 = "Rotate90";
			String row2 = "Rotate the robot    ";
			String row3 = "90 degrees.         ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			
			
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print("  ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = rc;
		}
		if (x == 4){
			String row1 = "Rotate180";
			String row2 = "Rotate the robot    ";
			String row3 = "180 degrees.        ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print(" ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = rc180;
		}
		if (x == 5) {
			String row1 = "RampParts";
			String row2 = "Drive straight over ";
			String row3 = "the RampParts.      ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print(" ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = rp;//command
		}
		if (x == 6) {
			String row1 = "Moat";
			String row2 = "Go over the Moat    ";
			String row3 = "                    ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print("      ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = mc;//command
		}
		if (x == 7) {
			String row1 = "LowBar";
			String row2 = "Go under the        ";
			String row3 = "LowBar.             ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print("    ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = lb;//command
		}
		if (x == 8) {
			String row1 = "Cheval";
			String row2 = "Drives up to the";
			String row3 = "ChevalDeFrise & puts";
			String row4 = "down the arm.  ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print("    ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = cdf;//command
		}
		if (x == 9) {
			String row1 = "Nothing";
			String row2 = "Do nothing.         ";
			String row3 = "                    ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print(""+row1);
			lcd.print("   ");
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = null;//command
		}
		if (x == 10) {
			String row1 = ""+rf;
			String row2 = "                    ";
			String row3 = "                    ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print(""+rf);
			lcd.setCursor(0, 1);
			lcd.print(""+row2);
			lcd.setCursor(0, 2);
			lcd.print(""+row3);
			lcd.setCursor(0, 3);
			lcd.print(""+row4);
			Robot.autonomousCommand = null;//command
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