package org.firebears.commands;

import org.firebears.RobotMap;
import org.firebears.util.LiquidCrystal;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LcdOverLay extends Command {
	DriverStation driverStation;

    public LcdOverLay() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driverStation = DriverStation.getInstance();
    	
    }

    // Called just before this Command runs the first time
    public void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	
    	
    	LiquidCrystal lcd = RobotMap.lcd;
    	lcd.setCursor(14, 3);
    	lcd.print(String.format("%6.2f",driverStation.getBatteryVoltage()));
    	SmartDashboard.putNumber("BatteryV", driverStation.getBatteryVoltage());
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
