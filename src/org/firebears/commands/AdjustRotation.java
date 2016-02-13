package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AdjustRotation extends CommandGroup {

    public AdjustRotation() {
    	addSequential(new RotationCommand(RobotMap.rotation - RobotMap.navXBoard.getAngle()));
    	requires(Robot.chassis);
    }

}
