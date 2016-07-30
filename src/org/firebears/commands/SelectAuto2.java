package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.commands.defenses.ChevalDeFriseCommand;
import org.firebears.commands.defenses.MoatCommand;
import org.firebears.commands.defenses.PortcullisCommand;
import org.firebears.util.LiquidCrystal;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SelectAuto2 extends Command {
	
	int x = 0;
	Command[] commandlist = {
			new PrepareVisionCommand(1),
			new PrepareVisionCommand(2),
			new PrepareVisionCommand(3),
			new PrepareVisionCommand(4),
			new PrepareVisionCommand(5),
			new ChevalDeFriseCommand(),
			new PortcullisCommand(),
			new MoatCommand(),
			new Donothing(),
	};

    public SelectAuto2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	LiquidCrystal lcd = RobotMap.lcd;
    	x++;
    	if (x >= commandlist.length){
    		x = 0;
    	}
    	Robot.autonomousCommand = commandlist[x];
    	lcd.home();
    	lcd.setCursor(0, 0);
    	lcd.print(commandlist[x].toString());
    	SmartDashboard.putString("Row1", commandlist[x].toString());
    	SmartDashboard.putNumber("Command Array", x);
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
