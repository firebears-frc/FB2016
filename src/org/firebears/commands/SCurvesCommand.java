package org.firebears.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SCurvesCommand extends CommandGroup {
    
    public  SCurvesCommand() {
        addSequential(new RotateCurveCommand(90));
        addSequential(new DriveStraightCommand(36, 0.8));
        addSequential(new RotateCurveCommand(-90));
    }
}
