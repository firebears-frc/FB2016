
package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.commands.defenses.ChevalDeFriseCommand;
import org.firebears.commands.defenses.LowBarCommand;
import org.firebears.commands.defenses.MoatCommand;
import org.firebears.commands.defenses.PortcullisCommand;
import org.firebears.commands.defenses.RampartsCommand;
import org.firebears.commands.defenses.RockWallCommand;
import org.firebears.commands.defenses.RoughTerrainCommand;
import org.firebears.util.LiquidCrystal;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SelectAuto extends Command {
	// Home card 												//1
	ChevalDeFriseCommand cdf = new ChevalDeFriseCommand(); 		//2
	LowBarCommand lb = new LowBarCommand(); 					//3
	MoatCommand mc = new MoatCommand(); 						//4
	PortcullisCommand pc = new PortcullisCommand(); 			//5
	RampartsCommand rp = new RampartsCommand(); 				//6
	RockWallCommand rw = new RockWallCommand(); 				//7
	RoughTerrainCommand rt = new RoughTerrainCommand(); 		//8
	// Do nothing 												//9

	int x = 0;
	// double rf = Robot.shooter.getRangeFinderDistance();

	public SelectAuto() {
				requires(Robot.chassis);

	}

	public void initialize() {

	}

	public void execute() {
		LiquidCrystal lcd = RobotMap.lcd;
		x = x + 1;
		lcd.home();

		if (x > 9) {// number of autos + one welcome screen
			x = 2;
		}
		if (x > 1) {
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
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);

		}
		if (x == 2) {
			String row1 = "Cheval";
			String row2 = "Drives up to the";
			String row3 = "ChevalDeFrise & puts";
			String row4 = "down the arm.  ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = cdf;
		}
		if (x == 3) {
			String row1 = "LowBar";
			String row2 = "Go under the        ";
			String row3 = "LowBar.             ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.print(" ");
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = lb;
		}
		if (x == 4) {
			String row1 = "Moat";
			String row2 = "Go over the Moat    ";
			String row3 = "                    ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = mc;
		}
		if (x == 5) {
			String row1 = "Port";
			String row2 = "Drive up to the     ";
			String row3 = "Portcullis and lift ";
			String row4 = "it.            ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = pc;
		}
		if (x == 6) {
			String row1 = "RampParts";
			String row2 = "Drive straight over ";
			String row3 = "the RampParts.      ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = rp;
		}
		if (x == 7) {
			String row1 = "RockWall";
			String row2 = "Drive over the      ";
			String row3 = "RockWall            ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = rw;
		}
		if (x == 8) {
			String row1 = "RoughT";
			String row2 = "Drive over the      ";
			String row3 = "RoughTerrain.       ";
			String row4 = "               ";
			SmartDashboard.putString("Row1", row1);
			SmartDashboard.putString("Row2", row2);
			SmartDashboard.putString("Row3", row3);
			SmartDashboard.putString("Row4", row4);
			lcd.setCursor(10, 0);
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = rt;
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
			lcd.print("" + row1);
			lcd.setCursor(0, 1);
			lcd.print("" + row2);
			lcd.setCursor(0, 2);
			lcd.print("" + row3);
			lcd.setCursor(0, 3);
			lcd.print("" + row4);
			Robot.autonomousCommand = null;
		}
		// Note: if the lcd goes out of bounds of the lcd it will send an error and disable the INTER ROBOT
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}