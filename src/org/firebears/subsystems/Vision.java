package org.firebears.subsystems;

import org.firebears.commands.VisionCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to interface with the raspberry pi.
 */
public class Vision extends Subsystem {

    public void initDefaultCommand() {
        setDefaultCommand(new VisionCommand());
    }
}