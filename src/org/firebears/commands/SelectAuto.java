package org.firebears.commands;

import java.sql.Time;

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
//	RotationCommand rc = new RotationCommand(90);
//	RotationCommand rc180 = new RotationCommand(180);
//	RotationCommand rc45 = new RotationCommand(45);
	DriveStraightCommand ds = new DriveStraightCommand(5,.5);
	RampartsCommand rp = new RampartsCommand();
	MoatCommand mc = new MoatCommand();
	LowBarCommand lb = new LowBarCommand();
	ChevalDeFriseCommand cdf = new ChevalDeFriseCommand();

	int which_auto = 0;
	int which_location = 0;
	double rf = Robot.shooter.getRangeFinderDistance();

	private final boolean SET_AUTO = false;
	private final boolean SET_DEFENSE_NUMBER = true;

	private boolean set_what = SET_AUTO;
	private boolean long_press;
	private long origTime = 0;
	private String visionLine = "[-][-][-][-][-]";
	private String autoLine = "Not Set";

	public SelectAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	public void initialize() {
		origTime = System.currentTimeMillis();
	}
	
	public void setAutoMode() {
		LiquidCrystal lcd = RobotMap.lcd;
		String row1 = "";
		String row2 = "";
		String row3 = "";
		String row4 = "";

		which_auto = which_auto + 1;
		lcd.home();

		if (which_auto > 1){
			lcd.setCursor(0, 0);
			lcd.print("Auto Mode:");
		}
		switch(which_auto) {
			case 1:
				row1 = "Welcome to the";
				row2 = "FireBears2846 Robot!";
				row3 = "Your Journey Begins";
				row4 = "Now.";
			case 2:
				autoLine = "RampParts";
				row2 = "Drive straight over ";
				row3 = "the RampParts.";
				row4 = "";
				Robot.autonomousCommand = rp;
			case 3:
				autoLine = "Moat";
				row2 = "Go over the Moat";
				row3 = "";
				row4 = "";
				Robot.autonomousCommand = mc;
			case 4:
				autoLine = "LowBar";
				row2 = "Go under the";
				row3 = "LowBar.";
				row4 = "";
				Robot.autonomousCommand = lb;
			case 5:
				autoLine = "Cheval";
				row2 = "Drive up to the";
				row3 = "ChevalDeFrise&lower";
				row4 = "arm.";
				Robot.autonomousCommand = cdf;//command
			case 6:
				autoLine = "Nothing";
				row2 = "Do nothing.";
				row3 = "";
				row4 = "";
				Robot.autonomousCommand = null;//command
			default: // ( case > 6 ) / number of autos + one welcome screen
				which_auto = 2;
		}
		if(which_auto == 1) {
			setLcdMessage(row1, 0, 0);
			setLcdMessage(row2, 1, 0);
			setLcdMessage(row3, 2, 0);
			setLcdMessage(row4, 3, 0);
		}else{
			// Print to the right of "auto mode:".
			lcd.setCursor(10, 0);
			lcd.print(autoLine);
			// Print other lines
			setLcdMessage(row2, 1, 0);
			setLcdMessage(row3, 2, 0);
			setLcdMessage(row4 + visionLine, 3, 0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	public void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// Whether long press or not
		if(System.currentTimeMillis() - origTime > 1000) {
			// Long Press
			long_press = true;
			return true;
		}else{
			// Short Press
			long_press = false;
			return Robot.oi.autoSwichButton.get();
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		if(long_press) {
			// Switch What Setting.
			if(set_what == SET_AUTO) {
				// Change to Location
				which_location = which_location - 1;
				set_what = SET_DEFENSE_NUMBER;
			}else if(set_what == SET_DEFENSE_NUMBER) {
				// Change to Auto Mode
				which_auto = which_auto - 1;
				set_what = SET_AUTO;
			}
		}
		if(set_what == SET_AUTO) setAutoMode();
		else if(set_what == SET_DEFENSE_NUMBER) setDefenseNumber();
	}
	
	private void setLcdMessage(String print, int row, int column) {
		String nothing = "                    ";
		String message = "";
		String smartdashboardrows[] = { "Row1", "Row2", "Row3", "Row4" };

		// Add empty characters at beginning of string according to row
		message += nothing.substring(column);
		// Add empty characters at end of string to add up to 20 characters.
		message += print + nothing.substring(20 - ( print.length() + column ));

		SmartDashboard.putString(smartdashboardrows[row], message);
		RobotMap.lcd.setCursor(column, row);
		RobotMap.lcd.print(print);
	}

	private void setDefenseNumber() {
		LiquidCrystal lcd = RobotMap.lcd;
		String print = "";
		
		which_location = which_location + 1;
		lcd.home();
		
		switch(which_location) {
			case 1:
				print = "Low Bar";
				visionLine = "[X][ ][ ][ ][ ]";
				break;
			case 2:
				print = "2 Left from centerline";
				visionLine = "[ ][X][ ][ ][ ]";
				break;
			case 3:
				print = "1 Left from centerline";
				visionLine = "[ ][ ][X][ ][ ]";
				break;
			case 4:
				print = "1 Right from centerline";
				visionLine = "[ ][ ][ ][X][ ]";
				break;
			case 5:
				print = "2 Right from centerline";
				visionLine = "[ ][ ][ ][ ][X]";
				break;
			case 6:
				print = "Vision is turned off";
				visionLine = "[ ][ ][ ][ ][ ]";
				break;
			case 7:
				which_location = 1;
		}
		setLcdMessage("Set Location:", 0, 10);
		setLcdMessage(print, 1, 0);
		setLcdMessage(autoLine, 2, 0);
		setLcdMessage(visionLine, 3, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}