package org.firebears.commands;

import org.firebears.RobotMap;
import org.firebears.util.LiquidCrystal;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SelectAuto extends Command {
	int x = 0;

    public SelectAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	LiquidCrystal lcd = RobotMap.lcd;
    	x = x + 1;
    	
    	
    	if(x > 3){
			x = 0;
	}
		if(x == 0){
			lcd.setCursor(10, 0);
			lcd.print("Hello");
			lcd.print("     ");
	}
		if(x == 1){
			lcd.setCursor(10, 0);
			lcd.print("Hi");
			lcd.print("        ");
	}
		if(x == 2){
			lcd.setCursor(10, 0);
			lcd.print("Greetings");
	}
		if(x == 3){
			lcd.setCursor(10, 0);
			lcd.print("Welcome");
			lcd.print("   ");
	}
		
		lcd.home();
    	lcd.setCursor(0, 0);
    	lcd.print("Auto Mode:");
	lcd.setCursor(0, 2);
	lcd.print("" + x);
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