package org.firebears.commands;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to stop stop the recording called from the smartDashboard.
 */
public class StopMotionRecordCommand extends Command {

    
    public StopMotionRecordCommand() {
    }
   
    protected void initialize() {
    	StartMotionRecordCommand.recording = false;
    }
   
    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }
  
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
