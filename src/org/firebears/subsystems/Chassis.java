// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.firebears.subsystems;

import org.firebears.RobotMap;
import org.firebears.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Chassis extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon frontLeft = RobotMap.chassisFrontLeft;
    private final CANTalon frontRight = RobotMap.chassisFrontRight;
    private final CANTalon backLeft = RobotMap.chassisBackLeft;
    private final CANTalon backRight = RobotMap.chassisBackRight;
    private final RobotDrive robotDrive = RobotMap.chassisRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double x, double y){
    	robotDrive.arcadeDrive(y, x);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new RobotDriveCommand());
    }
}

